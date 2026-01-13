package ch13스레드;

import java.awt.Toolkit;

/**
 * Thread 자식 클래스로 생성
 * 	 - Thread 클래스를 상속한 다음 run() 메서드를 재정의해서
 *     스레드가 실행할 코드를 작성하고, 객체를 생성한다.
 *     
 *     public class WorkerThread extends Thread {
 *     		@Override
 *     		public void run() {
 *     			// 스레드가 실행할 코드
 *     		}
 *     }
 *     
 *     // 스레드 객체 생성
 *     Thread thread = new WorkerThread();
 *     
 *     
 * 	- Thread 익명 자식 객체 사용
 * 
 * 		Thread thread = new Thread() {
 * 			@Override
 * 			public void run() {
 * 				// 스레드가 실행할 코드
 * 			}
 * 		}
 * 		thread.start();
 *     
 */
public class Ex03_멀티스레드_익명자식객체 {
	public static void main(String[] args) {
		// 익명 자식 객체
		// 작업 스레드 실행
		Thread thread = new Thread() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i=0; i<5; i++) {
					toolkit.beep();
					try { Thread.sleep(500); } catch(Exception e) {}
				}
			}
		};
			
		thread.start();
			
		for(int i=0; i<5; i++) {
			System.out.println("소리");
			try { Thread.sleep(500); } catch(Exception e) {}
		}
	}
}
