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



-- ex02 회원가입 테이블 생성
CREATE TABLE `member` (
	  `phone` varchar(30),
	  `name` varchar(20),
	  `gender` char(1),
	  `id` varchar(50) PRIMARY KEY,
	  `pwd` varchar(100) NOT NULL,
	  `email` varchar(30),
	  `zipcode` char(7),
	  `address1` varchar(60),
	  `address2` varchar(60),
	  `hobby` char(5),
	  `job` varchar(30)
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
    
    -- 회원 테이블(members)의 id를 참조하는 외래키 설정 (회원만 글쓰기 가능할 경우)
    CONSTRAINT fk_board_writer FOREIGN KEY (userid) 
    REFERENCES member(id) ON DELETE CASCADE
);

-- 데이터 삽입
INSERT INTO board (userid, subject, content) VALUES
('kim','점심 메뉴 추천','오늘 점심 뭐 먹을지 고민입니다. 추천 부탁해요.'),
('admin','공지사항 안내','이번 주 시스템 점검이 예정되어 있습니다.'),
('minho','운동 루틴 공유','요즘 하고 있는 헬스 루틴 공유합니다.'),
('jiyoung','영화 추천','최근 재미있게 본 영화 추천해주세요.'),
('test01','코딩 질문','Servlet과 JSP 차이가 궁금합니다.'),
('guest','홈트 방법','집에서 할 수 있는 운동 알려주세요.'),
('subway_love','샌드위치 추천','에그마요 조합 추천 부탁드립니다.'),
('fitness_lee','단백질 섭취','운동 후 단백질 섭취 방법 공유합니다.'),
('bread_king','빵 맛집','서울 빵 맛집 추천해주세요.'),
('cookie_monster','쿠키 후기','최근 먹은 쿠키 후기 남깁니다.'),
('kim','자바 공부','자바 컬렉션 프레임워크 정리합니다.'),
('admin','업데이트 공지','게시판 기능이 업데이트되었습니다.'),
('minho','러닝 코스','서울 러닝 코스 추천해주세요.'),
('jiyoung','독서 모임','독서 모임 참여하실 분 모집합니다.'),
('test01','HTML 질문','form 태그 사용법 질문입니다.'),
('guest','요가 동작','집에서 하는 요가 동작 공유합니다.'),
('subway_love','신메뉴 후기','이번 신메뉴 맛있네요.'),
('fitness_lee','식단 관리','다이어트 식단 공유합니다.'),
('bread_king','플랫브레드 비교','허니오트 vs 플랫브레드 비교.'),
('cookie_monster','민트초코 사랑','민트초코 좋아하는 분?'),
('kim','떡볶이 레시피','간단 떡볶이 레시피 공유.'),
('admin','이벤트 안내','이번 달 이벤트 안내드립니다.'),
('minho','헬스 질문','벌크업 식단 조언 부탁.'),
('jiyoung','드라마 추천','요즘 볼만한 드라마 추천.'),
('test01','DB 연결','JDBC 연결 방법 질문.'),
('guest','스트레칭 팁','아침 스트레칭 방법 공유.'),
('subway_love','소스 조합','스위트어니언+랜치 추천.'),
('fitness_lee','운동 후기','오늘 운동 후기 남깁니다.'),
('bread_king','베이커리 리뷰','동네 빵집 리뷰.'),
('cookie_monster','초코칩 쿠키','초코칩 쿠키 맛집 추천.'),
('kim','여행 추천','주말 여행지 추천해주세요.'),
('admin','서버 점검','서버 점검 완료되었습니다.'),
('minho','자전거 코스','자전거 타기 좋은 곳.'),
('jiyoung','책 추천','최근 읽은 책 추천.'),
('test01','CSS 질문','flexbox 사용법 질문.'),
('guest','홈카페 레시피','간단 커피 레시피 공유.'),
('subway_love','아침 메뉴','모닝 메뉴 추천.'),
('fitness_lee','헬스장 추천','시설 좋은 헬스장 추천.'),
('bread_king','빵 종류','좋아하는 빵 종류는?'),
('cookie_monster','쿠키 만들기','쿠키 만드는 법 공유.'),
('kim','디저트 추천','맛있는 디저트 추천.'),
('admin','공지 테스트','공지 테스트 글입니다.'),
('minho','운동 자극','운동 자극 영상 추천.'),
('jiyoung','문화생활','전시회 추천 부탁.'),
('test01','Java 질문','상속 개념 설명 부탁.'),
('guest','건강 관리','면역력 관리 방법.'),
('subway_love','추천 조합2','에그마요+베이컨 후기.'),
('fitness_lee','체중 감량','감량 성공 후기.'),
('bread_king','빵 할인','빵 할인 정보 공유.'),
('cookie_monster','신상 쿠키','신상 쿠키 후기.'),
('kim','라면 팁','라면 맛있게 끓이는 법.'),
('admin','서비스 안내','신규 서비스 안내.'),
('minho','헬스 초보','헬스 초보 질문.'),
('jiyoung','취미 공유','요즘 취미 공유해요.'),
('test01','JSP 질문','EL 표현식 질문.'),
('guest','홈트 루틴','집에서 하는 루틴.'),
('subway_love','할인 정보','쿠폰 정보 공유.'),
('fitness_lee','단백질바 추천','맛있는 단백질바 추천.'),
('bread_king','빵 후기','오늘 먹은 빵 후기.'),
('cookie_monster','쿠키 추천2','쿠키 브랜드 추천.'),
('kim','점심 후기','오늘 점심 후기.'),
('admin','관리자 공지','관리자 공지사항입니다.'),
('minho','운동 기록','운동 기록 남깁니다.'),
('jiyoung','책 리뷰','책 리뷰 공유.'),
('test01','코딩 팁','코딩 공부 팁 공유.'),
('guest','건강 팁','건강 관리 팁.'),
('subway_love','써브웨이 후기','써브웨이 후기 공유.'),
('fitness_lee','식단 기록','식단 기록 공유.'),
('bread_king','빵 추천2','추천 빵 공유.'),
('cookie_monster','쿠키 후기2','쿠키 후기 남깁니다.');

INSERT INTO member (phone, name, gender, id, pwd, email, zipcode, address1, address2, hobby, job) VALUES
('010-4622-1616', '만호','M','ming1234','ming1234','nnene@naver.com','12345','용인시 수지구','풍덕천로161','게임','기타');

