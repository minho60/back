-- DB 생성
CREATE SCHEMA `testdb` DEFAULT CHARACTER SET utf8mb4 ;

-- DB 사용
USE testdb;

-- 테이블 생성
CREATE TABLE user(
	userid VARCHAR(20) PRIMARY KEY,
    userpw VARCHAR(20) NOT NULL
);

-- 데이터 삽입
INSERT INTO `testdb`.`user`(`userid`,`userpw`)
VALUES('kim','1234');

INSERT INTO user (userid, userpw) VALUES
('admin', 'admin123'),
('minho', 'minho1234'),
('jiyoung', 'jy2025'),
('test01', 'test1234'),
('guesuseridt', 'guest0000');

-- 조회
SELECT*FROM user;

-- 삭제
DELETE FROM `testdb`.`user` WHERE useridIN ('minho', 'guest');
