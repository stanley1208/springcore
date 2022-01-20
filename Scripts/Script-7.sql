select e.ename,count(j.jname)
from emp e join job j on e.eid=j.jid 
group by e.ename