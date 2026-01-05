package ch10_예외;

public class Ex03_ClassNotFoundException {

	public static void main(String[] args) {
		try {
			// Class.ForName("패키지...클래스")
			// - ClassPath 위치에서 주어진 클래스를 찾는다.
			// - 찾지 못하면 ClassNotFoundException 일반 예외 발생
			Class.forName("java.lang.String");
			System.out.println("java.lang.String 클래스가 존재합니다.");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println();

		try {
			Class.forName("java.lang.String2");
			System.out.println("java.lang.String2 클래스가 존재합니다.");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
