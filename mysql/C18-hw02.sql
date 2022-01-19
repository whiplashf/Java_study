-- P815 作业4
SELECT ename FROM emp
	WHERE ename NOT LIKE '%R%';

SELECT LEFT(ename, 3) FROM emp;

SELECT REPLACE(ename, 'A', 'a') FROM emp;

SELECT ename, hiredate FROM emp
	WHERE DATE_ADD(hiredate, INTERVAL 10 YEAR) < NOW();
	
SELECT * FROM emp
	ORDER BY ename;

SELECT ename, hiredate FROM emp
	ORDER BY hiredate;
-- 19
SELECT ename, job, sal FROM emp
	ORDER BY job DESC, sal;

SELECT ename, YEAR(hiredate), MONTH(hiredate) FROM emp
		ORDER BY MONTH(hiredate), YEAR(hiredate);
-- 21
SELECT ename, FLOOR((sal+IFNULL(comm,0))/30) FROM emp;

SELECT ename, hiredate FROM emp
	WHERE MONTH(hiredate) = 2;
	
SELECT ename, DATEDIFF(NOW(), hiredate) 入职天数 FROM emp;

SELECT ename FROM emp
	WHERE ename LIKE '%A%';
	
SELECT ename, DATE_ADD(hiredate, INTERVAL ') from emp
	
