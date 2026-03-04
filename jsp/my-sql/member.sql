-- DB 생성
CREATE SCHEMA `testdb` DEFAULT CHARACTER SET utf8mb4 ;

-- DB 사용
USE testdb;

-- 테이블 생성
CREATE TABLE users(
	id VARCHAR(50) PRIMARY KEY,
    pwd VARCHAR(100) NOT NULL
);

-- 데이터 삽입
INSERT INTO `testdb`.`users`(`userid`,`userpw`)
VALUES('kim','1234');

INSERT INTO users (userid, userpw) VALUES
('ming', 'ming123'),
('neneko', 'neneko123');


INSERT INTO users (userid, userpw) VALUES
('kim','1234'),
('admin', 'admin123'),
('minho', 'minho1234'),
('jiyoung', 'jy2025'),
('test01', 'test1234'),
('guest', 'guest0000'),
('subway_love','1111'),
('fitness_lee','1111'),
('bread_king','1111'),
('cookie_monster','1111'),
('daily_sub','1111'),
('vege_pure','1111'),
('newbie_99','1111'),
('sauce_master','1111'),
('hungry_bear','1111'),
('shrimp_fan','1111');

-- 조회
SELECT*FROM users;

-- 삭제
DELETE FROM `testdb`.`users` WHERE useridIN ('minho', 'guest');



DROP TABLE IF EXISTS member;

CREATE TABLE `member` (
	  `name` varchar(20) NOT NULL,
	  `gender` char(1),
	  `phone` varchar(20),
	  `id` varchar(50) PRIMARY KEY,
	  `pwd` varchar(100),
	  `email` varchar(50) NOT NULL,
	  `zipcode` char(5),
	  `address1` varchar(60),
	  `address2` varchar(60),
	  `hobby` char(5),
	  `job` varchar(15),
	  `sns_type` varchar(20),
	  `sns_id` varchar(100),
	  `regdate` DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO member (phone, name, gender, id, pwd, email, zipcode, address1, address2, hobby, job) VALUES
('010-1111-1111','김철수','M','kim','pass123','kim@example.com','12345','서울특별시 강남구','역삼동 101-1','인터넷','학생'),
('010-2222-2222','관리자','F','admin','adminpass','admin@example.com','23456','서울특별시 서초구','서초동 202-2','게임','공무원'),
('010-3333-3333','박민호','M','minho','minhopwd','minho@example.com','34567','서울특별시 송파구','잠실동 303-3','영화','교수학생'),
('010-4444-4444','최지영','F','jiyoung','jy1234','jiyoung@example.com','45678','서울특별시 마포구','합정동 404-4','영화','회사원'),
('010-5555-5555','테스터','M','test01','testpass','test01@example.com','56789','서울특별시 강동구','천호동 505-5','게임','연구전문직'),
('010-6666-6666','게스트','F','guest','guestpwd','guest@example.com','67890','서울특별시 용산구','이태원동 606-6','인터넷','무직'),
('010-7777-7777','써브웨이러버','M','subway_love','subway123','subway@example.com','78901','서울특별시 동작구','사당동 707-7','운동','일반자영업'),
('010-8888-8888','헬스러','F','fitness_lee','fitpass','fitness@example.com','89012','서울특별시 관악구','신림동 808-8','운동','의료인'),
('010-9999-9999','빵왕','M','bread_king','bread123','bread@example.com','90123','서울특별시 서대문구','연희동 909-9','영화','종교,언론,예술인'),
('010-1010-1010','쿠키몬스터','F','cookie_monster','cookiepwd','cookie@example.com','01234','서울특별시 마포구','합정동 1010-10','게임','기타');


-- 게시판 테이블
CREATE TABLE board (
    num         INT AUTO_INCREMENT PRIMARY KEY, -- 게시글 고유 번호 (자동 증가)
    userid      VARCHAR(50) NOT NULL,           -- 작성자 아이디 (members 테이블의 id와 연결)
    subject     VARCHAR(200) NOT NULL,          -- 게시글 제목
    content     TEXT NOT NULL,                  -- 게시글 내용 (긴 문장 대응)
    regdate     DATE DEFAULT (current_date()), -- 작성일 (현재 시간 기본값, YYYY-MM-DD)
    readcount   INT DEFAULT 0,                  -- 조회수 (기본값 0)
    pass		VARCHAR(15) NOT NULL,
    filename	VARCHAR(30),
    filesize	INT,
    -- 회원 테이블(member)의 id를 참조하는 외래키 설정 (회원만 글쓰기 가능할 경우)
    CONSTRAINT fk_board_writer FOREIGN KEY (userid) 
    REFERENCES member(id) ON DELETE CASCADE
);

-- 73개 데이터 삽입
INSERT INTO board (userid, subject, content, regdate, readcount, pass) VALUES
('kim','오늘 점심 메뉴 추천','점심 메뉴로 뭐 먹을지 고민중이에요.','2026-02-14',5,'pass123'),
('admin','서버 점검 안내','오늘 오후 2시부터 서버 점검이 있습니다.','2026-02-13',12,'adminpass'),
('minho','최근 영화 후기','이번에 본 영화 재밌게 봤습니다.','2026-02-12',3,'minhopwd'),
('jiyoung','운동 루틴 공유','오늘 헬스장에서 루틴 기록 공유합니다.','2026-02-11',7,'jy1234'),
('test01','신작 게임 리뷰','최근 출시된 게임 후기 올려요.','2026-02-10',2,'testpass'),
('guest','주말 여행 계획','이번 주말 여행 계획 공유합니다.','2026-02-09',0,'guestpwd'),
('subway_love','샌드위치 추천','오늘 먹은 샌드위치 후기입니다.','2026-02-08',6,'subway123'),
('fitness_lee','헬스 기구 리뷰','새로 산 헬스 기구 사용 후기 올립니다.','2026-02-07',1,'fitpass'),
('bread_king','허니오트 빵이 정말 고소하네요','오늘 아침에 먹었는데 든든합니다.','2026-02-06',12,'bread123'),
('cookie_monster','쿠키 레시피 공유','집에서 만든 쿠키가 맛있어요.','2026-02-05',4,'cookiepwd'),

('kim','점심 메뉴 추천 2','오늘 점심은 뭘 먹을까요?','2026-02-04',8,'pass123'),
('admin','공지사항 2','사이트 이용 안내 공지입니다.','2026-02-03',15,'adminpass'),
('minho','책 리뷰 2','최근 읽은 책 후기 공유합니다.','2026-02-02',2,'minhopwd'),
('jiyoung','운동 계획 2','이번 주 운동 계획입니다.','2026-02-01',6,'jy1234'),
('test01','게임 공략 2','신작 게임 공략법 공유합니다.','2026-01-31',1,'testpass'),
('guest','여행 사진 2','여행 사진 올려봅니다.','2026-01-30',0,'guestpwd'),
('subway_love','샌드위치 리뷰 2','맛있게 먹은 후기 공유합니다.','2026-01-29',7,'subway123'),
('fitness_lee','헬스 기록 2','오늘 운동 기록입니다.','2026-01-28',3,'fitpass'),
('bread_king','바게트 빵이 바삭해요','점심에 먹었는데 좋았습니다.','2026-01-27',9,'bread123'),
('cookie_monster','쿠키 만들기 2','레시피 공유합니다.','2026-01-26',5,'cookiepwd'),

('kim','점심 메뉴 추천 3','점심 메뉴로 뭐 먹을지 고민중이에요.','2026-01-25',4,'pass123'),
('admin','서버 점검 안내 3','오늘 오후 2시부터 서버 점검이 있습니다.','2026-01-24',10,'adminpass'),
('minho','최근 영화 후기 3','이번에 본 영화 재밌게 봤습니다.','2026-01-23',6,'minhopwd'),
('jiyoung','운동 루틴 공유 3','오늘 헬스장에서 루틴 기록 공유합니다.','2026-01-22',8,'jy1234'),
('test01','신작 게임 리뷰 3','최근 출시된 게임 후기 올려요.','2026-01-21',2,'testpass'),
('guest','주말 여행 계획 3','이번 주말 여행 계획 공유합니다.','2026-01-20',1,'guestpwd'),
('subway_love','샌드위치 추천 3','오늘 먹은 샌드위치 후기입니다.','2026-01-19',7,'subway123'),
('fitness_lee','헬스 기구 리뷰 3','새로 산 헬스 기구 사용 후기 올립니다.','2026-01-18',0,'fitpass'),
('bread_king','허니브레드 후기','아침에 먹으니 든든합니다.','2026-01-17',11,'bread123'),
('cookie_monster','쿠키 레시피 공유 3','집에서 만든 쿠키가 맛있어요.','2026-01-16',5,'cookiepwd'),

('kim','점심 메뉴 추천 4','오늘 점심은 뭘 먹을까요?','2026-01-15',6,'pass123'),
('admin','공지사항 4','사이트 이용 안내 공지입니다.','2026-01-14',12,'adminpass'),
('minho','책 리뷰 4','최근 읽은 책 후기 공유합니다.','2026-01-13',2,'minhopwd'),
('jiyoung','운동 계획 4','이번 주 운동 계획입니다.','2026-01-12',3,'jy1234'),
('test01','게임 공략 4','신작 게임 공략법 공유합니다.','2026-01-11',1,'testpass'),
('guest','여행 사진 4','여행 사진 올려봅니다.','2026-01-10',0,'guestpwd'),
('subway_love','샌드위치 리뷰 4','맛있게 먹은 후기 공유합니다.','2026-01-09',8,'subway123'),
('fitness_lee','헬스 기록 4','오늘 운동 기록입니다.','2026-01-08',3,'fitpass'),
('bread_king','바게트 빵 후기','점심에 먹었는데 좋았습니다.','2026-01-07',10,'bread123'),
('cookie_monster','쿠키 만들기 4','레시피 공유합니다.','2026-01-06',5,'cookiepwd'),

('kim','점심 메뉴 추천 5','점심 메뉴로 뭐 먹을지 고민중이에요.','2026-01-05',2,'pass123'),
('admin','서버 점검 안내 5','오늘 오후 2시부터 서버 점검이 있습니다.','2026-01-04',7,'adminpass'),
('minho','최근 영화 후기 5','이번에 본 영화 재밌게 봤습니다.','2026-01-03',4,'minhopwd'),
('jiyoung','운동 루틴 공유 5','오늘 헬스장에서 루틴 기록 공유합니다.','2026-01-02',6,'jy1234'),
('test01','신작 게임 리뷰 5','최근 출시된 게임 후기 올려요.','2026-01-01',1,'testpass'),
('guest','주말 여행 계획 5','이번 주말 여행 계획 공유합니다.','2026-01-01',0,'guestpwd'),
('subway_love','샌드위치 추천 5','오늘 먹은 샌드위치 후기입니다.','2026-01-02',3,'subway123'),
('fitness_lee','헬스 기구 리뷰 5','새로 산 헬스 기구 사용 후기 올립니다.','2026-01-03',2,'fitpass'),
('bread_king','허니브레드 후기 2','아침에 먹으니 든든합니다.','2026-01-04',12,'bread123'),
('cookie_monster','쿠키 레시피 공유 5','집에서 만든 쿠키가 맛있어요.','2026-01-05',4,'cookiepwd'),

('kim','점심 메뉴 추천 6','오늘 점심은 뭘 먹을까요?','2026-01-06',5,'pass123'),
('admin','공지사항 6','사이트 이용 안내 공지입니다.','2026-01-07',9,'adminpass'),
('minho','책 리뷰 6','최근 읽은 책 후기 공유합니다.','2026-01-08',2,'minhopwd'),
('jiyoung','운동 계획 6','이번 주 운동 계획입니다.','2026-01-09',6,'jy1234'),
('test01','게임 공략 6','신작 게임 공략법 공유합니다.','2026-01-10',1,'testpass'),
('guest','여행 사진 6','여행 사진 올려봅니다.','2026-01-11',0,'guestpwd'),
('subway_love','샌드위치 리뷰 6','맛있게 먹은 후기 공유합니다.','2026-01-12',8,'subway123'),
('fitness_lee','헬스 기록 6','오늘 운동 기록입니다.','2026-01-13',3,'fitpass'),
('bread_king','바게트 빵 후기 2','점심에 먹었는데 좋았습니다.','2026-01-14',10,'bread123'),
('cookie_monster','쿠키 만들기 6','레시피 공유합니다.','2026-01-14',5,'cookiepwd');



