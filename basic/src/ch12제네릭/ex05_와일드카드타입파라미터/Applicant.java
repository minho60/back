package ch12제네릭.ex05_와일드카드타입파라미터;

public class Applicant<T> {
	public T kind;

	public Applicant(T kind) {
		this.kind = kind;
	}
}