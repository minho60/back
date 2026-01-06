package ch10_예외.ex_예외강제발생;

//사용자 정의 예외
public class InsufficientException extends Exception {
	public InsufficientException() {
	}

	public InsufficientException(String message) {
		super(message);
	}
}