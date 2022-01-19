CREATE VIEW emp_view01 
	AS
	SELECT empno, ename, job, deptno FROM emp;

DESC emp_view01;
SELECT * FROM emp_view01;

SHOW CREATE VIEW emp_view01;

ALTER VIEW emp_view01 
	AS
	SELECT empno, ename, job FROM emp;