/* 
서브쿼리 
- 쿼리안의 쿼리
- 서브쿼리는 반드시 괄호()로 감싼다.

1. SELECT 절
2. FROM 절
3. WHERE 절의 값으로 사용 -> 서브쿼리

SELECT 컬럼
FROM 테이블
WHERE 컬럼 = (SELECT 컬럼 FROM 테이블 WHERE 조건);


*/

-- 1. 평균 급여보다 급여가 높은 사원을 조회하시오.

SELECT AVG(salary) FROM employee;

SELECT emp_name, salary
FROM employee
WHERE
    salary > (
        SELECT AVG(salary)
        FROM employee
    );

/* 
다중 행 서브쿼리
- 여러 행을 반환 할 수 있으므로
IN, ANY, ALL 연산자를 사용한다.
- IN: 서브쿼리가 반환하는 값들 중 하나와 일치하는 경우
- ANY: 서브쿼리가 반환하는 값들 중 하나라도 조건을 만족하는 경우
- ALL: 서브쿼리가 반환하는 모든 값이 조건에 만족하는 경우

*/
-- 2. 개발 또는 인사 부서에 속한 사원을 조회하시오.
-- IN: 또는 , ~ 중에 하나
-- IN ("개발", "인사")
SELECT dept_id FROM department WHERE dept_name IN ("개발", "인사");

SELECT emp_name
FROM employee
WHERE
    dept_id IN (
        SELECT dept_id
        FROM department
        WHERE
            dept_name IN ("개발", "인사")
    );

-- 3. 인사 부서 사원 중 최소 급여보다 급여가 높은 사원을 조회하시오.
INSERT INTO
    employee
VALUES (5, '타비', 8000, 20),
    (6, '리제', 7000, 20),
    (7, '히나', 6000, 20);

SELECT MIN(salary) FROM employee;

SELECT emp_name, salary
FROM employee
WHERE
    salary > ANY (
        SELECT salary
        FROM employee
        WHERE
            dept_id = 20
    );

-- 4. 인사 부서 사원 중 최대(max) 급여보다 급여가 높은 사원을 조회하시오.
SELECT emp_name, salary
FROM employee
WHERE
    salary > ALL (
        SELECT salary
        FROM employee
        WHERE
            dept_id = 20
    );
/* 
EXIST 서브쿼리
- 서브쿼리의 결과가 존재하는지 여부를 확인
- 서브쿼리가 하나이상의 행을 반환하면 true, 아니면 false 반환
- 서브쿼리 내 SELECT 1에서 숫자 1은 
특별한 기능적 의미가 있는 것이 아니라,
단순히 해장조건을 만족하는 행이 존자하는지만 
확인하기 위한 관용적 표현

SELECT 컬럼
FROM 테이블1 별칭1
WHERE EXISTS (
SELECT 1
FROM 테이블2 별칭2
WHERE 별칭1.공통컬럼1 = 별칭2.공통컬럼2
)

*/
-- 5. 사원이 존재하는 부서만 조회하시오.
SELECT e.emp_name, d.dept_name, d.dept_id
FROM employee e
    JOIN department d ON e.dept_id = d.dept_id;

SELECT dept_name
FROM department d
WHERE
    EXISTS (
        SELECT 1
        FROM employee e
        WHERE
            e.dept_id = d.dept_id
    );

SELECT DISTINCT
    dept_name
FROM department d
    JOIN employee e ON d.dept_id = e.emp_id;

-- 6. 사원이 없는 부서를 조회하시오.
SELECT dept_name
FROM department d
WHERE
    NOT EXISTS (
        SELECT 1
        FROM employee e
        WHERE
            e.dept_id = d.dept_id
    );

/* 
    스칼라 서브쿼리
        - SELECT 절의 서브쿼리

        SELECT 컬럼, ...,
            (SELECT 컬럼, ...FROM 테이블, WHERE 조건) AS 별칭
        FROM 테이블 
        WHERE 조건

 */    

-- 7. 각 사원의 급여와 전체 평균 급여를 함께 조회하시오.
SELECT emp_name, salary, (
        SELECT AVG(salary)
        FROM employee
    ) `평균급여`
FROM employee;

/* 
    인라인 뷰 서브쿼리
        - FROM 절에 임시 테이블을 생성한다.

        SELECT 컬럼
        FROM 테이블
        WHERE 조건

 */

-- 8. 부서별 평균 급여가 4000 이상인 부서를 조회하시오.
SELECT dept_id, AVG(salary) AS avg_salary
FROM employee
GROUP BY
    dept_id;

SELECT dept_id, avg_salary
FROM ( SELECT dept_id, AVG(salary) AS avg_salary
        FROM employee
        GROUP BY dept_id) t
WHERE avg_salary >= 4000;        

-- 부서명을 조회하려면?
SELECT dept_name, ang_salary
FROM department d
WHERE(SELECT FROM)       

-- 9. 각 부서에서 평균 급여보다 많이 받는 사원을 조회하시오.
SELECT AVG(salary)
FROM employee;

SELECT emp_name, salary
FROM employee e
WHERE salary > (
    SELECT AVG(salary)
    FROM employee
    WHERE dept_id = e.dept_id
);


-- 10. 평균 급여보다 높은 사원을 JOIN 방식으로도 조회하시오.
-- 서브쿼리 + 조인

SELECT e.emp_name, e.salary 
FROM employee e
JOIN (
    SELECT AVG(salary) AS avg_salary 
    FROM employee) AS a
ON e.salary > a.avg_salary;