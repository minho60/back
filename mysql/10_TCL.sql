/* 
    트랜잭션이란?
    - 하나의 작업 단위를 의미
    - 트랜잭션의 특징
        1. 원자성(Atomicity)	
            - 모두 성공 또는 모두 실패
        2. 일관성 (Consistency)
            - 트랜잭션이 성공적으로 완료 되면 데이터베이스는 일관된 상태를 유지
        3. 고립성 (Isolation)	
            - 트랜잭션 간 간섭 방지
        4. 지속성 (Durability)	
            - 커밋 후 영구 반영

 */


-- START TRANSACTION	트랜잭션 시작
-- COMMIT	작업 확정
-- ROLLBACK	작업 취소
-- SAVEPOINT	중간 저장점 설정
-- ROLLBACK TO	저장점까지 복구
-- SET AUTOCOMMIT	자동 커밋 제어


CREATE TABLE account (
    acc_no INT PRIMARY KEY,
    owner VARCHAR(30),
    balance INT
) ENGINE=InnoDB;


INSERT INTO account VALUES
(1, '홍길동', 10000),
(2, '이순신', 5000);

SELECT * FROM account;


-- 1. 트랜잭션을 시작하시오.
START TRANSACTION;

-- COMMIT	작업 확정
-- 2. 1번 계좌에서 2000원을 차감하고 트랜잭션을 확정하시오.
UPDATE account 
SET balance = balance - 2000 
WHERE acc_no =1;

COMMIT;


-- ROLLBACK	작업 취소
-- 3. 2번 계좌에서 3000원을 차감한 후 작업을 취소하시오.
START TRANSACTION;
UPDATE account 
SET balance = balance - 3000 
WHERE acc_no =2;
ROLLBACK;



-- SAVEPOINT	중간 저장점 설정


-- 4. 트랜잭션 도중 save1 저장점을 생성하시오.
START TRANSACTION;
UPDATE account 
SET balance = balance + 3000 
WHERE acc_no =2;
SAVEPOINT save1;
UPDATE account 
SET balance = balance + 3000 
WHERE acc_no =1;

-- 5. save1 이후 작업만 취소하시오.
ROLLBACK TO save1;



-- SET AUTOCOMMIT	자동 커밋 제어
-- 6. 현재 자동 커밋 상태를 확인하시오.
SELECT @@autocommit;



-- 7. 자동 커밋을 비활성화하시오.
SET autocommit = 0;

-- 8. 자동 커밋을 다시 활성화하시오.
SET autocommit = 1;