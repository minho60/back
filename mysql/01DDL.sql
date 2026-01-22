-- SQL 표준주석
# MySQL 주석
-- ctrl+enter

-- 스키마 생성
CREATE SCHEMA `abc` DEFAULT CHARACTER SET utf8mb4 ;
-- 스키마 사용
USE mydb;
-- 스키마 삭제
DROP SCHEMA abc;
/*
	DB 구축
		1. 사용자 정의: root, kmh
			-아이디, 패스워드, 권한 설정(DBA)
        2. 스키마 생성 - DB
        3. 테이블 생성
			- CREATE
			- 열(속성 정의)	
            
            CREATE TABLE 테이블명 (
				컬럼 데이터 타입 [제약조건] [기타속성],
                컬럼 데이터 타입 [제약조건] [기타속성],
                ...
                [FOREIGN KEY (현재 테이블 컬럼) REFERENCES 참조 할 테이블(컬럼)]
			);
            
            테이블/ 컬럼 이름 규칙
				1. 영문자, 숫자, _(언더바)
                2. 첫 글자는 숫자 x
                3. 최대 길이는 64자
                4. 예약어 x, (단, 백틱(`)으로 묶으면 예약어도 사용가능 하나 권장하지 않음)
				5. 윈도우 시스템에서는 대소문자 구분 x , 구분하는 시스템도 있다(예, Linux)
                6. 테이블 명은 복수로, 필드명은 단수로(관례)
                7. 소문자, 스네이크 표기법(관레)
					
            데이터 타입
				1. 숫자
					INT: 정수
                    BIGINT: 큰 정수
                    DECIMAL(p,s): 금액, 정확한 소수
                2. 문자
					CHAR(n): 고정길이 예) 주번 -13
                    VARCHAR(n): 가변길이 예) 이름
                    TEXT: 대용량의 문자열
                3. 날짜/시간
					DATETIME: 로컬 시간
                    TIMESTAMP: UTC 기준
                4. 불리언
					BOOLEAN -> TINYINT(1)
                5. 이진 데이터: 이미지, 동영상 등
					TINYBLOB: 255B
                    BLOB: 64KB - 작은 아이콘, 설정 파일
                    MEDIUMBLOB: 16MB - 일반 이미지
                    LONGBLOB: 4GB - 고화질 이미지, 동영상
                    
		    제약조건
				1. NOT NULL: 빈 값(NULL)을 허용하지 않음 -> 필수 입력
                2. UNIQUE: 중복값을 허용x->유일성(UQ), 단 NULL은 허용!
                3. PRIMARY KEY: 기본키(PK) -> 행 구별, 중복 X(유일성)
                4. FOREIGN KEY: 외래키(FK)
                5. CHECK: 입력되는 값이 특정 조건(예, price>0)을 만족하는지 검사
                6. DEFAULT: 값을 입력하지 않았을 때 자동으로 들어갈 기본 값
                
            기타 속성
				1. AUTO_INCREMENT: 자동으로 1씩 증가(1,2,3,...)
					-> 기본키를 지정한 컬럼에 설정한다.
                
				
			
                
*/

-- 1. 회원 정보를(회원 아이디, 이름, 나이, 성별, 가입일자) 저장하는 member 테이블을 생성하시오.
-- 윈도우 시스템에서 MySQL은 대소문자를 구별 하지 않는다.
-- 명령어는 대문자로 (관례)
CREATE TABLE `member`(
member_id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50),
age INT,
gender CHAR(1),
regdate DATE
);

-- 2. 이름(product_name)은 필수 입력인 product 테이블을 생성하시오.
-- 필수 입력은 해당 컬럼에 데이터를 반드시 입력하도록 조건을 지정
/*
	MySQL 전용 속성
		1. AUTO_INCREMENT: 자동으로 1씩 증가(1,2,3,...)
					-> 기본키를 지정한 컬럼에 설정한다.
        2. UNSIGNED: 
				- 숫자 타입에서 음수를 제외하고 양수 범위만 사용
                -> 공간 효율 증가
        3. ZERO FILL:
				- 설정한 자릿수 만큼 빈 공간을 0으로 채움 (예, 0001)
        4. BINARY:
				- 데이터를 이진문자열로 저장하여 대소문자를 구분하게함
                
        5. GENERATED
				- (price*quntity) 처럼 특정식에 의해 값이 자동 생성됨
        
*/
CREATE TABLE product(
	product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(100) NOT NULL,
    price INT
);
-- 3. 조회수(view_cnt) 기본값이 0인 board 테이블을 생성하시오.
CREATE TABLE board(
	board_no INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200),
    view_cnt INT DEFAULT 0
);

-- 4. 이메일(email)이 중복되지 않는 user 테이블을 생성하시오.
-- 컬럼의 순서도 있다.
CREATE TABLE user(
	user_id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
	);

-- 5. 주문 테이블을 생성하고 회원 테이블을 참조하도록 설정하시오.
CREATE TABLE orders(
	order_id INT PRIMARY KEY AUTO_INCREMENT,
    member_id INT,
    order_date DATE,
    -- 외래키는 현재 테이블의 member_id 컬럼, member테이블의 member_id 컬럼을 참조
    FOREIGN KEY (member_id) REFERENCES members(member_id)
    );

/*
	DDL: CREATE, ALTER, DROP

	테이블 수정
		1. 컬럼추가
		-> ALTER TABLE ADD 테이블명 컬럼명 데이터타입 [제약조건]
        
        2. 데이터 타입과 제약 조건 변경
        -> ALTER TABLE 테이블명 MODIFY 컬럼명 데이터타입[제약조건];
        
        3. 컬럼의 이름과 타입변경 
        -> ALTER TABLE 테이블명 CHANGE 컬럼명1 컬럼명2 데이터타입[제약조건]
        
        4. 컬럼의 이름만 변경 (MySQL 8.0+)
        -> ALTER TABLE 테이블명 RENAME COLUMN 컬럼명1 TO 컬럼명2
        
        5. 컬럼 삭제
*/
-- 6. member 테이블에 phone 컬럼을 추가하시오.
ALTER TABLE members 
ADD phone VARCHAR(20);
-- 7. member 테이블의 name 컬럼 길이를 100으로 변경하시오.
ALTER TABLE members 
MODIFY name VARCHAR(100);

-- 8. member 테이블의 phone 컬럼명을 mobile로 변경하시오.
ALTER TABLE members 
CHANGE phone mobile VARCHAR(20);

ALTER TABLE members 
RENAME COLUMN phone TO mobile;
-- 9. member 테이블에서 age 컬럼을 삭제하시오.
ALTER TABLE members
DROP COLUMN age;
-- 10. member 테이블의 email 컬럼에 UNIQUE 제약조건을 추가하시오.
ALTER TABLE members
ADD email VARCHAR(100) UNIQUE; 

-- 11. email UNIQUE 제약조건을 삭제하시오.
/*
	MySQL에서 컬럼에 UNIQUE 제약 조건을 설정하면,
    시스템은 중복 값을 빠르게 체크하기 위해 내부적으로
    해당 컬럼에 인덱스를 자동으로 생성한다.
    따라서 UNIQUE 제약 조건을 삭제하려면 생성된 인덱스를 삭제한다.
*/
ALTER TABLE members
DROP INDEX email;

/*
	테이블 이름 변경
		ALTER TABLE 기존테이블명 RENAME TO 새테이블명; (표준SQL)
        또는
        RENAME TABLE 기존테이블명 TO 새테이블명;(MySQL)
*/
-- 12. member 테이블 이름을 customer로 변경하시오.
ALTER TABLE members RENAME TO customer;

-- 12-1 customer 테이블 이름 member로 변경
RENAME TABLE customer TO member;

/*
	테이블 삭제
		DROP TABLE 테이블명;
*/
-- 13. product 테이블을 삭제하시오.
DROP TABLE product;

-- 참고:
/*
	DML: 
		1. 데이터 조회: SELECT
        2. 데이터 삽입: INSERT
        3. 데이터 변경: UPDATE
        4. 데이터 삭제: DELETE
        
	데이터 삽입
		INSERT INTO 테이블명(컬럼1, 컬럼2,...)
		VALUES( 값1, 값2,...);
    
    테이블 삭제
		DROP TABLE 테이블명; // 롤백 x
    
    데이터 삭제
		DELETE TABLE 테이블명; // 롤백 o
        TRUNCATE TABLE 테이블명; // 롤백 x
        
*/
-- 14. board 테이블의 모든 데이터를 삭제하시오.
DELETE FROM board;
TRUNCATE TABLE board;

/*
	CREATE TABLE 새테이블명 AS 
    SELECT * FROM 기존테이블명
*/
-- 15. member 테이블 구조와 데이터를 복사하여 member_backup 테이블을 생성하시오.
-- member테이블의 모든 정보를 조회하여
-- * 는 모든 컬럼
CREATE TABLE member_backup AS
SELECT * FROM member;

/*
	트렌젝션(Transaction)
    
*/
-- 테이블 생성
CREATE TABLE test(
	id INT PRIMARY KEY,
    name VARCHAR(30)
    ) ENGINE=InnoDB;
    
-- CTRL+ D: 한줄 복제 또는 선택한 영역 복제    
-- 데이터삽입
INSERT INTO test VALUES(1, 'A');
INSERT INTO test VALUES(2, 'B');
INSERT INTO test VALUES(3, 'C');

-- 세이프 모드 해제
SET SQL_SAFE_UPDATES = 0;

-- 1. 트렌젝션 시작
START TRANSACTION;

-- 2. 데이터 삭제
DELETE FROM test;
TRUNCATE TABLE test;

-- 3. 데이터 확인(조회)
SELECT * FROM test;
-- 4. 트랜젝션 종료: COMMIT 또는 ROLLBACK 
COMMIT;
ROLLBACK;
