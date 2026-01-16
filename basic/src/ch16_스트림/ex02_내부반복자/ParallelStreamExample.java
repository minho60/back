package ch16_스트림.ex02_내부반복자;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
/**
 * Stream은 Iterator와 비슷한 반복자이지만 다음과 같은 차이점이 있다.
 * 	1. 내부 반복자이므로 처리 속도가 빠르고, 병렬 처리에 효율적이다.
 *  2. 람다식으로 다양한 요소 처리를 정의할 수 있다.
 *  3. 중간 처리와 최종 처리를 수행하도록 파이프 라인을 형성할 수 있다.
 *
 * 외부 반복자
 *  - for문과 Iterator는 컬렉션의 요소를 컬렉션 바깥쪽으로 반복해서 가져와 처리
 *  - 컬렉션의 요소를 외부로 가져오는 코드와 처리하는 코드를 모두 개발자 코드가 가지고 있어야 한다.
 *
 * 내부 반복자
 * 	- 스트림은 요소 처리 방법을 컬렉션 내부로 주입시켜서 요소를 반복 처리한다.
 *  - 개발자 코드에서 제공한 데이터 처리 코드(람다식)를 가지고 컬렉션 내부에서 요소를 반복 처리한다.
 *  - 멀티 코어 CPU를 최대한 활용하기 위해 요소들을 분배시켜 병렬 작업을 할 수 있다.
 *  - 하나씩 처리하는 순차적 외부 반복자보다 효율적으로 요소를 반복시킬 수 있다.
 *
 */
// List 컬렉션의 내부 반복자를 이용해서 병렬 처리하는 방법을 보여준다.
// parallelStream() 메서드로 병렬 처리 스트림을 얻고,
// forEach() 메서드를 호출할 때 요소 처리 방법인 람다식을 제공한다.
// 람다식은 처리되는 요소가 무엇이고, 어떤 스레드가 처리하는지를 출력한다.
public class ParallelStreamExample {
	public static void main(String[] args) {
		//List 컬렉션 생성
		List<String> list = new ArrayList< >();
		list.add("홍길동");
		list.add("신용권");
		list.add("감자바");
		list.add("람다식");
		list.add("박병렬");

		//병렬 처리
		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach( name -> {
			System.out.println(name + ": " + Thread.currentThread().getName());
		} );
	}
}