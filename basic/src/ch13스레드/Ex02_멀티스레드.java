package ch13스레드;

import java.awt.Toolkit;

/**
 * 작업 스레드 생성 방법
 * 1. Thread 클래스로 직접 생성
 * 2. Thread 자식 클래스로 생성
 * 
 *  
 * Thread 클래스로 직접 생성
 * -> 0.5초 주기로 비프음을 발생시키면서 동시에 프린팅 
 * 
 * 		// 익명 구현 객체
 * 		Thread thread = new Thread(new Runnable() {
 * 			@override
 * 			public void run() {
 * 				// 스레드가 실행할 코드
 * 			}
 * 		});
 * 
 */
public class Ex02_멀티스레드 {
	public static void main(String[] args) {
		// 익명 구현 객체
		// 작업 스레드 생성
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i=0; i<5; i++) {
					toolkit.beep();
					try { Thread.sleep(500); } catch(Exception e) {}
				}
			}
		});
		
		// 작업 스레드 실행
		thread.start();
		
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try { Thread.sleep(500); } catch(Exception e) {}
		}
	}
}
