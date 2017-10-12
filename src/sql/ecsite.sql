drop database if exists ecsite;

create database if not exists ecsite;
use ecsite;

drop table if exists login_user_transaction;

create table login_user_transaction(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
insert_date datetime,
updated_date datetime
);

drop table if exists item_info_transaction;

create table item_info_transaction(
id int not null primary key auto_increment,
item_name varchar(30),
item_price int,
item_stock int,
insert_date datetime,
update_date datetime
);

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
id int not null primary key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
insert_date datetime,
delete_date datetime
);



/*ここから自作*/

drop table if exists users;

create table users (
user_id int not null auto_increment,/*自動で作成されるユーザーID*/
mail_address varchar(255) unique,/*ログイン時に必要なメールアドレス*/
password varchar(255),/*ログイン時に必要なパスワード*/
user_name varchar(255),/*ユーザー名*/
login_flg int default 0,/*未ログイン時0、顧客1、管理者3*/
insert_date datetime,/*登録日*/
updated_date datetime/*更新日*/
);


drop table if exists item;

create table item (
item_id int not null primary key auto_increment,/*自動で作成される商品ID*/
item_name varchar(30) null default null,/*商品名*/
item_price decimal(10,0) null default null,/*商品価格(税込)*/
item_stock int(11) default 50,/*商品在庫*/
order_count int(11),/*注文数*/
comment varchar null,/*商品説明*/
img varchar(100) null default null,/*商品画像*/
);


drop table if exists cart;

create table cart(
cart_id int not null primary key auto_increment,/*自動で作成されるカートID*/
user_id int not null,/*usersのuser_idを参照*/
item_id int not null,/*itemのitem_idを参照*/
order_count int not null,/*注文数*/
price decimal(10,0) null default null,/*商品価格(税込)*/
registration_date timestamp not null default current_timestamp,/*購入日*/
update_date timestamp not null default current_timestamp,/*更新日*/
is_deleted boolean default false,/*商品選択削除*/
foreign key(user_id)) references ecsite.users(user_id) on delete cascade,
foreign key(item_id) references ecsite.item(item_id) on delete cascade
);


drop table if exists purchase;

create table purchase (
cart_id int not null primary key auto_icrement,
user_id int not null,
item_id int not null,
order_count int not null,
price decimal(10,0) null default null,

);

/*ここまで自作*/


INSERT INTO item_info_transaction(item_name, item_price, item_stock) VALUES("ノートBook", 100, 50);
INSERT INTO login_user_transaction(login_id, login_pass, user_name) VALUES("internous", "internous01", "test");