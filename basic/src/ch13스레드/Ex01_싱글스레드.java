package ch13스레드;

import java.awt.Toolkit;

/**
 * 메인 스레드가 동시에 두 가지 작업을 처리할 수 없음
 * -> 비프(beep)음을 모두 발생한 다음에 프린팅 
 */
public class Ex01_싱글스레드 {
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0; i<5; i++) {
			toolkit.beep();
			try { Thread.sleep(500); } catch(Exception e) {}
		}

		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try { Thread.sleep(500); } catch(Exception e) {}
		}
	}
}