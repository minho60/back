package ch17_IO.ex09_file과files;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * java.io.File
 * 	
 *  - 파일 객체 생성
 * 		File file = new File("C:/Temp/file.txt");
 * 		File file = new File("C:\\Temp\\file.txt");
 *  - 파일이나 폴더 존재여부 확인
 *  	boolean isExist = file.exists(); // 존재하면 true 리턴
 *  
 *  1. boolean createNewFile(): 새로운 파일 생성
 *  2. boolean mkdir(): 새로운 디렉토리 생성
 *  3. boolean mkdirs(): 경로상에 없는 모든 디렉토리 생성
 *  
 *  4. boolean delete(): 파일 또는 디렉토리 삭제
 *  5. boolean canExecute(): 실행할 수 있는 파일인지 여부
 *  6. boolean canRead(): 읽을 수 있는 파일인지 여부
 *  7. boolean canWrite(): 수정 및 저장할 수 있는 파일인지 여부
 *  8. String getName(): 파일 이름 리턴
 *  9. String getParent(): 부모 디렉토리 리턴
 * 10. File getParentFile(): 부모 디렉토리를 File 객체로 생성 후 리턴
 * 11. String getPath(): 전체 경로 리턴
 * 12. boolean isDirectory(): 디렉토리인지 여부
 * 13. boolean isFile(): 파일인지 여부
 * 14. boolean isHidden(): 숨김 파일인지 여부
 * 15. long lastModified(): 마지막 수정 날짜 및 시간 리턴
 * 16. long lengh(): 파일 크기 리턴
 * 17. String[] list()
 * 		: 디렉토리에 포함된 파일 및 서브 디렉토리 목록 전부를 String 배열로 리턴
 * 18. String[] list(FilenameFilter filter)
 * 		: 디렉토리에 포함된 파일 및 서브 디렉토리 목록 중에 
 * 		  FilenameFilter에 맞는 것만 String 배열로 리턴
 * 19. File[] listFiles()
 * 		: 디렉토리에 포함된 파일 및 서브 디렉토리 목록 전부를 File 배열로 리턴
 * 20. File[] listFiles(FilenameFilter filter)
 * 		: 디렉토리에 포함된 파일 및 서브 디렉토리 목록 중에
 * 		  FilenameFilter에 맞는 것만 File 배열로 리턴
 *
 * 입출력 스트림을 생성할 때 File 객체 활용하기
 * 	- 파일 또는 폴더의 정보를 얻기 위해 File 객체를 단독으로 사용할 수 있지만,
 *    파일 입출력 스트림을 생성할 때 경로 정보를 제공할 목적으로 사용되기도 한다.
 *    
 *    // 첫 번째 방법
 *    FileInputStream fis = new FileInputStream("C:/Temp/image.gif");
 *    // 두 번째 방법
 *    File file = new File("C:/Temp/image.gif");
 *    FileInputStream fis = new FileInputStream(file);
 *  
 */
// C:\Temp 디렉토리에 images 디렉토리와 file1.txt, file2.txt, file3.txt 파일을 생성하고,
// Temp 디렉토리에 있는 내용을 출력한다.
public class FileExample {
	public static void main(String[] args) throws Exception {
		//File 객체 생성
		File dir = new File("C:/kmh/git/back/basic/src/ch17_IO/temp/images");
		File file1 = new File("C:/kmh/git/back/basic/src/ch17_IO/temp/file1.txt");
		File file2 = new File("C:/kmh/git/back/basic/src/ch17_IO/temp/file2.txt");
		File file3 = new File("C:/kmh/git/back/basic/src/ch17_IO/temp/file3.txt");

		//존재하지 않으면 디렉토리 또는 파일 생성
		if(dir.exists() == false) { dir.mkdirs(); }
		if(file1.exists() == false) { file1.createNewFile(); }
		if(file2.exists() == false) { file2.createNewFile(); }
		if(file3.exists() == false) { file3.createNewFile(); }

		//Temp 폴더의 내용을 출력
		File temp = new File("C:/kmh/git/back/basic/src/ch17_IO/temp");
		File[] contents = temp.listFiles();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		for(File file : contents) {
			System.out.printf("%-25s", sdf.format(new Date(file.lastModified())));
			if(file.isDirectory()) {
				System.out.printf("%-10s%-20s", "<DIR>", file.getName());
			} else {
				System.out.printf("%-10s%-20s", file.length(), file.getName());
			}
			System.out.println();
		}
	}
}