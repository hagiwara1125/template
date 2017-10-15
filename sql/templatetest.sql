drop database if exists templatetest;

create database if not exists templatetest;
use templatetest;


drop table if exists users;

create table users (
user_id int not null primary key auto_icrement, /* 自動作成されるユーザーID */
mail_address varchar(255) unique, /* ログイン用アドレス */
password varchar(255), /* ログイン用パスワード */
login_flg boolean default FALSE, /* 未ログイン0、既ログイン1 */
user_flg int not null default 1, /* 顧客1、管理者3 */
family_name varchar(50) not null, /* 姓(漢字) */
family_name_kana varchar(50) not null, /* 姓(かな) */
given_name varchar(50) not null, /* 名(漢字) */
given_name_kana varchar(50) not null, /* 名(かな) */
user_name varchar(50) not null, /* 氏名 */
sex varchar(10), /* 性別 */
postal varchar(255), /* 郵便番号 */
address varchar(255), /* 住所 */
phone_number varchar(255), /* 電話番号 */
oauth_id varchar(255), /* OAuthID */
oauth_name int default, /* OAuth名 */
oauth_account varchar(100), /* OAuthアカウント */
register_date datetime, /* 登録日 */
update_date datetime /* 更新日 */
);


drop table if exists item;

create table item (
item_id int not null primary key auto_increment, /* 自動作成される商品ID */
item_name varchar(255) not null, /* 商品名 */
item_price decimal(9,2) not null, /* 商品価格(税込) */
item_category int not null, /* 商品カテゴリー */
item_stock int not null, /* 商品在庫数 */
img_path text not null, /* 商品画像 */
comment varchar null, /* 商品詳細 */
);


drop table if exists cart;

create table cart (
cart_id int not null primary key auto_icrement, /* 自動作成されるカートID */
user_id int not null, /* ユーザーID */
item_id int not null, /* 商品ID */
order_count int not null default 1, /* 注文数 */
sub_total decimal(9,2) not null, /* 小計 */
foreign key(user_id) references templatetest.users(user_id),
foreign key(item_id) references templatetest.item(item_id)
);

drop table if exists purchase;

create table purchase (
purchase_id int not null primary key auto_icrement, /* 自動作成される購入ID */
user_id int not null, /* ユーザーID */
item_id int not null, /* 商品ID */
order_count int not null, /* 購入数 */
sub_total decimal(9,2) not null, /* 小計 */
purchase_date datetime not null default current_timestamp, /* 購入日 */
foreign key(user_id) references templatetest.users(user_id),
foreign key(item_id) references templatetest.item(item_id)
);


drop table if exists credit;

create table credit (
credit_id int not null primary key auto_increment, /* 自動作成されるクレジットカードID */
credit_type int not null, /* クレジットカード種類 */
credit_name varchar(100) not null, /* 名義人 */
credit_month int not null, /* 有効期限(月) */
credit_year int not null, /* 有効期限(年) */
security_code varchar(4) not null,/* セキュリティコード */
register_date datetime not null, /* 登録日 */
update_date datetime not null, /* 更新日 */
);


/* insert
 * */

insert int