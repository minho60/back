package ch04_제어문;

/**
 *break문
 *	- 제어문(switxh, for, while, do~while)을 탈출
 * 	- 제어문이 중첩 되어 있을 경우 가장 가까운 제어문을 탈줄 
 */
public class Ex09_break문 {

	public static void main(String[] args) {
		while(true) {
			int num = (int)(Math.random()*6) + 1;
			System.out.println(num);
			// 1줄 실행문 -> 중괄호 생략가능
			if(num == 6) break;
		}
		System.out.println("프로그램 종료");
		
		//라벨(label)
		Outter: for(char upper='A'; upper<='Z'; upper++) {
			for(char lower='a'; lower<='z'; lower++) {
				System.out.println(upper + "-" + lower);
				if(lower=='g') {
					break Outter;
				}
			}
		}
		System.out.println("프로그램 실행 종료");
		
	}

}
