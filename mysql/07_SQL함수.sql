-- 테이블 삭제
DROP TABLE member;

CREATE TABLE member (
  member_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  age INT,
  gender CHAR(1),
  point INT,
  salary INT,
  regdate DATE
);


INSERT INTO member VALUES
(1, 'Hong Gildong', 35, 'M', 500, 3000000, '2023-01-01'),
(2, 'Yi Sunsin', 22, 'M', 200, 2500000, '2022-01-01'),
(3, 'Kim Younghee', 19, 'F', NULL, 1800000, '2025-01-01'),
(4, 'Park Cheolsu', 45, 'M', 900, 5000000, '2021-01-01'),
(5, 'Choi Minsu', 31, 'F', 700, NULL, '2024-01-01');

SELECT * FROM member;
/*
    문자열 함수
        1. LENGTH(str)
            - 문자열(str)의 길이 (Byte단위)
            - 숫자와 영문자는 1byte
            - 예) LENGTH('HELLO') -> 5
            - 예) LENGTH('홍길동') -> 9
        1-1 CHAR_LENGTH(str)
            - str의 길이 (문자단위)    
        2. UPPER(str)
            - str을 모두 대문자로
            - 예) UPPER('hello')-> 'HELLO'
        2-2 LOWER
            - str을 모두 소문자로    

*/
-- 1. 회원 이름의 길이를 조회하시오.
SELECT name, LENGTH(name) FROM member;

-- 2. 회원 이름을 대문자로 조회하시오.
SELECT name, UPPER(name) FROM member;
SELECT name, LOWER(name) FROM member;

/* 
    3. substring(str, start, len)
        - 부분 문자열 추출
        - str: 원본 문자열
        - start: 추출 시작 위치 (1부터 시작)
        - len: 추출할 길기
        예) substring('ABCDEF', 2, 3) -> 'BCD'
    3-1 left(str, n)
        - 왼쪽에서 부터
    3-2 right(str, n)
        - 오른쪽 부터        
 */

-- 3. 회원 이름의 첫 글자만 조회하시오.
SELECT name, SUBSTRING(name,1 ,1 ) FROM member;
SELECT name, LEFT(name,1) FROM member;
SELECT name, RIGHT(name,1) FROM member;

/* 
    4. concat()


 */
-- 4. 이름과 성별을 하나의 문자열로 조회하시오.
SELECT CONCAT(name,'(', gender ,')')  
FROM member;


/* 
    숫자 함수
        1. abs(num)
            - 절대값
            예) abs(-10)-> 10
 */

-- 5. 포인트와 500의 차이를 절대값으로 조회하시오.
SELECT name, ABS(point- 500) 
FROM member;

/* 
    2. round(num)
        - 반올림
        예) round(3.14)

    2-1. floor(num)
        - 버림
        예) floor(3.14) -> 3

    2-2. ceiling(num)
        - 올림
        예) ceiling(3.14) -> 4

 */
-- 6. 급여를 만원 단위로 반올림하여 조회하시오.
SELECT name, salary, ROUND(salary) 
FROM member;

SELECT salary, FLOOR(salary) 
FROM member;



SELECT * FROM member;

/* 
    날짜 함수
        1. CURDATE()
            -현재 날짜를 'YYYY-MM-DD' 형식
            예) CURDATE() -> '2026-01-30'

        2.CURTIME()
            -현재시간을 'HH:MM:SS' 형식

        3. NOW()
            - 현재 날짜와 시간 'YYYY-MM-DD HH:MM:SS' 형식   

        4. YEAR(date)
            - date 의 년도    
 */

-- 7. 오늘 날짜를 조회하시오.
SELECT CURDATE(); 
SELECT CURTIME();
SELECT NOW();
SELECT YEAR(NOW());

/* 
  5. datediff(날짜1, 날짜2)
        - 날짜1 - 날짜2, 두 날짜의 차이를 일수로 반환
        예) datediff('2023-12-31', '2023-01-01') -> 364

 */

-- 8. 회원 가입 후 경과 일수를 조회하시오.
SELECT name AS 이름, DATEDIFF(CURDATE(), regdate) AS 가입기간
FROM member;

/* 
    NULL 처리함수
        ifnull(표현식1, 표현식2)
            - 표현식1이 NULL이면 표현식2를 반환,
              아니면 표현식 1을 반환
            예) ifnull(NULL,'default') -> 'default'  
 */
-- 9. 포인트가 NULL이면 0으로 표시하시오.
SELECT IFNULL(point,0) FROM member;

SELECT * FROM member;

/* 
    IF(조건, 값1, 값2)
        - 값1: 조건이 참 일떄의 값
        - 값2: 조건이 거짓 일떄의 값
        예) IF(5>=3,'yes', 'no') -> 'yes'
        예) IF(point >= 500, '우수', '일반') -> ?
 */
-- 10. 포인트가 500 이상이면 '우수', 아니면 '일반'으로 표시하시오.
SELECT name AS 이름, point AS 포인트, IF(point >= 500, '우수', '일반')AS 회원등급 
FROM member;

/* 
    CASE ~ WHEN ~ THEN ~ ELSE ~ END
        CASE
            WHEN 조건 THEN 결과
            WHEN 조건 THEN 결과
            ...
            ELSE 결과
        END    
    
    예)
        CASE
            WHEN score >= 90 THEN 'A'
            WHEN score >= 80 THEN 'B'
            WHEN score >= 70 THEN 'C'
            WHEN score >= 60 THEN 'D'
            ELSE 'F'
        END    

 */

-- 11. 나이에 따라 연령대를 분류하시오.
SELECT * FROM member;

SELECT name AS 이름, age AS 나이,
        CASE 
            WHEN age < 20 THEN '10대'  
            WHEN age BETWEEN 20 AND 29 THEN '20대'  
            WHEN age BETWEEN 30 AND 39 THEN '30대'  
            WHEN age BETWEEN 40 AND 49 THEN '40대'  
            ELSE  '50대 이상'
        END AS 연령대
FROM member;


/* 
    집계 함수
        1. count(컬럼)
        1-1. count(*): NULL 값이 있는 레코드도 개수에 포함된다.
        2. sum(컬럼)
            - 컬럼의 합계
        3. avg(컬럼)
            - 컬럼의 평균
        4. max(컬럼)
            - 컬럼의 최댓값
        5. min(컬럼)
            - 컬럼의 최솟값
 */
-- 12. 전체 회원 수를 조회하시오.
SELECT COUNT(*) AS 총원 FROM member;


-- 13. 전체 포인트 합계를 조회하시오.
SELECT SUM(point) AS 포인트총합 FROM member;
-- 14. 평균 급여를 조회하시오.
SELECT AVG(salary) AS 평균급여 FROM member;

-- 15. 성별별 평균 급여를 조회하시오.
SELECT gender AS 성별, AVG(salary) AS 평균급여
FROM member
GROUP BY gender;