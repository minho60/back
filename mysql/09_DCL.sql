-- CREATE USER	사용자 생성
-- DROP USER	사용자 삭제
-- GRANT	권한 부여
-- REVOKE	권한 회수
-- SHOW GRANTS	권한 확인

-- 사용자 생성
-- 1. user1 계정을 비밀번호 1234로 생성하시오.
--  CREATE USER '아이디'@'호스트명' IDENTIFIED BY '비밀번호';
CREATE USER 'user1' @'lacalhost' IDENTIFIED BY '1234';


CREATE USER 'user2' @'%' IDENTIFIED BY '1234';

CREATE USER 'user3' @'192.168.2.90' IDENTIFIED BY '1234';


-- 2. 현재 DB에 존재하는 사용자를 조회하시오.
SELECT USER, HOST FROM mysql.user;

-- GRANT	권한 부여
-- 3. user1에게 testdb 데이터베이스의 모든 권한(ALL PRIVILEGES)을 부여하시오.
/* 
GRANT ALL PRIVILEGES 
ON DB명.*
TO '사용자명'@'호스트명';
*/
GRANT ALL PRIVILEGES 
ON mydb.* 
TO 'user1' @'localhost';


-- 4. user1에게 member 테이블의 SELECT 권한만 부여하시오.
GRANT SELECT
ON mydb.MEMBER
TO 'user1'@'localhost';



-- 권한확인
-- 5. user1에게 부여된 권한을 확인하시오.
SHOW GRANTS;


SHOW GRANTS FOR 'user1'@'localhost';



-- REVOKE 권한회수
-- 6. user1에게서 member 테이블의 SELECT 권한을 회수하시오.
REVOKE SELECT 
ON mydb.member 
FROM 'user1'@'localhost';

-- 7. user1에게 부여된 testdb에 대한 모든 권한을 회수하시오.
REVOKE ALL PRIVILEGES
ON mydb.*
FROM 'user1'@'localhost';


-- 8. user1의 비밀번호를 5678로 변경하시오.
ALTER USER 'user1'@'localhost'
IDENTIFIED BY '5678';

-- 9. 변경된 권한을 즉시 반영하시오.
FLUSH PRIVILEGES;

-- 10. user1 계정을 삭제하시오.
DROP USER 'user1'@'localhost';