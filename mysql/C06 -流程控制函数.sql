SELECT * FROM emp;
SELECT ename, comm FROM emp;
-- 为何不行
SELECT ename, REPLACE(comm, NULL, 1.5) FROM emp;

SELECT ename, IF(comm IS NULL, 0.0, comm) FROM emp;
SELECT ename, IFNULL(comm, 0.0) FROM emp;

SELECT ename, (SELECT CASE 
    WHEN job = 'CLERK' THEN '职员' 
    WHEN job = 'MANAGER' THEN '经理'
    WHEN job = 'SALESMAN' THEN '销售人员' 
    ELSE job END) AS 'job'
  FROM emp; 