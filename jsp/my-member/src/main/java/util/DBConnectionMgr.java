package util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnectionMgr {

	private static final String URL =
			"jdbc:mysql://localhost:3306/testdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static final String USER = "minho";
	private static final String PASSWORD = "1234";

	public static Connection getConnection() {
		try {
			System.out.println("DB접속완료");
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
