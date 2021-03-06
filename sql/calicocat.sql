drop database if exists calicocat;

create database if not exists calicocat;
use calicocat;

drop table if exists users;
drop table if exists item;
drop table if exists cart;
drop table if exists purcahse;
drop table if exists credit_card;
drop table if exists inquiry;



-- CREATE


/*会員情報*/
create table users(
user_id int primary key not null auto_increment, /*ユーザーID */
phone_email varchar(255) unique not null, /*ログイン用メールアドレス */
password varchar(255) not null, /*ログイン用パスワード */
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
/*variation_id int,*/ /*バリエーションID*/
item_category int not null, /*商品カテゴリ*/
item_name varchar(255) not null, /*商品名*/
/*item_color varchar(255), 色*/
item_price decimal(9,2) not null, /*価格*/
item_stock int, /*在庫数*/
img_path text not null, /*画像パス*/
item_comment text, /*商品説明*/
/*item_page int,*/ /*ページ番号*/
/*category_page int,*/ /*カテゴリ別ページ番号*/
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


/*クレジットカード情報*/
create table credit_card(
credit_id int not null primary key auto_increment, /*クレジットカードID*/
credit_type varchar(20) unique not null, /*クレジットカード種類*/
credit_number varchar(20) not null, /*クレジットカード番号*/
credit_holder varchar(50) not null, /*名義人*/
expiration_month varchar(2) not null, /*有効期限(月)*/
expiration_year varchar(4) not null, /*有効期限(年)*/
security_code varchar(4) not null /*セキュリティコード*/
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


-- CREATE



-- INSERT


/*会員情報*/
-- login_flg(0:未ログイン, 1:既ログイン)
-- user_flg(1:顧客, 3:管理者)
INSERT INTO users(phone_email, password, login_flg, user_flg, delete_flg, family_name, family_name_kana, given_name, given_name_kana, user_name, sex, postal, address, phone_number, register_date, update_date) VALUE
('user.test01@gmail.com', 'testuser', 0, 1, false, 'テスト', 'テスト', 'ユーザー1', 'ユーザー1', 'テストユーザー1', '男', '1130034', '東京都文京区湯島3-2-12　御茶ノ水天神ビル', '0123456798', '2017-10-21 00:00:00', '2017-10-21 00:00:00'),
('user.test02@gmail.com', 'testuser', 0, 1, false, 'テスト', 'テスト', 'ユーザー2', 'ユーザー2', 'テストユーザー2', '女', '1130034', '東京都文京区湯島3-2-12　御茶ノ水天神ビル', '0123456798', '2017-10-21 00:00:00', '2017-10-21 00:00:00'),
('user.test03@gmail.com', 'testuser', 0, 1, false, 'テスト', 'テスト', 'ユーザー3', 'ユーザー3', 'テストユーザー3', '男', '1130034', '東京都文京区湯島3-2-12　御茶ノ水天神ビル', '0123456798', '2017-10-21 00:00:00', '2017-10-21 00:00:00'),
('user.test04@gmail.com', 'testuser', 0, 1, false, 'テスト', 'テスト', 'ユーザー4', 'ユーザー4', 'テストユーザー4', '女', '1130034', '東京都文京区湯島3-2-12　御茶ノ水天神ビル', '0123456798', '2017-10-21 00:00:00', '2017-10-21 00:00:00'),
('user.test05@gmail.com', 'testuser', 0, 1, false, 'テスト', 'テスト', 'ユーザー5', 'ユーザー5', 'テストユーザー5', '男', '1130034', '東京都文京区湯島3-2-12　御茶ノ水天神ビル', '0123456798', '2017-10-21 00:00:00', '2017-10-21 00:00:00'),
('admin.test01@gmail.com', 'testadmin', 0, 3, false, 'テスト', 'テスト', '管理者1', 'カンリシャ1', 'テスト管理者1', '女', '1130034', '東京都文京区湯島3-2-12　御茶ノ水天神ビル', '0123456798', '2017-10-21 00:00:00', '2017-10-21 00:00:00'),
('admin.test02@gmail.com', 'testadmin', 0, 3, false, 'テスト', 'テスト', '管理者2', 'カンリシャ2', 'テスト管理者2', '男', '1130034', '東京都文京区湯島3-2-12　御茶ノ水天神ビル', '0123456798', '2017-10-21 00:00:00', '2017-10-21 00:00:00'),
('admin.test03@gmail.com', 'testadmin', 0, 3, false, 'テスト', 'テスト', '管理者3', 'カンリシャ3', 'テスト管理者3', '女', '1130034', '東京都文京区湯島3-2-12　御茶ノ水天神ビル', '0123456798', '2017-10-21 00:00:00', '2017-10-21 00:00:00'),
('admin.test04@gmail.com', 'testadmin', 0, 3, false, 'テスト', 'テスト', '管理者4', 'カンリシャ4', 'テスト管理者4', '男', '1130034', '東京都文京区湯島3-2-12　御茶ノ水天神ビル', '0123456798', '2017-10-21 00:00:00', '2017-10-21 00:00:00'),
('admin.test05@gmail.com', 'testadmin', 0, 3, false, 'テスト', 'テスト', '管理者5', 'カンリシャ5', 'テスト管理者5', '女', '1130034', '東京都文京区湯島3-2-12　御茶ノ水天神ビル', '0123456798', '2017-10-21 00:00:00', '2017-10-21 00:00:00');


/*商品情報*/
-- variation_id(1:,)
-- item_category(1:キッチン用品, 2:インテリア, 3:文房具, 4:ファッション小物, 11:ごはん, 12:おやつ, 13:おもちゃ, 14:日用品)
-- item_user(1:愛猫家, 3:ねこ)
INSERT INTO item(item_category, item_name, item_price, item_stock, img_path, item_comment) VALUE
(1, 'マドラー＆コースター付きペアグラス', 2000, 100, './img/item/glass.jpg', 'ペアのグラスセット。<br>フォルムも可愛いお品物です。<br>マドラーとコースターも２点ずつ付いてきちゃいます！'),
(1, '白黒ペアマグカップ', 1800, 100, './img/item/shirokuro_magcup.jpg', 'ころんとした形のペアのマグカップセットです。<br>こちら、同デザインのティースプーン付きとなります。'),
(2, 'ふわふわクッション', 1500, 100, './img/item/huwahuwa_cushion.jpg', '一度抱っこすると、やみつきになってしまう、ふわふわのクッションです。<br>ご自宅の洗濯機でも洗えるのでお手入れも簡単！'),
(3, 'ブックマーカー', 300, 100, './img/item/bookmark.jpg', 'シンプルでおしゃれなデザインのブックマーカー。<br>本に挟むと、まるで本の上をお散歩しているように見えます。'),
(3, '御朱印帳', 1000, 100, './img/item/gosyuin_pink.jpg', 'ピンクが可愛らしい和紙の表紙の御朱印帳です。<br>お寺さん巡りのお供に一冊どうそ。'),
(4, '月のネックレス', 1200, 100, './img/item/necklace.jpg', 'お月さまに猫がのったおしゃれなデザインです。<br>お星さまはゆらゆら揺れますよ。'),
(4, 'ハートのネックレス', 1200, 100, './img/item/neklase_kisaragi_amesist.jpg', 'ハートリングの中には２つのストーン。<br>紫色が映えアクセントとなっています。'),
(4, 'シルバーリング', 600, 100, './img/item/ring.jpg', 'シンプルかつ、洗練されたデザイン。<br>お顔の部分にはストーンが付いていて、きらきらと綺麗です。'),
(4, '黒猫パスケース', 800, 100, './img/item/passcase.jpg', '猫の目とひげが刺繍されたシンプルなパスケースです。<br>カードを入れるところが、猫の耳の形になっています。');


/*クレジットカード情報*/
INSERT INTO credit_card(credit_type, credit_number, credit_holder, expiration_month, expiration_year, security_code) VALUE
('Pisa', '4111-1111-1111-1112', 'testuser', '11', '2020', '123'),
('Americanexcite', '3782-8278-0000-1111', 'testuser', '11', '2020', '123'),
('Sistercard', '5555-5500-0000-0001', 'testuser', '11', '2020', '123');


-- INSERT