package ch10_예외;

/**
 * main() 메서드에서도 throws 키워드를 사용하여 예외를 떠넘길 수 있다.
 * -> JVM은 예외의 내용을 콘솔에 출력하는 것으로 예외 처리한다.
 */
public class Ex09_메인메서드예외전가 {
	public static void main(String[] args) throws Exception {
		findClass();
	}

	public static void findClass() throws ClassNotFoundException {
		Class.forName("java.lang.String2");
	}
}