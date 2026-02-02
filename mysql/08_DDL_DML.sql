-- 실행: ctrl+ enter
-- 데이터 베이스 생성
CREATE DATABASE doitsql;

-- 데이터베이스 삭제
DROP DATABASE doitsql;

-- 데이터베이스 사용
USE doitsql;

-- 테이블 생성
CREATE TABLE doit_dml(
	col_1 INT,
    col_2 VARCHAR(50),
    col_3 DATETIME
);

-- 테이블 삭제
DROP TABLE doit_dml;

-- DML
-- 삽입
INSERT INTO doit_dml (col_1, col_2, col_3)
VALUES (1, 'DO IT SQL','2026-02-02');

-- 컬럼 순서를 바꿔도 데이터 타입이 일치하면 된다.
INSERT INTO doit_dml (col_1, col_3, col_2)
VALUES (2,'2026-02-02','열순서 변경');

-- 여러데이터를 한번에 삽입
INSERT INTO doit_dml(col_1, col_2, col_3) VALUES
(5, '데이터입력5', '2026-02-02'),
(6, '데이터입력6', '2026-02-02'),
(7, '데이터입력7', '2026-02-02');


-- 조회 
SELECT * FROM doit_dml;

-- 데이터 수정
UPDATE doit_dml
SET col_2 = '수정'
WHERE col_1 = 4;

-- 삭제
DELETE FROM doit_dml WHERE col_5;



