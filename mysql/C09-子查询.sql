-- 显示与smith同一部门的员工

SELECT deptno FROM emp WHERE ename='SMITH';

SELECT * FROM emp 
	WHERE deptno = (
		SELECT deptno FROM emp
		WHERE ename='SMITH'
	);
	
SELECT DISTINCT job FROM emp WHERE deptno = 10;

SELECT ename,job,sal,deptno 
	FROM emp
	WHERE job IN ( SELECT DISTINCT job FROM emp WHERE deptno = 10)
	AND deptno <> 10;

SELECT cat_id, MAX(shop_price) 
	FROM ecs_goods
	GROUP BY cat_id;
	
SELECT temp.cat_id, goods_id, goods_name, shop_price
	FROM ecs_goods, (
		SELECT cat_id, MAX(shop_price) AS max_price
		FROM ecs_goods
		GROUP BY cat_id
		) temp
	WHERE ecs_goods.cat_id = temp.cat_id 
	AND ecs_goods.shop_price = max_price;


SELECT ename,sal,deptno 
	FROM emp
	WHERE sal > (SELECT MAX(sal) FROM emp WHERE deptno = 30);
	
SELECT ename,sal,deptno 
	FROM emp
	WHERE sal > ALL (SELECT sal FROM emp WHERE deptno = 30);
	

SELECT * 
	FROM emp, (
		SELECT deptno,AVG(sal) AS avg_sal
		FROM emp 
		GROUP BY deptno
		) temp
	WHERE emp.`deptno` = temp.deptno
	AND emp.`sal` > avg_sal;
	


SELECT dname, temp.deptno, loc, people
	FROM dept, ( 
		SELECT deptno, COUNT(*) AS people 
		FROM emp
		GROUP BY deptno
		) temp
	WHERE temp.deptno = dept.`deptno`;
	
SELECT dept.*, people
	FROM dept, ( 
		SELECT deptno, COUNT(*) AS people 
		FROM emp
		GROUP BY deptno
		) temp
	WHERE temp.deptno = dept.`deptno`;