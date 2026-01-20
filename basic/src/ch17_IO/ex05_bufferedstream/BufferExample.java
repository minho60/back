package ch17_IO.ex05_bufferedstream;

import java.io.*;
/**
 * 성능 향상 스트림
 *  - 출력 스트림은 메모리 버퍼(Buffer)에 데이터를 보냄으로써 출력 속도를 향상시킬 수 있다.
 *    버퍼는 데이터가 쌓이기를 기다렸다가 꽉 차게 되면 데이터를 한꺼번에 하드 디스크로 보냄으로써 출력 횟수를 줄여 준다.
 * 	- 입력 스트림에서도 버퍼를 사용하면 읽기 성능이 좋아진다.
 * 	  하드 디스크로부터 직접 읽는 것 보다는 메모리 버퍼로부터 읽는 것이 빠르다.
 *  - 메모리 버퍼를 제공하여 프로그램의 실행 성능을 향상시키는 보조 스크림이 있다.
 *  
 *  	// 바이트 스트림
 *  	BufferedInputStream bis = new BufferedInputStream(바이트입력스트림);
 *  	BufferedInputStream bos = new BufferedOutputStream(바이트출력스트림);
 *  
 *  	// 문자 스트림
 *  	BufferedReader br = new BufferedReader(문자입력스트림);
 *  	BufferedWriter bw = new BufferedWriter(문자출력스트림);	
 *  	   
 * 
 */
	public class BufferExample {
		public static void main(String[] args) throws Exception {
			//입출력 스트림 생성
			String originalFilePath1 =
					BufferExample.class.getResource("originalFile1.jpg").getPath();
			String targetFilePath1 = "C:/kmh/git/back/basic/src/ch17_IO/temp/targetFile1.jpg";
			FileInputStream fis = new FileInputStream(originalFilePath1);
			FileOutputStream fos = new FileOutputStream(targetFilePath1);
			
			//입출력 스트림 + 버퍼 스트림 생성
			String originalFilePath2 =
					BufferExample.class.getResource("originalFile2.jpg").getPath();
			String targetFilePath2 = "C:/kmh/git/back/basic/src/ch17_IO/temp/targetFile2.jpg";
			FileInputStream fis2 = new FileInputStream(originalFilePath2);
			FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
			BufferedInputStream bis = new BufferedInputStream(fis2);
			BufferedOutputStream bos = new BufferedOutputStream(fos2);
			
			//버퍼를 사용하지 않고 복사
			long nonBufferTime = copy(fis, fos);
			System.out.println("버퍼 미사용:\t" + nonBufferTime + " ns");
			
			//버퍼를 사용하고 복사
			long bufferTime = copy(bis, bos);
			System.out.println("버퍼 사용:\t" + bufferTime + " ns");
				
			fis.close();
			fos.close();
			bis.close();
			bos.close();
		}
		
		public static long copy(InputStream is, OutputStream os) throws Exception {
			//시작 시간 저장
			long start = System.nanoTime();
			//1 바이트를 읽고 1 바이트를 출력
			while(true) {
				int data = is.read();
				if(data == -1) break;
				os.write(data);
			}
			os.flush();
			//끝 시간 저장
			long end = System.nanoTime();
			//복사 시간 리턴
			return (end-start);
		}
	}	