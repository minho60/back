package ch17_IO.ex06_기본타입입출력스트림;

import java.io.*;
/**
 * 기본 타입 스트림
 *  - 바이트 스트림에 DataInputStream과 DataOutputStream 보조 스트림을 연결하면
 *    기본 타입인 boolean, char, short, int, long, float, double 값을 입출력할 수 있다.
 *    
 *    DataInputStream dis = new DataInputStream(바이트입력스트림);
 *    DataOutputStream dos = new DataOutputStream(바이트출력스트림);
 *    
 *    1. boolean readBoolean()
 *    2. byte readByte()
 *    3. char readChar()
 *    4. double readDouble()
 *    5. float readFloat()
 *    6. int readInt()
 *    7. long readLong()
 *    8. short readShort()
 *    9. String readUTF()
 *    
 *    1. void writeBoolean(boolean v)
 *    2. void writeByte(int v)
 *    3. void writeChar(int v)
 *    4. void writeDouble(double v)
 *    5. void writeFloat(float v)
 *    6. void writeInt(int v)
 *    7. void writeLong(long v)
 *    8. void writeShort(int v)
 *    9. void writeUTF(String str)
 *    
 *	- 데이터 타입의 크기가 모두 다르므로
 *	  DataOutputStream으로 출력한 데이터를 다시 DataInputStream으로 읽어 올 때에는
 *	  출력한 순서와 동일한 순서로 읽어야 한다.
 *	  예) 출력할 때의 순서가 int -> Boolean -> double이라면
 *		 읽을 때의 순서도 int -> Boolean -> double이어야 한다.
 *
 */
// 이름, 성적, 순위 순으로 파일에 출력하고, 다시 파일로부터 읽는 방법을 보여 준다. 
public class DataInputOutputStreamExample {
	public static void main(String[] args) throws Exception {
		//DataOutputStream 생성
		FileOutputStream fos = new FileOutputStream("C:/kmh/git/back/basic/src/ch17_IO/temp/primitive.db");
		DataOutputStream dos = new DataOutputStream(fos);

		//기본 타입 출력
		dos.writeUTF("홍길동");
		dos.writeDouble(95.5);
		dos.writeInt(1);

		dos.writeUTF("감자바");
		dos.writeDouble(90.3);
		dos.writeInt(2);
		
		dos.flush(); dos.close(); fos.close();
		
		//DataInputStream 생성
		FileInputStream fis = new FileInputStream("C:/kmh/git/back/basic/src/ch17_IO/temp/primitive.db");
		DataInputStream dis = new DataInputStream(fis);
		
		//기본 타입 입력
		for(int i=0; i<2; i++) {
			String name = dis.readUTF();
			double score = dis.readDouble();
			int order = dis.readInt();
			System.out.println(name + " : " + score + " : " + order);
		}

		dis.close(); fis.close();
	}
}