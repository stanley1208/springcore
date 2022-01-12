-- 建立 Emp 資料表
create table if not exists emp(
	eid int not null auto_increment, -- 主鍵(自動產生序號:1,2,3 過號不返回)
	ename varchar(50) not null unique, -- 員工姓名
	age int, -- 員工年齡
	createtime timestamp default current_timestamp, -- 鍵檔時間
	primary key(eid)
)