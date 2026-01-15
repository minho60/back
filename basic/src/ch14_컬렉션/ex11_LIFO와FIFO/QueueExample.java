package ch14_컬렉션.ex11_LIFO와FIFO;

import java.util.LinkedList;
import java.util.Queue;
/**
 * java.util.Queue 인터페이스
 *  - Queue 인터페이스는 FIFO 자료구조에서 사용되는 메서드를 정의하고 있다.
 * 	- 선입선출(FIFO: First In First Out): 먼저 넣은 객체가 먼저 빠져나가는 구조
 *  - 예) 스레드풀(ExecutorService)의 작업 큐
 *  
 * 	객체 생성
 * 		Queue<E> queue = new LinkedList<E>();
 * 		Queue<E> queue = new LinkedList<>();
 *  
 *  1. boolean offer(E e): 주어진 객체를 큐에 넣는다.
 *  2. E poll(): 큐에서 객체를 빼낸다.
 *  
 */
// Queue를 이용해서 간단한 메시지 큐를 구현
// 먼저 넣은 메시지가 반대쪽으로 먼저 나오기 때문에 넣은 순서대로 메시지가 처리된다.
public class QueueExample {
	public static void main(String[] args) {
		//Queue 컬렉션 생성
		Queue<Message> messageQueue = new LinkedList<>();
		
		//메시지 넣기
		messageQueue.offer(new Message("sendMail", "홍길동"));
		messageQueue.offer(new Message("sendSMS", "신용권"));
		messageQueue.offer(new Message("sendKakaotalk", "감자바"));
		
		//메시지를 하나씩 꺼내어 처리
		while(!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			switch(message.command) {
				case "sendMail":
					System.out.println(message.to + "님에게 메일을 보냅니다.");
					break;
				case "sendSMS":
					System.out.println(message.to + "님에게 SMS를 보냅니다.");
					break;
				case "sendKakaotalk": 
					System.out.println(message.to + "님에게 카카오톡를 보냅니다.");
					break;
			}
		}
	}
}