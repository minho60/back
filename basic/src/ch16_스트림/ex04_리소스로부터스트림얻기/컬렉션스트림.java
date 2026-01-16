package ch16_스트림.ex04_리소스로부터스트림얻기;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
/**
 * 리소스로부터 스트림 얻기
 *  - java.util.stream 패키지에는 스트림 인터페이스들이 있다.
 *  - BaseStream 인터페이스에는 모든 스크림에서 사용할 수 있는 공통 메서드들이 정의되어 있다.
 *  - Stream은 객체 요소를 처리하는 스트림이고,
 *    IntStream, LongStream, DoubleStream은 
 *    각각 기본 타입인 int, long, double 요소를 처리하는 스트림이다.
 * 
 * 컬렉션으로부터 스트림 얻기
 * 	- java.util.Collection 인터페이스는 스트림과 parallelStream() 메서드를 가지고 있기 때문에
 *    List와 Set 인터페이스를 구현한 모든 컬렉션에서 객체 스트림을 얻을 수 있다. 
 */
public class 컬렉션스트림 {
	public static void main(String[] args) {
		//List 컬렉션 생성
		List<Product> list = new ArrayList<>();
		for(int i=1; i<=5; i++) {
			Product product = new Product(i, "상품"+i, "멋진회사", (int)(10000*Math.random()));
			list.add(product);
		}
		
		//객체 스트림 얻기
		Stream<Product> stream = list.stream();
		stream.forEach(p -> System.out.println(p));
	}
}