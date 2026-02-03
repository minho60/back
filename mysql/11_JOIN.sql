CREATE TABLE department (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(30)
);

CREATE TABLE employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(30),
    salary INT,
    dept_id INT
);

INSERT INTO department VALUES
(10, '개발'),
(20, '인사'),
(30, '영업');

INSERT INTO employee VALUES
(1, '홍길동', 4000, 10),
(2, '이순신', 5000, 10),
(3, '강감찬', 3500, 20),
(4, '유관순', 3000, NULL);

/* 
    조인(JOIN)
        1. [내부] 조인: [inner] join
        2. 외부 조인
            - 왼쪽 [외부] 조인: left [outer] join
            - 오른쪽 [외부] 조인: right [outer] join
 */


--1. 사원(employee)이 속한 부서(department) 이름(emp_name)을 함께 조회하시오.
/* 
    내부조인(INNER JOIN)
        SELECT [테이블].필드,...
        FROM 테이블1 
        INNER JOIN 테이블2
        ON 테이블1.컬럼 = 테이블2.컬럼;

 */
SELECT * FROM employee;
SELECT * FROM department;

SELECT e.emp_name , d.dept_name 
FROM employee e
INNER JOIN department d
ON e.dept_id = d.dept_id;


SELECT e.emp_name , d.dept_name 
FROM employee e
RIGHT JOIN department d
ON e.dept_id = d.dept_id;





--2. 부서가 없는 사원도 포함하여 사원명과 부서명을 조회하시오.
-- 왼쪽 외부조인
/* 
    SELECT 테이블.컬럼 AS 별칭, 테이블.컬럼 AS 별칭
    FROM 테이블 AS 별칭
    LEFT [outer] JOIN 테이블 AS 별칭
    ON 테이블1.컬럼 = 테이블2.컬럼;
 */
SELECT e.emp_name , d.dept_name 
FROM employee e
LEFT JOIN department d
ON e.dept_id = d.dept_id;

--3. 소속 사원이 없는 부서도 포함하여 조회하시오.
SELECT e.emp_name , d.dept_name 
FROM employee e
RIGHT JOIN department d
ON e.dept_id = d.dept_id;
WHERE e.emp_name IS NULL;

--4. 사원과 부서의 모든 조합을 조회하시오.
-- 교차 조인(cross join, 카티션 곱)
/* 
    두 테이블의 모든 조합을 조회
        SELECT 컬럼
        FROM 테이블1
        CROSS JOIN 테이블2;
 */

SELECT e.emp_name , d.dept_name 
FROM employee e
CROSS JOIN department d;

--5. 같은 테이블을 사용하여 사원끼리 이름을 나란히 조회하시오.
-- 자기조인(self join)
/* 
    같은 테이블을 두 번 이상 사용하는 조인

        SELECT 컬럼, ...
        FROM 테이블1 AS 별칭1
        JOIN 테이블1 AS 별칭2
        ON 별칭1.컬럼 = 별칭2.컬럼
 */
SELECT e1.emp_name AS 이름1, e2.emp_name AS 이름2 
FROM employee e1
JOIN employee e2
ON e1.emp_id <> e2.emp_id;

-- FULL OUTER JOIN (MySQL8은 지원하지 않음)
-- UNION 연산자로 LEFT RIGHT 결합

SELECT e.emp_name AS 이름, d.dept_name AS 이름
FROM employee e
LEFT JOIN department d ON e.dept_id= d.dept_id
UNION
SELECT e.emp_name AS 이름, d.dept_name AS 이름
FROM employee e
RIGHT JOIN department d ON e.dept_id= d.dept_id;
SELECT *
FROM employee e
LEFT JOIN department d ON e.dept_id= d.dept_id
UNION
SELECT *
FROM employee e
RIGHT JOIN department d ON e.dept_id= d.dept_id
WHERE e.dept_id IS NULL OR d.dept_id IS NULL;


--6. USING 절을 사용하여 사원과 부서를 조인하시오.
/* 
    USING 절
        - 공통
 */
SELECT e.emp_name AS 이름, d.dept_name AS 부서
FROM employee e
JOIN department d
USING (dept_id);

--7. 공통 컬럼을 기준으로 자동 조인을 수행하시오.
/* 
    SELECT 컬럼, ...
    FROM 테이블1 AS 별칭1
    NATURAL JOIN 테이블1 AS 별칭2


 */
SELECT e.emp_name AS 이름, d.dept_name AS 부서
FROM employee e
NATURAL JOIN department d;

--8. 개발 부서 사원만 조회하시오.
SELECT e.emp_name, d.dept_name
FROM employee e
JOIN department d
ON e.dept_id = d.dept_id
WHERE d.dept_name = '개발';

--9. 부서별 평균 급여를 조회하시오.
SELECT d.dept_name, AVG(e.salary) AS avg_salary
FROM employee e
JOIN department d
ON e.dept_id = d.dept_id
GROUP BY d.dept_name;


--10. 부서가 없는 사원만 조회하시오.
SELECT emp_name
FROM employee
WHERE dept_id IS NULL;