CREATE TABLE `goods` (
id INT,
goods_name VARCHAR(10),
price DOUBLE );

-- 添加数据
INSERT INTO goods (id, goods_name, price) VALUES( 10, '华为手机', 2000);

INSERT INTO goods (id, goods_name, price) VALUES(20, '苹果手机', 3000);

DESC goods

SHOW DATABASES

SELECT * FROM goods

INSERT INTO goods VALUES(30, '小米手机', 1000);

UPDATE goods SET price = 2000 WHERE id = 30;

UPDATE goods SET price = price+2000 WHERE id = 30;


INSERT INTO t3 VALUES(77,66);
DELETE FROM t3;

-- select 语句【重点 难点】
CREATE TABLE student(
	id INT NOT NULL DEFAULT 1,
	NAME VARCHAR(20) NOT NULL DEFAULT '',
	chinese FLOAT NOT NULL DEFAULT 0.0,
	english FLOAT NOT NULL DEFAULT 0.0,
	math FLOAT NOT NULL DEFAULT 0.0
);

INSERT INTO student(id,NAME,chinese,english,math) VALUES(1,'韩顺平',89,78,90);
INSERT INTO student(id,NAME,chinese,english,math) VALUES(2,'张飞',67,98,56);
INSERT INTO student(id,NAME,chinese,english,math) VALUES(3,'宋江',87,78,77);
INSERT INTO student(id,NAME,chinese,english,math) VALUES(4,'关羽',88,98,90);
INSERT INTO student(id,NAME,chinese,english,math) VALUES(5,'赵云',82,84,67);
INSERT INTO student(id,NAME,chinese,english,math) VALUES(6,'欧阳锋',55,85,45);
INSERT INTO student(id,NAME,chinese,english,math) VALUES(7,'黄蓉',75,65,30);
INSERT INTO student(id,NAME,chinese,english,math) VALUES(8,'韩信',45,65,99);

-- 查询表中所有学生的信息。
SELECT * FROM student;
-- 查询表中所有学生的姓名和对应的英语成绩。
SELECT `name`,english FROM student;
-- 过滤表中重复数据 distinct 。
SELECT DISTINCT english FROM student;
-- 要查询的记录，每个字段都相同，才会去重
SELECT DISTINCT `name`, english FROM student;

SELECT `name` AS '姓名', english+math AS '总分' FROM student;

SELECT * FROM student WHERE chinese BETWEEN 88 AND 89;

SELECT * FROM student ORDER BY chinese DESC;

SELECT `name` , (chinese + english + math) AS math FROM student 
  ORDER BY math DESC;
  
SELECT COUNT(*) FROM student;

SELECT SUM(math) AS math_total_score, SUM(english), SUM(chinese) FROM student;
SELECT SUM(math + english + chinese) FROM student;

SELECT SUM(`name`) FROM student;