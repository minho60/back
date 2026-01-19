package ch17_입출력.ex01_바이트출력스트림;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
	
public class IO03_배열일부출력 {
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("C:/kmh/git/back/basic/src/ch17_입출력/temp/test3.db");

			byte[] array = { 10, 20, 30, 40, 50 };

			os.write(array, 1, 3);

			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}