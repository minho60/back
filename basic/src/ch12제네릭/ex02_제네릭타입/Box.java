package ch12제네릭.ex02_제네릭타입;

public class Box<T> {
	public T content;

	//Box의 내용물이 같은지 비교
	public boolean compare(Box<T> other) {
		// Object의 equals() 메서드로 content 필드 값 비교
		boolean result = content.equals(other.content);
		return result;
	}
}