select e.ename,max(j.jname)
from emp e inner join job j on e.eid=j.jid
group by e.ename

