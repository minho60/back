package ch14_컬렉션.ex10_검색기능강화;

/**
 * java.lang.Comparable<T> 인터페이스
 * 	- TreeSet과 TreeMap에 저장되는 키 객체는 저장과 동시에 오름차순으로 정렬되는데,
 * 	  어떤 객체든 정렬될 수 있는 것은 아니고, 객체가 Comparable 인터페이스를 구현하고 있어야 가능하다.
 *  -> Integer, Double, String 타입은 모두 Comparable을 구현하고 있다.
 *  
 *  	int compareTo(T o): 주어진 객체와 같으면 0, 적으면 음수, 크면 양수를 리턴
 * 
 * 사용자 정의 객체의 정렬
 *  - Comparable 인터페이스의 compareTo() 메서드 재정의를 통해 비교 결과를 정수 값으로 리턴한다.
 *   
 */
// 나이를 기준으로 Person 객체를 오름차순으로 정렬하기 위해 Comparable 인터페이스를 구현한다.
public class Person implements Comparable<Person> {
	public String name;
	public int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		if(age<o.age) return -1;
		else if(age == o.age) return 0;
		else return 1;
	}
}