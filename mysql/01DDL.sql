-- SQL 표준주석
# MySQL 주석
-- ctrl+enter
CREATE SCHEMA `mydb` DEFAULT CHARACTER SET utf8mb4 ;
USE mydb;
/*
	DB 구축
		1. 사용자 정의: root, kmh
			-아이디, 패스워드, 권한 설정(DBA)
        2. 스키마 생성 - DB
        3. 테이블 생성
			- CREATE
			- 열(속성 정의)	
            
            CREATE TABLE 테이블명 (
				컬럼 데이터 타입 [제약조건],
                컬럼 데이터 타입 [제약조건],
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
-- 3. 조회수(view_cnt) 기본값이 0인 board 테이블을 생성하시오.
-- 4. 이메일(email)이 중복되지 않는 user 테이블을 생성하시오.
-- 5. 주문 테이블을 생성하고 회원 테이블을 참조하도록 설정하시오.
-- 6. member 테이블에 phone 컬럼을 추가하시오.
-- 7. member 테이블의 name 컬럼 길이를 100으로 변경하시오.
-- 8. member 테이블의 phone 컬럼명을 mobile로 변경하시오.
-- 9. member 테이블에서 age 컬럼을 삭제하시오.
-- 10. member 테이블의 email 컬럼에 UNIQUE 제약조건을 추가하시오.
-- 11. email UNIQUE 제약조건을 삭제하시오.
-- 12. member 테이블 이름을 customer로 변경하시오.
-- 13. product 테이블을 삭제하시오.
-- 14. board 테이블의 모든 데이터를 삭제하시오.
-- 15. member 테이블 구조와 데이터를 복사하여 member_backup 테이블을 생성하시오.