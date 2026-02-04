/* 
    WITH 문
        - CTE(공통 테이블 표현식)을 정의하여 
          쿼리를 더 읽기 쉽고 유지보수 가능하게 만드는 데 사용
        - SELECT, INSERT, UPDATE, DELETE 문 내부에서 사용
          여러 번 사용될 수 있다.
        - 서브쿼리와 유사한 기능을 제공하지만, 
          가독성과 성능 면에서 좋다.
        - 재귀 쿼리에도 사용할 수 있다.

    기본 구조:
        WITH cte_name (column1, column2, ...) AS (
            SELECT_statement
        )
        SELECT * FROM cte_name;
*/

-- 1. 부서별 평균 급여를 WITH 문으로 조회하시오.
/* 
    // CTE 이름 정의
    WITH CTE 이름 AS (서브쿼리)
    DML; 
*/
WITH dept_avg AS (
    SELECT dept_id, AVG(salary) 
    FROM employee
    GROUP BY dept_id
)
SELECT * FROM dept_avg;




-- 전체평균: 3285.7143
SELECT AVG(salary) 
FROM employee; 

-- 부서별 평균
SELECT dept_id, AVG(salary) 
FROM employee
GROUP BY dept_id;


-- 2. 평균 급여가 4000 이상인 부서를 조회하시오.
WITH dept_avg AS (
    SELECT dept_id, AVG(salary) AS avg_salary
    FROM employee
    GROUP BY dept_id
)
SELECT *
FROM dept_avg
WHERE avg_salary >= 4000;


-- 3. 부서 평균 급여와 부서명을 함께 조회하시오.
WITH dept_avg AS (
    SELECT dept_id, AVG(salary) AS avg_salary
    FROM employee
    GROUP BY dept_id
)
SELECT d.dept_name, a.avg_salary
FROM dept_avg a
JOIN department d
ON a.dept_id = d.dept_id;

-- 4. 부서 평균 급여와 전체 평균 급여를 함께 조회하시오.
WITH dept_avg AS ( -- 부서별 평균
    SELECT dept_id, AVG(salary) AS avg_salary
    FROM employee
    GROUP BY dept_id
),
company_avg AS ( -- 전체 평균
    SELECT AVG(salary) AS total_avg
    FROM employee
)
SELECT d.dept_name, a.avg_salary, c.total_avg
FROM dept_avg a
JOIN department d ON a.dept_id = d.dept_id
CROSS JOIN company_avg c;

-- 5. 평균 급여보다 높은 사원을 WITH 문으로 조회하시오.
WITH avg_salary AS (
    SELECT AVG(salary) AS avg_sal
    FROM employee
)
SELECT emp_name, salary
FROM employee, avg_salary
WHERE salary > avg_sal;

-- 6. 부서별 최대 급여를 조회하시오.
WITH dept_max AS (
    SELECT dept_id, MAX(salary) AS max_salary
    FROM employee
    GROUP BY dept_id
)
SELECT * FROM dept_max;
-- 7. 사원이 없는 부서도 포함하여 평균 급여를 조회하시오.
WITH dept_avg AS (
    SELECT dept_id, AVG(salary) AS avg_salary
    FROM employee
    GROUP BY dept_id
)
SELECT d.dept_name, a.avg_salary
FROM department d
LEFT JOIN dept_avg a
ON d.dept_id = a.dept_id;
-- 8. 평균 급여가 전체 평균보다 높은 부서를 조회하시오.
WITH dept_avg AS (
    SELECT dept_id, AVG(salary) AS avg_salary
    FROM employee
    GROUP BY dept_id
),
company_avg AS (
    SELECT AVG(salary) AS total_avg FROM employee
)
SELECT d.dept_name
FROM dept_avg a
JOIN department d ON a.dept_id = d.dept_id
JOIN company_avg c
WHERE a.avg_salary > c.total_avg;