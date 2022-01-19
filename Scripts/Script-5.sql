select e.eid,e.ename,e.age,e.createtime,
	   j.jid as job_jid,j.jname as job_jname,j.eid as job_eid
from emp e left outer join j on j.eid=e.eid 