package ch10_예외;

/**
 * 다중 catch 블록
 *  - catch 블록이 여러개라 할지라도
 *    여러 개 중 하나만 실행된다. 	
 *  
 *  	try{
 *  		// 예외 발생 코드
 *  	} catch(예외 종류1 e){
 *  		// 예외처리1
 *  	} catch(예외 종류2 e){
 *  		// 예외처리2
 *  	}
 */
public class Ex04_다중catch블록 {
	public static void main(String[] args) {
		String[] array = {"100", "1oo"};

		for(int i=0; i<=array.length; i++) {
			try {
				int value = Integer.parseInt(array[i]);
				System.out.println("array[" + i + "]: " + value);
				// 배열의 인덱스가 초과 되었을 경우 발생
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
				// 숫자 타입이 아닐 경우 발생
			} catch(NumberFormatException e) {
				System.out.println("숫자로 변환할 수 없음: " + e.getMessage());
			}
		}
	}
}
