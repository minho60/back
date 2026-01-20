package ch17_IO.ex09_file과files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Files 클래스
 * 
 * 	1. probeContentType(): 파일 확장명에 따른 파일 유형 리턴
 * 		예) 	.txt 파일 -> text/plain
 * 			.jpg 파일 -> image/jpeg
 *  2. writeString(): 문자열을 파일에 저장
 *  3. readString(): 텍스트 파일의 내용을 전부 읽고 String으로 리턴
 * 
 * 
 * 	- Path 객체 얻는 방법
 * 
 *  	Path path = Paths.get(String first, String... more)
 *  
 *  	// 절대 경로
 *  	Path path = Paths.get("C:/Temp/dir/file.txt");
 *  	Path path = Paths.get("C:/Temp/dir", "file.txt");
 *  	Path path = Paths.get("C:","Temp","dir","file.txt");
 *  
 *  	// 상대 경로
 *  	Path path = Paths.get("dir/file.txt");
 *  	Path path = Paths.get("./dir/file.txt");
 *  
 *  	// 현재 위치가 "C:\Temp\dir1"이라면 "C:/Temp/dir2/file.txt"는
 *  	Path path = Paths.get("../dir2/file.txt");
 *  
 *  
 */
// Files 클래스를 이용하여 C:/Temp 디렉토리에 user.txt 파일을 생성하고 읽는 방법을 보여준다.
public class FilesExample {
	public static void main(String[] args) {
		try {
			String data = "" +
					"id: winter\n" +
					"email: winter@mycompany.com\n" +
					"tel: 010-123-1234";
						
			//Path 객체 생성
			Path path = Paths.get("C:/kmh/git/back/basic/src/ch17_IO/temp/user.txt");
			
			//파일 생성 및 데이터 저장
			Files.writeString(Paths.get("C:/kmh/git/back/basic/src/ch17_IO/temp/user.txt"), data, Charset.forName("UTF-8"));
					
			//파일 정보 얻기
			System.out.println("파일 유형: " + Files.probeContentType(path));
			System.out.println("파일 크기: " + Files.size(path) + " bytes");
			
			//파일 읽기
			String content = Files.readString(path, Charset.forName("UTF-8"));
			System.out.println(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}