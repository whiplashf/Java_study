SELECT ename, sal, dname, emp.`deptno` FROM emp, dept
	WHERE emp.`deptno` = dept.`deptno`;
	
SELECT ename, sal, dname, emp.`deptno` FROM emp, dept
	WHERE emp.`deptno` = dept.`deptno` 
	ORDER BY emp.`deptno` DESC;
	
SELECT COUNT(dname) FROM emp, dept
	WHERE emp.`deptno` = dept.`deptno` AND emp.`deptno`=10;
	
SELECT ename, sal, grade FROM emp, salgrade
	WHERE sal BETWEEN losal AND hisal;

SELECT worker.ename AS 'worker', boss.`ename` AS 'boss' FROM emp worker, emp boss
	WHERE worker.`mgr` = boss.`empno`;