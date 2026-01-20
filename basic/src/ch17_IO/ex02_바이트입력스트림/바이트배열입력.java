package ch17_IO.ex02_바이트입력스트림;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class 바이트배열입력 {
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("C:/kmh/git/back/basic/src/ch17_입출력/temp/test2.db");
			
			byte[] data = new byte[100];

			while(true) {
				int num = is.read(data);
				if(num == -1) break;

				for(int i=0; i<num; i++) {
					System.out.println(data[i]);
				}
			}

			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}