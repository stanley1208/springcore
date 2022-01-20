-- 建立 Emp 資料表
create table if not exists emp(
	eid int not null auto_increment, -- 主鍵(自動產生序號:1,2,3 過號不返回)
	ename varchar(50) not null unique, -- 員工姓名
	age int, -- 員工年齡
	createtime timestamp default current_timestamp, -- 鍵檔時間
	primary key(eid)
)

-- 建立 job 資料表
create table if not exists job(
	jid int not null auto_increment, -- 主鍵(自動產生序號:1,2,3 過號不返回)
	jname varchar(50) not null unique, -- 工作姓名
	eid int, -- 員工 id
	primary key(jid),
	foreign key(eid) references emp(eid) -- 外鍵約束/關聯
)
-- 由上述可知，一個 emp 對應多個 job，一個 job 對應一個 emp

insert into job(jname, eid) values ('report', 1);
insert into job(jname, eid) values ('coding', 3);
insert into job(jname, eid) values ('jobA', 3);
insert into job(jname, eid) values ('jobB', 4);
insert into job(jname, eid) values ('jobC', 7);
insert into job(jname, eid) values ('jobD', 12);
insert into job(jname, eid) values ('jobE', 13);
insert into job(jname, eid) values ('jobF', 1);
insert into job(jname, eid) values ('jobG', 1);
insert into job(jname, eid) values ('jobH', 3);
insert into job(jname, eid) values ('jobI', 12);
insert into job(jname, eid) values ('jobJ', 7);
insert into job(jname, eid) values ('jobK', 4);
insert into job(jname, eid) values ('jobL', 3);
insert into job(jname) values ('jobM');
insert into job(jname) values ('jobN');

-- 每一個員工的工作列表
select e.ename,j.jname
from emp e,job j
where e.eid=j.jid 
order by e.ename

-- 每一個員工有幾項工作
select e.ename,count(j.jname)
from emp e join job j on e.eid=j.jid 
group by e.ename

-- 查詢工作量最多的員工有幾項工作
select e.ename, count(j.jname)
from emp e, job j
where e.eid = j.eid
group by e.ename

select e.ename, count(j.jname) as work 
from emp e, job j
where e.eid=j.eid 
group by e.ename
order by 1

select e.ename , count(j.jid) as "工作數量"
from emp e 
left join job j
on e.eid = j.eid 
group by e.ename