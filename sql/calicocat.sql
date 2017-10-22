drop database if exists calicocat;

create database if not exists calicocat;
use calicocat;

drop table if exists users;
drop table if exists item;
drop table if exists cart;
drop table if exists purcahse;
drop table if exists credit;
drop table if exists inquiry;


/*会員情報*/
create table users(
user_id int primary key not null auto_increment, /*ユーザーID*/
phone_email varchar(255) unique not null, /*ログイン用メールアドレス*/
password varchar(255) not null, /*ログイン用パスワード*/
login_flg int not null default 0, /*ログインフラグ*/
user_flg int not null default 1, /*ユーザーフラグ*/
delete_flg boolean not null default FALSE, /*削除フラグ*/
family_name varchar(50) not null, /*姓*/
family_name_kana varchar(50), /*姓(カナ)*/
given_name varchar(50) not null, /*名*/
given_name_kana varchar(50), /*名(カナ)*/
user_name varchar(50) not null, /*氏名*/
sex varchar(10), /*性別*/
postal varchar(30), /*郵便番号*/
address varchar(255), /*住所*/
phone_number varchar(50), /*電話番号*/
oauth_id varchar(255), /*OAuthID*/
oauth_name int default 0, /*OAuth名*/
oauth_account varchar(100), /*OAuthアカウント*/
register_date datetime not null default current_timestamp, /*登録日*/
update_date datetime not null default current_timestamp on update current_timestamp /*更新日*/
);


/*商品情報*/
create table item(
item_id int primary key not null auto_increment, /*商品ID*/
variation_id int, /*バリエーションID*/
item_category int not null, /*商品カテゴリ*/
item_user int not null, /*使用者*/
item_name varchar(255) not null, /*商品名*/
item_color varchar(255), /*色*/
item_price decimal(9,2) not null, /*価格*/
item_stock int, /*在庫数*/
img_path text not null, /*画像パス*/
item_comment text, /*商品説明*/
item_page int, /*ページ番号*/
category_page int, /*カテゴリ別ページ番号*/
registration_date datetime not null default current_timestamp,/*登録日*/
updation_date datetime not null default current_timestamp on update current_timestamp,/*更新日*/
deleted_flg boolean default FALSE /*削除フラグ*/
);


/*カート*/
create table cart(
cart_id int primary key not null auto_increment, /*カートID*/
user_id int not null, /*ユーザーID*/
item_id int not null, /*商品ID*/
order_count int default 1, /*注文数*/
sub_total decimal(9,2) not null, /*小計*/
foreign key(user_id) references users(user_id),
foreign key(item_id) references item(item_id)
);


/*購入履歴*/
create table purchase(
purchase_id int primary key not null auto_increment, /*購入ID*/
user_id int not null, /*ユーザーID*/
item_id int not null, /*商品ID*/
order_count int not null, /*注文数*/
sub_total decimal(9,2) not null, /*小計*/
purchase_date datetime not null default current_timestamp, /*購入日*/
foreign key(user_id) references users(user_id),
foreign key(item_id) references item(item_id)
);


/*クレジットカード*/
create table credit(
credit_id int primary key not null auto_increment, /*クレジットカードID*/
credit_type int not null, /*クレジットカード種類*/
credit_number varchar(16), /*クレジットカード番号*/
credit_name varchar(50) not null, /*名義人*/
security_code int, /*セキュリティコード*/
expiration_month int not null, /*有効期限(月)*/
expiration_year int not null, /*有効期限(年)*/
created_date datetime not null default current_timestamp, /*登録日*/
updated_date datetime not null, /*更新日*/
deleted_date datetime not null /*削除日*/
);


/*問い合わせ*/
create table inquiry(
inquiry_id int primary key not null auto_increment, /*問い合わせID*/
inquiry_name varchar(255), /*問い合わせ者氏名*/
inquiry_email varchar(255), /*メールアドレス*/
inquiry_title varchar(255), /*件名*/
inquiry_comment text, /*内容*/
inqyiry_date datetime /*問い合わせ日*/
);


-- login_flg(0:未ログイン, 1:既ログイン)
-- user_flg(1:顧客, 3:管理者)
INSERT INTO users(phone_email, password, login_flg, user_flg, delete_flg, family_name, family_name_kana, given_name, given_name_kana, user_name, sex, postal, address, phone_number, register_date, update_date) VALUE
('user.test01@gmail.com', 'testuser', 0, 1, false, '田中', 'タナカ', '太郎', 'タロウ', '田中太郎', '男', '1130034', '東京都文京区湯島3-2-12　御茶ノ水天神ビル', '0123456798', '2017-10-21 00:00:00', '2017-10-21 00:00:00');


-- variation_id(1:,)
-- item_category(1:キッチン用品, 2:インテリア, 3:文房具, 4:ファッション小物, 5:アクセサリー, 11:ごはん, 12:おやつ, 13:おもちゃ, 14:日用品)
-- item_user(1:愛猫家, 3:ねこ)
INSERT INTO item(variation_id, item_category, item_user, item_name, item_color, item_price, item_stock, img_path, item_comment, category_page) VALUE
(1, 1, 1, 'グラス', 'nomal', 1000, 100, './img/item/glass.jpg', 'グラスペアセット', 1);