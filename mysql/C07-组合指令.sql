SELECT * FROM emp WHERE hiredate >= '1992-01-01';
 
SELECT ename, sal FROM emp WHERE ename LIKE '__O%';
 
SELECT * FROM emp WHERE mgr IS NULL;
 
DESC emp;

SELECT * FROM emp ORDER BY sal DESC;

SELECT * FROM emp ORDER BY deptno, sal DESC;

SELECT * FROM emp ORDER BY ename DESC 
	LIMIT 20, 5; 
	
SELECT job, FORMAT(AVG(sal), 2), COUNT(*) FROM emp GROUP BY job;

SELECT COUNT(*) AS 总人数, COUNT(comm) AS 补助人 FROM emp;

SELECT COUNT(DISTINCT mgr) FROM emp;

SELECT DISTINCT mgr FROM emp;

SELECT AVG(sal), MIN(sal), deptno, job, COUNT(*) FROM emp GROUP BY deptno, job; 

SELECT deptno, AVG(sal) AS avs FROM emp GROUP BY deptno HAVING avs>1000 ORDER BY avs DESC
	LIMIT 0, 2;