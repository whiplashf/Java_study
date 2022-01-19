-- P816 作业5
-- 1 
SELECT dname, c AS 人数
	FROM dept, (
		SELECT COUNT(*) AS c, deptno FROM emp
			GROUP BY deptno
			HAVING c>0
		) AS tmp
	WHERE dept.`deptno` = tmp.deptno;
	
-- 2 单行子查询
SELECT ename, sal FROM emp
	WHERE sal > (
		SELECT sal FROM emp WHERE ename='SMITH'
		);
		
-- 3 自连接
SELECT e1.ename 
	FROM emp e1, emp e2
	WHERE e1.mgr = e2.empno
	AND e1.`hiredate`>e2.`hiredate`;
	
-- 4 外连接
SELECT dname, ename, dept.deptno
	FROM dept LEFT JOIN emp
	ON dept.deptno = emp.`deptno`
	ORDER BY dname;
	
-- 5 连接, 类似3
SELECT ename, dname
	FROM emp, dept
	WHERE job = 'CLERK'
	AND emp.`deptno` = dept.`deptno`;
	
-- 6 分组having
SELECT job 
	FROM emp
	GROUP BY job 
	HAVING MIN(sal)>1500; 

-- 7 连接
SELECT ename 
	FROM emp, dept
	WHERE emp.`deptno`  = dept.`deptno`
	AND dname = 'SALES';
	
-- 8 
SELECT ename, sal
	FROM emp
        WHERE sal >= (
		SELECT AVG(sal) FROM emp);
	

