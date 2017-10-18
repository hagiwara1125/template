drop database if exists templatetest;

create database if not exists templatetest;
use templatetest;


drop table if exists users;
drop table if exists item;
drop table if exists cart;
drop table if exists credit;
drop table if exists purchase;
drop table if exists contact;


create table users(
user_id int primary key not null auto_increment,
phone_email varchar(255) unique not null,
password varchar(255) not null,
login_flg boolean default FALSE,
user_flg int not null default 1,
family_name varchar(50) not null,
given_name varchar(50) not null,
family_name_kana varchar(50),
given_name_kana varchar(50),
user_name varchar(50) not null,
sex varchar(10),
postal varchar(255),
address varchar(255),
phone_number varchar(255),
oauth_id varchar(255),
oauth_name int default 0,
oauth_account varchar(100),
register_date datetime,
update_date datetime
);


create table item(
item_id int primary key not null auto_increment,
variation_id int,
item_name varchar(255) not null,
item_category int not null,
item_user int not null,
item_color varchar(255),
item_price decimal(9,2) not null,
item_stock int not null,
img_path text not null,
item_comment text,
item_flg boolean not null default true,
release_flg boolean not null default false
);


create table cart(
cart_id int primary key not null auto_increment,
user_id int not null,
item_id int not null,
order_count int default 1,
sub_total decimal(9,2) not null,
foreign key(user_id) references users(user_id),
foreign key(item_id) references item(item_id)
);


create table credit(
credit_id int primary key not null auto_increment,
credit_type int not null,
credit_number varchar(16) not null,
security_code varchar(4) not null,
credit_name varchar(100) not null,
expiration_year int not null,
expiration_month int not null,
redistration_date datetime not null default current_timestamp,
updated_date datetime not null
);


create table purchase(
purchase_id int primary key not null auto_increment,
user_id int not null,
item_id int not null,
order_count int not null,
sub_total decimal(9,2) not null,
purchase_date datetime not null default current_timestamp,
foreign key(user_id) references users(user_id),
foreign key(item_id) references item(item_id)
);


create table contact(
contact_name varchar(255),
contact_email varchar(255),
contact_title varchar(255),
contact_comment varchar(255) not null,
contact_date datetime not null default current_timestamp
);



INSERT INTO users(phone_email, password, login_flg, user_flg, family_name, given_name, family_name_kana, given_name_kana,
user_name, sex, postal, address, phone_number, oauth_id, oauth_name, oauth_account, register_date, update_date) VALUE
('internous01@gmail.com','internous01',FALSE,1,'田中','太郎','タナカ','タロウ','田中太郎','男','1130034','東京都文京区湯島3-2-12　御茶ノ水天神ビル','0123456798','',0,'','2017-10-17 00:00:00','2017/10/17 00:00:00'),
('internous02@gmail.com','internous01',FALSE,1,'山田','花子','ヤマダ','ハナコ','山田花子','女','1130034','東京都文京区湯島3-2-12　御茶ノ水天神ビル','0123456798','',0,'','2017-10-17 00:00:00','2017/10/17 00:00:00'),
('internous03@gmail.com','internous01',FALSE,1,'佐藤','次郎','タナカ','タロウ','田中太郎','男','1130034','東京都文京区湯島3-2-12　御茶ノ水天神ビル','0123456798','',0,'','2017-10-17 00:00:00','2017/10/17 00:00:00'),
('internous04@gmail.com','internous01',FALSE,1,'鈴木','孝史','タナカ','タロウ','田中太郎','男','1130034','東京都文京区湯島3-2-12　御茶ノ水天神ビル','0123456798','',0,'','2017-10-17 00:00:00','2017/10/17 00:00:00');



-- variation_id(1:猫ネックレス)
-- item_category(1:キッチン用品, 2:インテリア, 3:文房具, 4:ファッション小物, 5:アクセサリー, 6:ごはん, 7:おやつ, 8:おもちゃ, 9:日用品)
-- item_user(1:飼い主, 2:猫)
INSERT INTO item(variation_id, item_name, item_category, item_user, item_color, item_price, item_stock, img_path, item_comment, item_flg, release_flg) VALUE
(1, 'CatMonn ネックレス', 3, 1, 'nomal', 1000, 100, 'img/item/bookmark.jpg,', 'にゃんこのネックレス', true, true),
(1, 'CatMoon ネックレス', 3, 1, 'blue', 1000, 100, 'img/item/gosyuin_pink.jpg', 'にゃんこのネックレス', true, true),
(1, 'CatMoon ネックレス', 3, 1, 'nomal', 1000, 100, 'img/item/gosyuinire_beju.jpg', 'にゃんこのネックレス', true, true),
(1, 'CatMoon ネックレス', 3, 2, 'red', 1000, 100, 'img/item/passcase.jpg', 'にゃんこのネックレス', true, true),
(1, 'CatMoon ネックレス', 3, 2, 'yellow', 1000, 100, 'img/item/ryuck_kuroneko.jpg', 'にゃんこのネックレス', true, true);