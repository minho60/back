package ch14_컬렉션.ex12_동기화;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * 동기화된 컬렉션
 * 	- Vector, Hashtable은 동기화된(synchornized) 메서드로 구성
 *  -> 멀티 스레드 환경에서도 안전하게 요소 처리
 *  
 *  - ArrayList, HashSet, HashMap을 멀티 스레드 환경에서 사용하려면?
 * 		-> Collections의 synchronizedXXX() 메서드 사용!
 * 
 * 	1. List<T> synchronizedList(List<T> list): List를 동기화된 List로 리턴
 * 	2. Map<K,V> synchronizedMap(Map<K,V> m): Map을 동기화된 Map으로 리턴
 * 	3. Set<T> synchronizedSet(Set<T> s): Set을 동기화된 Set으로 리턴
 * 
 */
// ThreadA와 ThreadB에서 동시에 Board 객체를 HashMap에 각각 1000개씩 추가한 후, 전체 저장된 수 출력
public class SynchronizedMapExample {
	public static void main(String[] args) {
		//Map 컬렉션 생성
		Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());
			
		//작업 스레드 객체 생성
		Thread threadA = new Thread() {
			@Override
			public void run() {
				//객체 1000개 추가
				for(int i=1; i<=1000; i++) {
					map.put(i, "내용"+i);
				}
			}
		};
			
		//작업 스레드 객체 생성
		Thread threadB = new Thread() {
			@Override
			public void run() {
				//객체 1000개 추가
				for(int i=1001; i<=2000; i++) {
					map.put(i, "내용"+i);
				}
			}
		};
		
		//작업 스레드 실행
		threadA.start();
		threadB.start();
		
		//작업 스레드들이 모두 종료될 때까지 메인 스레드를 기다리게 함
		try {
			threadA.join();
			threadB.join();
		} catch(Exception e) {
		}
			
		//저장된 총 객체 수 얻기
		int size = map.size();
		System.out.println("총 객체 수: " + size);
		System.out.println();
	}
}