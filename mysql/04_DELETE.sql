/*
    SQL
        1.DDL
            - DB 생성, 삭제
            - 테이블 생성, 삭제, 변경
        
        2.DML
            - INSERT    Create    
            - SELECT    Read
            - UPDATE    Update
            - DELETE    Delete
        
        3.DCL+TCL    
*/
/*
    DELETE FROM 테이블
    [WHERE 조건]

*/

-- 1. member_id가 3인 회원을 삭제하시오.
DELETE FROM member
WHERE member_id = 3;
-- 2. 이름이 '중복회원'인 회원을 삭제하시오.
DELETE FROM member
WHERE name='중복회원';


-- 3. 나이가 25 미만인 회원을 삭제하시오.
DELETE FROM member
WHERE age<25;
-- 4. 성별이 F이고 등급이 SILVER인 회원을 삭제하시오.
DELETE FROM member
WHERE gender='F'AND grade='SILVER';

-- 5. 등급이 VIP 또는 GOLD인 회원을 삭제하시오.
DELETE FROM member
WHERE grade IN('VIP','GOLD');

-- 6. 주문 번호가 1~2 사이인 주문을 삭제하시오.
DELETE FROM orders
WHERE order_id BETWEEN 1 and 2;

INSERT INTO member VALUES
(1, '홍길동',35,'M', 0, 'VIP','2023-01-01'),
(2, '이순신',22,'M', 0, 'BRONZE','2022-01-01'),
(3, '김영희',19,'F', 0, 'BRONZE','2025-01-01'),
(8, '박철수',45,'M', 0, 'GOLD','2021-01-01'),
(10, '최민수',31,'F', 0, 'SILVER','2024-01-01');
-- 7. 2022년 이전에 가입한 회원을 삭제하시오.
-- 날짜도 문자 처리'' 
DELETE FROM member
WHERE regdate < '2022-01-01';


-- 8. 카테고리가 NULL인 상품을 삭제하시오.
-- 9. 제목에 '테스트'가 포함된 게시글을 삭제하시오.
-- 10. 평균 주문 금액보다 작은 주문을 삭제하시오.
-- 11. 게시글을 2개 이상 작성한 작성자의 게시글을 삭제하시오.
-- 12. 등급이 BRONZE인 회원의 주문을 삭제하시오.
-- 13. 주문 상태가 '취소'인 주문을 삭제하시오.
-- 14. board 테이블의 모든 데이터를 삭제하시오.
-- 15. 같은 제목의 게시글이 여러 개일 경우, 가장 최근 글을 제외하고 삭제하시오.