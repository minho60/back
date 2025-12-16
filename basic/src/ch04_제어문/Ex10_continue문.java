package ch04_제어문;

/**
 *continue(계속)문
 *	- continue 이후 문장은 실행하지 않고,
 * 	- for문은 증감식으로, while 문의 경우 조건식으로 이동하여
 * 	- 제어문을 계속 실행한다. 
 */
public class Ex10_continue문 {

	public static void main(String[] args) {
		// i 는 1부터 10까지 10번 반복
		for(int i=1; i<=10; i++) {
			if(i%2 != 0) {
				// i를 2로 나누었을 떄 나머지가 0과 같이 않으면 
				// -> 홀수 이면
				continue;
			}
			System.out.print(i + " ");
		}

	}

}
