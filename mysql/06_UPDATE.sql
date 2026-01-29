/*
    INSERT INTO 테이블 [(컬럼,...)]
    VALUES(값,...)

    SELECT 컬럼, ...
    FROM 테이블
    WHERE 조건

    UPDATE 테이블
    SET 컬럼 = 값;
    WHERE 조건;

    DELETE FROM 테이블
    WHERE 조건;
*/

DELETE FROM member;
DELETE FROM board;
DELETE FROM product;
DELETE FROM orders;

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
-- 1. member_id가 3인 회원의 포인트를 100으로 수정하시오.
UPDATE member
SET point = 100 -- = 은 대입
WHERE member_id = 3; -- =은 같다

-- 2. 이름이 '이순신'인 회원의 등급을 GOLD로 변경하시오.
UPDATE member
SET grade ='GOLD'
WHERE name = '이순신';
-- 3. 포인트가 800 이상인 회원의 등급을 VIP로 변경하시오.
UPDATE member
SET grade = 'VIP'
WHERE point >= 800;

-- 4. 성별이 F이고 포인트가 700 이상인 회원의 등급을 GOLD로 변경하시오.
UPDATE member
SET  grade = 'GOLD'
WHERE gender='F' AND point>= 700;
-- 5. 등급이 BRONZE이거나 SILVER인 회원의 포인트를 100 증가시키시오.
UPDATE member
SET point = point+100
WHERE grade = 'BRONZE' OR grade = 'SILVER';
WHERE grade IN('BRONZE','SILVER');
-- 6. 주문 번호가 1~2 사이인 주문의 상태를 '배송중'으로 수정하시오.
SELECT * FROM orders;

UPDATE orders 
SET status = '배송중'
WHERE order_id BETWEEN 1 AND 2;

-- 7. 2023년 이전에 가입한 회원의 등급을 OLD로 변경하시오.
UPDATE member
SET grade = 'OLD'
WHERE regdate < '2023-01-01'; 

-- 8. 카테고리가 NULL인 상품의 카테고리를 '기타'로 수정하시오.
UPDATE product 
SET category = '기타'
WHERE category IS NULL;

-- 9. 제목에 '테스트'가 포함된 게시글의 조회수를 0으로 수정하시오.
UPDATE board 
SET view_cnt = 0
WHERE title LIKE '%테스트%';

-- 10. 모든 상품의 가격을 10% 인상하시오.
UPDATE product 
SET price = price * 1.1;

-- 11. 평균 포인트 이상인 회원의 등급을 우수회원으로 수정하시오.
UPDATE member 
SET grade = '우수회원'
WHERE point >= (
    SELECT avg_point
    FROM (
        SELECT AVG(point) AS avg_point 
        FROM member
        ) AS temp
    );

SELECT AVG(point) AS avg_point FROM member; -- 620.000

-- 12. 게시글을 2개 이상 작성한 작성자의 게시글 제목을 '다수작성자'로 수정하시오.
-- 13. VIP 회원의 주문 상태를 'VIP주문'으로 수정하시오.

-- 14. 회원 ID 가1인 포인트를 1000으로, 등급을 TOP으로 수정하시오.
UPDATE member
SET point = 1000, grade = 'TOP'
WHERE member_id = 1;
-- 15. 모든 게시글의 조회수를 1 증가시키시오.
SELECT * FROM board;

UPDATE board
SET view_cnt = view_cnt + 1;
