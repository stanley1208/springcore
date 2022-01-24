-- 交易 TX(Transaction) 所需要的資料表
-- 建立:book (書籍資料)、stock(庫存資料)、wallet(客戶雲端錢包)
-- 建立 book (書籍資料)
create table if not exists book(
	bid integer not null auto_increment,
	bname varchar(20) not null,
	price integer default 0,
	ct timestamp default current_timestamp
	primary key (bid) -- 主鍵
	
);
-- 建立 stock(庫存資料)
create table if not exists stock(
	sid integer not null auto_increment,
	bid integer not null, -- book(書籍資料) 的 id
	amount integer default 0,,
	primary key (sid) -- 主鍵
	foreign key(bid) references book(bidd) -- 外件關聯
	
);
-- 建立 wallet(客戶雲端錢包)
create table if not exists wallet(
	wid integer not null auto_increment,
	wname varchar(20) not null,
	money integer default 0,
	primary key(wid) -- 主鍵
	
);
-- Homework 建立交易紀錄 order_log
-- Vincent 在2020/1/23 PM 2:07:51 買了java書2本共300元
-- Vincent 在2020/1/23 PM 2:08:51 買了python書2本共200元
-- Vincent 在2020/1/23 PM 2:10:51 買了java書4本共600元
-- 注意:若 book 的 price 欄位有變動，order_log 則不影響
-- 試問:資料表應如何創建?