package ch11_base모듈.sec01_Object.ex02_hashCode메서드;

// ctrl+shift+o 자동임포트
import java.util.HashSet;

/**
 * Set 은 동등 객체를 중복 저장하지 않는다.
 * 예)  HashSet
 * hashcode()와 equals() 메서드를 이용해서 동등 객체인지 판단한다.
 * 
 *  
 */
public class HashSetExample {
	public static void main(String[] args) {
		HashSet hashSet = new HashSet();


		Student s1 = new Student(1, "홍길동");
		// add(): 객체 삽입
		hashSet.add(s1);
		// size(): 객체 수
		System.out.println("저장된 객체 수: " + hashSet.size());

		Student s2 = new Student(1, "홍길동");
		hashSet.add(s2); // 동등 객체는 저장 되지 않는다.
		System.out.println("저장된 객체 수: " + hashSet.size());

		Student s3 = new Student(2, "홍길동");
		hashSet.add(s3);
		System.out.println("저장된 객체 수: " + hashSet.size());
	}
}