package ch15_람다식.ex07_생성자참조;

@FunctionalInterface
public interface Creatable2 {
	public Member create(String id, String name);
}