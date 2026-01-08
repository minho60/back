package ch11_base모듈.sec05_Math;

import java.util.Arrays;

import java.util.Random;
/**
 * java.lang.Math.random()
 *  - 0.0<=x<1.0 의 double 타입의 난수 리턴
 * 	- start부터 시작하는 n개의 정수 중 하나의 정수를 얻으려면?
 * 
 *   	int num = (int) (Math.random() * n) + start
 *   
 *   에) 1~6 까지 주사위의 눈
 *   	(int) (Math.random()*6)+1
 *   예) 1~45 까지 로또번호
 *   	(int) (Math.random()*45)+1
 *   
 * java.util.Random
 *  - boolean, int, double 난수를 얻을 수 있다.
 *  
 *  	// 생성자
 *  	Random(): 현재 시간을 이용해서 종자값을 자동 설정한다.
 *  	Random(long seed): 주어진 종자값을 사용한다.
 * 
 * 종자값(seed)란? 
 * 	- 난수를 만드는 알고리즘에 사용되는 값으로
 *    종자값이 같으면 같은 난수를 얻는다.
 *    
 *    	// 메서드
 *    	boolean nextBoolan(): boolean 타입의 난수 리턴
 *    	double nextDouble(): double 타입의 난수 리턴(0.0<=~<1.0)
 *    	int nextInt(): int 타입의 난수 리턴(-2의32승<=~<2의32승-1)
 *    	int nextInt(int n): int 타입의 난수 리턴(0<=~<n)
 *   
 */
public class ex02_Random {
	public static void main(String[] args) {
		//선택번호
		int[] selectNumber = new int[6];
		Random random = new Random();
		// double rand = Math.random(); // 0.0<= x <1.0
		//int rand = (int) (Math.random()*45); // 0<= x <45 사이의 정수
		int rand = (int) (Math.random()*45)+1; // 1<= x <46 사이의 정수
		
		System.out.println(rand);
		
		
		System.out.print("선택번호: ");
		for(int i=0; i<6; i++) {
			selectNumber[i] =  (int) (Math.random()*45)+1;
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();

		//당첨번호
		int[] winningNumber = new int[6];
		random = new Random(5);
		System.out.print("당첨번호: ");
		for(int i=0; i<6; i++) {
			winningNumber[i] = random.nextInt(45) + 1;
			System.out.print(winningNumber[i] + " ");
		}
		System.out.println();

		//당첨여부
		Arrays.sort(selectNumber);
		Arrays.sort(winningNumber);
		boolean result = Arrays.equals(selectNumber, winningNumber);
		System.out.print("당첨여부: ");
		if(result) {
			System.out.println("1등에 당첨되셨습니다.");
		} else {
			System.out.println("당첨되지 않았습니다.");
		}
	}
}