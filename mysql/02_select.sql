DROP TABLE member;
DROP TABLE board;
DROP TABLE product;
/*
	종속 관계에서 상위테이블을 제거하고 싶으면 
    하위테이블과의 종속 관계를 제거하고 하위테이블을 모두 삭제해야함
*/

-- 참조무결성 때문에 orders 테이블을 먼저 삭제한다.
-- orders 테이블은 외래키가 지정되어있어
-- member테이블 보다 먼저 삭제 되어야한다.
DROP TABLE orders;

CREATE TABLE member (
  member_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  age INT,
  gender CHAR(1),
  point INT,
  grade VARCHAR(20),
  regdate DATE
);
CREATE TABLE board (
  board_no INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(200),
  writer VARCHAR(50),
  view_cnt INT,
  regdate DATE
);
CREATE TABLE product (
  product_id INT PRIMARY KEY AUTO_INCREMENT,
  product_name VARCHAR(100),
  price INT,
  stock INT,
  category VARCHAR(50)
);
CREATE TABLE orders (
  order_id INT PRIMARY KEY AUTO_INCREMENT,
  member_id INT,
  total_price INT,
  status VARCHAR(30),
  order_date DATE
);

/*
	DML(데이터 조작 언어)
		1. INSERT: 삽입 -> CREATE 
		2. SELECT: 조회 -> READ 
        3. UPDATE: 갱신 -> UPDATE
        4. DELETE: 삭제 -> DELETE 
*/

/*
	INSERT INTO 테이블명[(열1, 열2, ...)](VALUES[값1,값2,...])
		- 테이블 뒤에 열을 생략하면 테이블에 정의된 모든 열을 입력값으로 지정해야 한다.
        - 테이블 뒤에 열 이름을 생략하려면 
		  VALUES문 뒤에 테이블의 열순서와 개수에 맞춰 데이터를 채워야 함	
*/
-- 데이터(행, 튜플, 레코드) 삽입하기
INSERT INTO member VALUES
(1,'홍길동',35,'M',500,'VIP','2023-01-01'),
(2,'이순신',22,'M',200,'BRONZE','2022-01-01'),
(3,'김영희',19,'F',0,'BRONZE','2025-01-01'),
(4,'박철수',45,'M',900,'GOLD','2021-01-01'),
(5,'최민수',31,'F',700,'SILVER','2024-01-01');

INSERT INTO board VALUES
(1,'테스트 글','hong',0,'2022-01-01'),
(2,'공지사항','admin',200,'2023-01-01'),
(3,'자유글','hong',10,'2025-01-01'),
(4,'테스트 게시글','kim',5,'2021-01-01');

INSERT INTO product VALUES
(1,'노트북',150000,10,'전자제품'),
(2,'마우스',20000,0,NULL),
(3,'키보드',30000,50,'전자제품');

INSERT INTO orders VALUES
(1,1,120000,'주문완료','2025-01-01'),
(2,2,50000,'취소','2023-01-01'),
(3,3,0,'취소','2024-01-01'),
(4,5,300000,'주문완료','2025-02-01');

-- 조회하기
-- SELECT*FROM [스키마.]테이블;
-- *는 테이블에 정릐된 모든 필드 
-- 서로다른 스키마에서 같은 이름의 테이블이 없다면 스키마명은 생략 가능
SELECT * FROM member;
SELECT * FROM board;
SELECT * FROM product;
SELECT * FROM orders;

-- member 테이블
-- 1. member 테이블의 모든 데이터를 조회하시오.
SELECT * FROM member;

-- 2. 회원의 이름과 나이만 조회하시오.
-- SELECT 컬럼1, 컬럼2, ... FROM 테이블;
SELECT name, age FROM member;

-- 3. 등급이 VIP인 회원을 조회하시오.
-- SELECT 컬럼,... FROM 테이블 WHERE 조건;
SELECT * FROM member 
-- 등급이 vip와 같은
WHERE grade='VIP';
-- 문자열은 '또는 "로 묶는다.

-- 4. 나이가 30 이상인 회원을 조회하시오.
SELECT * FROM member 
WHERE age >= 30;

-- 5. 성별이 여자이고 포인트가 500 이상인 회원을 조회하시오.
SELECT * FROM member 
WHERE gender='F' AND point >=500;

/*
  MySQL 에서 문자열 데이터를 조회할 떄 대소문자 구분 여부 
  -> 데이터 타입과 콜레이션 설정에 따라 결정된다.

  utf8mb4_general_ci
    1) _ci(caase Insensitive): 대소문자 구별 x
    2) _CS(Case Sensitive): 대소문자 구별
    3) _bin(Binary): 데이터를 이진값으로 비교, 대소문자 구별

    BLOB, BINARY 데이터 타입은 콜레이션 설정과 관계없이 대소문자를 구분한다.
    부울값 (true, false)은 TINYINT(1)데이터 타입이므로
    -> 콜레이션 설정과 

*/
-- 6. 등급이 GOLD 또는 VIP인 회원을 조회하시오.
SELECT * FROM member 2ms 
WHERE grade = 'GOLD' OR grade = 'VIP';


SELECT * FROM member 2ms 
WHERE grade IN('GOLD','VIP');

/*
    범위/집합 연산자
      BETWEEN A AND B   A와 B 사이 (A,B 포함)
      IN (A, B,...)   A또는 B,...

*/

-- 7. 포인트가 200~800 사이인 회원을 조회하시오.
SELECT * FROM member
WHERE point >= 200 AND point <= 800;

-- 8. 등급이 BRONZE, SILVER인 회원의 이름과 등급만 조회하시오.
SELECT name, grade FROM member
WHERE grade ='BRONZE' OR grade ='SILVER';



INSERT INTO board VALUES
(1,'테스트 글','hong',0,'2022-01-01'),
(2,'공지사항','admin',200,'2023-01-01'),
(3,'자유글','hong',10,'2025-01-01'),
(4,'테스트 게시글','kim',5,'2021-01-01');
-- board 테이블
/*
    패턴 연산자
     %  0개 이상의 문자
     _  1개 문자

     예) '테스트'가 포함된                 %테스트%
     예) '테스트'로 시작하는               테스트%
     예) '테스트'로 끝나는                 %테스트
     예) '테스트'로 시작하는 6자리 문자    %테스트
*/

-- 9. 제목에 '테스트'가 포함된 게시글을 조회하시오.
SELECT * FROM board
WHERE title LIKE '%테스트%';



INSERT INTO product VALUES
(1,'노트북',150000,10,'전자제품'),
(2,'마우스',20000,0,NULL),
(3,'키보드',30000,50,'전자제품');
-- product 테이블
/*
    NULL 관련 연산자
      IS NULL       NULL 이다.
      IS NOT NULL   NULL 이 아니다.

*/

-- 10. 카테고리가 NULL인 상품을 조회하시오.
SELECT * FROM product
WHERE category IS NULL;


/*
    SELECT 컬럼1, 컬럼2, ...
    FROM 테이블
    [WHERE 조건]
    [ORDER BY 컬럼 ASC(오름차순)|DESC(내림)]

      - 정렬: ASC(오름차순), DESC(내림차순)

*/
-- 11. 회원을 포인트 내림차순으로 조회하시오.
SELECT * FROM member
ORDER BY point; -- 오름차순

SELECT * FROM member 
ORDER BY point DESC; -- 내림차순


/*
    SELECT 컬럼1, 컬럼2, ...
    FROM 테이블
    [WHERE 조건]
    [ORDER BY 컬럼 [ASC|DESC]]
    [LIMIT 행수];

*/
-- 12. member 테이블에서 포인트 상위 3명의 회원을 조회하시오.
SELECT * FROM member
LIMIT 3; -- 3명의 회원 조회
SELECT * FROM member 
ORDER BY point DESC
LIMIT 3;

/*
    집계함수
      1. count(컬럼)      행의 수(NULL 제외)
      2. sum(숫자컬럼)    합게(NULL제외)
      3. avg(숫자컬럼)    평균(NULL제외)
      4. max(컬럼)        최댓값
      5. min(컬럼)        최솟값

*/

/*
    SELECT 컬럼1 [AS 별칭], 컬럼2[AS 별칭],...
    FROM 테이블;
*/

-- 13. member 테이블에서 회원의 평균 포인트를 조회하시오.
SELECT avg(point) AS 평균 FROM member;

/*
    SELECT  컬럼1, 컬럼2,...
    FROM 테이블 
    [WHERE 조건]
    GROUP BY 컬럼 HAVING 그룹조건
    [ORDER BY 컬럼 ASC|DESC]
    [LIMIT]

      - LIMIT 는 MYSQL 전용
*/

-- 14.  member 테이블에서등급별 회원 수를 조회하시오.
SELECT count(member_id) FROM member; -- 전체 행 수 -> 회원 수
SELECT grade, count(member_id) FROM member
GROUP BY grade;


-- 15. member 테이블에서 회원 수가 2명 이상인 등급만 조회하시오.
SELECT grade AS 등급, CONCAT(count(*), '명') AS 인원수 
FROM member
GROUP BY grade HAVING count(*) >= 2;

/*
    서브쿼리
    1. 반드시 괄호로 감싼다.
    2. 안쪽 쿼리(서브쿼리)가 먼저 실행된다.
    3. select, from, where 증 여러 위치에서 사용된다.
    4. 스칼라 서브퉈리 -> select 절의 서브쿼리
    5. 인라인 뷰 -> from 절의 서브쿼리
    6. AS 절: 별칭(Alias) 부여
        - 테이블의 별칭은 생략 권장, 컬럼의 별칭은 사용 권장(관례)

      SELECT 컬럼
      FROM 테이블
      WHERE 컬럼 = (SELECT 문장);

      SELECT 컬럼
      FROM (SELECT 문장)
      WHERE 컬럼

      SELECT 컬럼, (SELECT 문장) AS 별칭
      

*/


-- 16. 평균 포인트 이상인 회원을 조회하시오.
-- 기록순서: SELECT 절 -> FROM 절 -> WHERE 절
-- 실행순서: FROM 절 -> WHERE절 -> SELECT 절
-- member 테이블로부터 point가 평균(member테이블로 부터 point의 평균을 조회한다.)
-- 이상인 모든  컬럼을 조회한다.
SELECT * FROM member
WHERE point >= (SELECT AVG(point) FROM member);


INSERT INTO orders VALUES
(1,1,120000,'주문완료','2025-01-01'),
(2,2,50000,'취소','2023-01-01'),
(3,3,0,'취소','2024-01-01'),
(4,5,300000,'주문완료','2025-02-01');
-- orders 테이블
-- 17. 주문을 한 회원의 정보만 조회하시오.
SELECT * FROM orders;

SELECT * FROM member
WHERE member_id IN(SELECT member_id FROM orders);



/*
    조인(join) 
      - 둘 이상의 테이블을 연결
      - 키(KEY): PK(기본키), FK(외래키)


    1. inner join(내부조인)
    2. 외부조인
      - Left outer join 왼쪽 외부조인
      - Light outer join 오른쪽 외부조인

    SELECT 컬럼
    FROM 테이블A [INNER]JOIN 테이블B 
    [ON 조인조건]
    WHERE 조건

*/
-- 18. 주문 정보와 회원 이름을 함께 조회하시오.
-- 이름, 주문번호, 총 가격만 출력
SELECT * FROM orders;

SELECT name, order_id, total_price
FROM member join orders
ON member.member_id = orders.order_id;
-- 19. 주문이 없는 회원도 포함하여 조회하시오.
SELECT m.member_id, m.name, o.order_id, o.total_price
FROM member m LEFT JOIN orders o
ON m.member_id = o.member_id; 

/*
    SELECT 컬럼1, DISTINCT 컬럼2, ...
    FROM 테이블1
    JOIN 테이블 2 ON 조인조건
    WHERE 조건
    GROUP BY 컬럼 HAVING 그룹조건
    ORDER BY 컬럼 ASC|DESC
    LIMIT 행수;

*/

-- 20. 주문 상태의 종류를 중복 없이(distinct) 조회하시오.
SELECT DISTINCT status FROM  orders;
