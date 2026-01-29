SELECT * FROM member;

SELECT * FROM board;

SELECT * FROM product;

SELECT * FROM orders;

/*
INSERT INTO 테이블 [(컬럼1, 컬럼2,...)] VALUES
(값1, 값2, ...),
(값1, 값2, ...),
...
(값1, 값2, ...);

- 컬럼의 수와 값의 수는 일치해야 한다.
- 컬럼을 생략하면 모든 컬럼에 대한 값을 지정한다.
*/
INSERT INTO
    member
VALUES (
        1,
        '홍길동',
        35,
        'M',
        500,
        'VIP',
        '2023-01-01'
    ),
    (
        2,
        '이순신',
        22,
        'M',
        200,
        'BRONZE',
        '2022-01-01'
    );

INSERT INTO board VALUES ( 1, '공지사항', 'admin', 100, '2024-01-01' );

INSERT INTO product VALUES (1, '노트북', 150000, 10, '전자제품');

INSERT INTO orders VALUES ( 1, 1, 120000, '주문완료', '2025-01-01' );

SELECT * FROM member;
-- 1. member 테이블에 새로운 회원을 1명 추가하시오.
INSERT INTO member (gender) VALUES ('M');

INSERT INTO
    member (
        member_id,
        name,
        age,
        gender,
        point,
        grade,
        regdate
    )
VALUES (
        4,
        '마시로',
        25,
        'F',
        150,
        'BRONZE',
        '2026-01-28'
    );

/*
날짜/시간 함수
CURDATE()   현재날짜            YYYY-MM-DD
NOW()       현재 날짜와 시간    YYYY-MM-DD HH:MM:SS

*/
INSERT INTO
    member (
        member_id,
        name,
        age,
        gender,
        point,
        grade,
        regdate
    )
VALUES (
        4,
        '마시로',
        25,
        'F',
        150,
        'BRONZE',
        CURDATE()
    );

-- 2. 이름, 나이, 성별만 지정하여 회원을 추가하시오.
INSERT INTO member (name, age, gender) VALUES ('타비', 27, 'F');
-- 3. 회원 번호는 자동 증가로 두고 회원을 추가하시오.
INSERT INTO
    member (
        name,
        age,
        gender,
        point,
        grade,
        regdate
    )
VALUES (
        '리제',
        26,
        'F',
        20,
        'SILVER',
        '2025-03-24'
    );
-- 4. 회원 2명을 한 번에 추가하시오.
INSERT INTO
    member
VALUES (
        7,
        '히나',
        25,
        'F',
        100,
        'SILVER',
        '2025-03-23'
    ),
    (
        9,
        '유니',
        25,
        'F',
        200,
        'SILVER',
        '2023-03-22'
    );
-- 5. 카테고리가 없는 상품을 추가하시오.
SELECT * FROM product;

INSERT INTO
    product (
        product_name,
        price,
        stock,
        category
    )
VALUES ('점프케이블', 5000, 100, NULL);

-- 6. 조회수 기본값을 사용하여 게시글을 추가하시오.
SELECT * FROM board;

INSERT INTO
    board (title, writer, regdate)
VALUES ('첫번쨰 게시물', '관리자', CURDATE());

-- 7. 오늘 날짜로 주문 정보를 추가하시오.
INSERT INTO orders VALUES ( 2, 2, 150000, 'completed', CURDATE() );

/*
서브쿼리
- 쿼리안의 쿼리
- 어디에? 다른 테이블 도회 결과 삽입
- 단일 행 서브쿼리: 하나의 값(행, 열)반환
- 다중 행 서브쿼리: 여러 행 반환

INSERT INTO 테이블 A (컬럼,...)    
SELECT 컬럼, ...
FROM 테이블B
[WHERE 조건]


INSERT INTO 테이블(컬럼,...)
VALUES (
    (SELECT 컬럼
     FROM 테이블
     [WHERE 조건 LIMIT 행수]   
    )
);

*/

-- 8. VIP 회원의 ID를 사용하여 주문을 추가하시오.
SELECT * FROM member;

INSERT INTO
    orders (
        member_id,
        total_price,
        status,
        order_date
    )
VALUES (
        (
            SELECT member_id
            FROM member
            WHERE
                grade = 'VIP'
        ),
        200000,
        '대기중',
        CURDATE()
    );

INSERT INTO
    orders (
        member_id,
        total_price,
        status,
        order_date
    )
SELECT member_id, 250000, 'pending', CURDATE()
FROM member
WHERE grade = 'VIP';

/*
특수한 INSERT 문 
INSERT IGNORE INTO 테이블
VALUES (값,...)
ON DUPLICATE KEY UPDATE 컬럼 = 값, 컬럼2 = 값2, ...

1. INSERT IGNORE
- 데이터를 넣을 떄 에러가 발생하면
에러를 경고로 낮추고 해당행을 무시해 버린다.
- 데이터가 추가되지 않는 이유
member_id 는 기본키로 설정되어 있고,
member_id 가 1인 데이터가 이미 테이블에 존재하기 때문
2. ON DUPLICATE KEY UPDATE
- 중복키 발생시 데이터를 업데이트            

*/

-- 9. 중복 키 오류가 발생해도 무시하고 회원을 추가하시오.
INSERT IGNORE INTO
    member (member_id, name, age, gender)
VALUES (1, '중복회원', 40, 'M');


-- 10. 회원이 없으면 추가하고, 있으면 포인트를 100 증가시키시오.
INSERT INTO member (member_id, name, age, gender, point)
VALUES(2, '시부키' , 22, 'F', 100)
ON DUPLICATE KEY UPDATE name ='텐코 시부키', age = 23, gender ='F', point = point+100;



-- 11. board 테이블의 데이터를 복사하여 새 게시글로 추가하시오.
SELECT * FROM board;
INSERT INTO board (title, writer, regdate)
SELECT title, writer, CURDATE()
FROM board
WHERE board_no < 5;


-- 12. 주문 금액이 100000 이상인 주문만 새로운 주문으로 복사하시오.
INSERT INTO orders (member_id, total_price, status, order_date)
SELECT member_id, total_price, status, order_date
FROM orders
WHERE total_price >= 100000;

-- 13. 모든 필수 컬럼을 포함하여 상품을 추가하시오.
INSERT INTO product( product_name, price, stock, category)
VALUES('스마트폰', 800000, 20, '전자제품');


/*
    START TRANSACTION; -- 트랜잭션 시작
    INSERT 문
    COMMIT(승인)| ROLLBACK(취소);
*/
-- 14. 트랜잭션을 사용하여 회원을 추가하시오.
START TRANSACTION;
INSERT INTO member (member_id, name, age, gender, point)
VALUES(NULL,'안소미', 35, 'F', 600);
COMMIT;
ROLLBACK;
-- 15. member 테이블의 데이터를 백업 테이블에 저장하시오.
INSERT INTO member_backup
SELECT * FROM member;