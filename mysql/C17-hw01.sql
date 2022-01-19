SELECT DISTINCT dname FROM dept;
SELECT ename, sal*12+IFNULL(comm, 0) AS 年收入 FROM emp;

SELECT ename,sal FROM emp
	WHERE sal>2850;

SELECT ename,sal FROM emp
	WHERE sal<1500 OR sal>2850;
	
SELECT ename, sal FROM emp
	WHERE NOT(sal BETWEEN 1500 AND 2850);
	

SELECT ename, sal, deptno FROM emp
	WHERE sal>1500 
	AND deptno IN (10, 30);
	
SELECT ename, mgr FROM emp
	WHERE mgr IS NULL;
	
SELECT ename, job, hiredate FROM emp
	WHERE hiredate BETWEEN '1991-02-01' AND '1991-05-01'
	ORDER BY hiredate;

SELECT ename, sal, comm FROM emp
	WHERE comm IS NOT NULL
	ORDER BY sal DESC;
	
SELECT * FROM emp
	WHERE job = 'MANAGER'
	OR (job = 'CLERK' AND deptno = 20)
	OR (job NOT IN('MANAGER', 'CLERK') AND sal >= 2000);

SELECT DISTINCT job FROM emp
	WHERE comm IS NOT NULL;

SELECT ename, comm FROM emp
	WHERE IFNULL(comm, 0) < 400;

-- 四种方法
SELECT ename, hiredate FROM emp
	WHERE MONTH(DATE_ADD(hiredate, INTERVAL 2 DAY)) = MONTH(hiredate)
	AND MONTH(DATE_ADD(hiredate, INTERVAL 3 DAY)) != MONTH(hiredate);


SELECT ename, hiredate FROM emp
	WHERE DAY(DATE_ADD(hiredate, INTERVAL 3 DAY)) = 1;


SELECT ename, hiredate FROM emp
	WHERE DATE_ADD(hiredate, INTERVAL 2 DAY) = LAST_DAY(hiredate);
	
SELECT ename, hiredate FROM emp
	WHERE hiredate + 2 = LAST_DAY(hiredate);
	
SELECT MONTH('2013-11-10') FROM DUAL;



SELECT ename, hiredate FROM emp
	WHERE DATE_ADD(hiredate, INTERVAL 25 YEAR) < NOW();
	
SELECT CONCAT(LCASE(LEFT(ename,1)), SUBSTRING(ename, 2)) AS `name` FROM emp;

SELECT ename FROM emp
	WHERE LENGTH(ename) = 5;