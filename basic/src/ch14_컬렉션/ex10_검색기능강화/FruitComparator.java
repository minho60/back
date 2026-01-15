package ch14_컬렉션.ex10_검색기능강화;

import java.util.Comparator;
/**
 * java.util.Comparator 인터페이스
 *  - 비교 기능이 없는 Comparable 비구현 객체 저장
 * 
 *  	TreeSet<E> treeSet = new TreeSet<E>( new ComparatorImpl() );
 *  	TreeMap<K,V> treeMap = new TreeMap<K,V>( new ComparatorImpl() );
 *  
 *  	int compare(T o1, T o2)
 *  		: o1과 o2가 동등하다면 0, o1이 o2보다 앞에 오게 하려면 음수, 뒤에 오게 하려면 양수 리턴
 *  
 */
// Comparable을 구현하고 있지 않은 Fruit 객체를 TreeSet에 저장
// TreeSet을 생성할 때 비교자가 필요
// -> FruitComparator를 비교자로 사용해서 가격 기준으로 Fruit 객체 정렬
public class FruitComparator implements Comparator<Fruit> {
	@Override
	public int compare(Fruit o1, Fruit o2) {
		if(o1.price < o2.price) return -1;
		else if(o1.price == o2.price) return 0;
		else return 1;
	}
}