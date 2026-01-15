package ch14_컬렉션.ex11_LIFO와FIFO;

import java.util.Stack;
/**
 * java.util.Stack 클래스
 *  - Stack 클래스는 LIFO 자료구조를 구현한 클래스
 *  - 후입선출(LIFO: Last In First Out): 나중에 넣은 객체가 먼저 빠져나간다.
 *  - 예) JVM 스택 메모리
 *  
 *  	Stack<E> stack = new Stack<E>();
 *  	Stack<E> stack = new Stack<>();
 *  
 *  1. E push(E item): 주어진 객체를 스택에 넣는다.
 *  2. E pop(): 스택의 맨 위 객체를 뺀다.
 *  
 */
// 동전 케이스를 Stack 클래스로 구현
public class StackExample {
	public static void main(String[] args) {
		//Stack 컬렉션 생성
		Stack<Coin> coinBox = new Stack<Coin>();
		
		//동전 넣기
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));

		//동전을 하나씩 꺼내기
		while(!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println("꺼내온 동전 : " + coin.getValue() + "원");
		}
	}
}