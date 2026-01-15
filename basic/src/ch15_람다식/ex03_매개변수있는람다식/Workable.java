package ch15_람다식.ex03_매개변수있는람다식;

@FunctionalInterface
public interface Workable {
	void work(String name, String job);
}