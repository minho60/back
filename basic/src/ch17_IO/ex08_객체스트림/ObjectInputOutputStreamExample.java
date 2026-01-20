package ch17_IO.ex08_객체스트림;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
/**
 * 객체 스트림
 *  - 자바는 메모리에 생성된 객체를 파일 또는 네트워크로 출력할 수 있다.
 *  - 직렬화(serialization): 필드값을 일렬로 늘어선 바이트로 변경하는 것
 *  - 역직렬화(deserialization): 직렬화된 바이트를 객체의 필드값으로 복원하는 것
 *  - ObjectInputStream과 ObjectOutputStream은 객체를 입출력할 수 있는 보조 스트림이다.
 *  - ObjectOutputStream은 바이트 출력 스트림과 연결되어 객체를 직렬화하고,
 *    ObjectInputStream은 바이트 입력 스트림과 연결되어 객체로 복원하는 역직렬화를 한다.
 *    
 *    FileOutputStream -> ObjectOutputStream: 직렬화
 *    FileInputStream  <- ObjectInputStream: 역직렬화
 *    
 *    ObjectInputStream ois = new ObjectInputStream(바이트입력스트림);
 *    ObjectOutputStream oos = new ObjectOutputStream(바이트출력스트림);
 *    
 *    1. writeObject(): 객체를 직렬화
 *    2. readObject(): 읽은 바이트를 역직렬화해서 객체로 생성한다.
 *   
 */
// 다양한 객체를 파일에 저장하고 다시 파일로부터 읽어 객체로 복원한다.
// 복수의 객체를 저장할 경우 출력된 객체 순서와 동일한 순서로 객체를 읽어야 한다.
public class ObjectInputOutputStreamExample {
	public static void main(String[] args) throws Exception {
		//FileOutputStream에 ObjectOutputStream 보조 스트림 연결
		FileOutputStream fos = new FileOutputStream("C:/kmh/git/back/basic/src/ch17_IO/temp/object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		//객체 생성
		Member m1 = new Member("fall", "단풍이");
		Product p1 = new Product("노트북", 1500000);
		int[] arr1 = { 1, 2, 3 };
		
		//객체를 역직렬화해서 파일에 저장
		oos.writeObject(m1);
		oos.writeObject(p1);
		oos.writeObject(arr1);
		
		oos.flush(); oos.close(); fos.close();
			
		//FileInputStream에 ObjectInputStream 보조 스트림 연결
		FileInputStream fis = new FileInputStream("C:/kmh/git/back/basic/src/ch17_IO/temp/object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//파일을 읽고 역질렬화해서 객체로 복원
		Member m2 = (Member) ois.readObject();
		Product p2 = (Product) ois.readObject();
		int[] arr2 = (int[]) ois.readObject();
		
		ois.close(); fis.close();
		
		//복원된 객체 내용 확인
		System.out.println(m2);
		System.out.println(p2);
		System.out.println(Arrays.toString(arr2));
	}
}