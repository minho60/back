package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * [DB 연결 관리 유틸리티 클래스]
 * JDBC(Java Database Connectivity)를 사용하여 Java 어플리케이션과
 * MySQL 데이터베이스 간의 물리적 통로(Connection)를 생성하는 역할을 합니다.
 */
public class DBConnectionMgr {

    // 1. 데이터베이스 접속 주소 (JDBC URL)
    // - localhost:3306 : 본인 PC에서 동작 중인 MySQL의 기본 포트
    // - testdb : 접속할 데이터베이스(Schema) 이름
    // - useSSL=false : 보안 연결(SSL: Secure Sockets Layer) 사용 안 함 (로컬 연습용 설정)
	// - SSL(Secure Sockets Layer)은 웹브라우저와 웹서버 간의 데이터를 암호화하여 주고받기 위한 표준 보안 기술
    // - serverTimezone=UTC : 서버와 클라이언트 간의 시간대 일치 설정 (필수)
    // - allowPublicKeyRetrieval=true : 암호화된 비밀번호 전송을 위한 공개키 요청 허용
    // - characterEncoding=UTF-8 : 한글 깨짐 방지를 위한 문자 인코딩 설정
    private static final String URL = "jdbc:mysql://mysql-minho.alwaysdata.net:3306/minho_db?"
    		+ "useSSL=false"
    		+ "&serverTimezone=UTC&"
    		+ "allowPublicKeyRetrieval=true&"
    		+ "characterEncoding=UTF-8";
    
    // 2. 데이터베이스 계정 정보
    private static final String USER = "minho";      // MySQL 사용자 계정
    private static final String PASSWORD = "zjajj899"; // 해당 계정의 비밀번호

    /**
     * [데이터베이스 연결 객체 획득 메서드]
     * @return Connection : DB 작업에 필요한 연결 통로 객체
     * @throws SQLException : DB 접속 실패, URL 오류, ID/PW 불일치 시 발생
     */
    public static Connection getConnection() throws SQLException {
        try {
            /*
             * [명시적 드라이버 로딩]
             * Class.forName()은 문자열로 된 클래스명을 찾아 메모리에 로드합니다.
             * 최신 JDBC(4.0+) 버전에서는 생략 가능하지만, 톰캣 10.1 등 일부 서버 환경에서
             * 드라이버를 인식하지 못하는 현상을 방지하기 위해 명시적으로 작성하는 것이 안전합니다.
             */
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch (ClassNotFoundException e) {
            // 드라이버 파일(.jar)이 WEB-INF/lib 폴더에 없을 경우 발생
            System.err.println("JDBC 드라이버 로딩 실패: " + e.getMessage());
            e.printStackTrace();
        }

        /*
         * [실제 연결 생성]
         * DriverManager는 로드된 드라이버들을 순차적으로 확인하여 URL에 맞는
         * MySQL 연결 객체를 생성하여 반환합니다.
         */
        // 1. 연결 시도
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        
        // 2. 성공 시 메시지 출력 (위의 getConnection에서 예외가 발생하면 이 줄은 실행되지 않음)
        System.out.println("DB 연결 성공!"); 
        
        return conn;
    }
}