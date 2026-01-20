package ch17_IO.ex01_바이트출력스트림;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class IO02_바이트배열출력 {
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("C:/kmh/git/back/basic/src/ch17_입출력/temp/test2.db");

			byte[] array = { 10, 20, 30, 40 };

			os.write(array);

			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}