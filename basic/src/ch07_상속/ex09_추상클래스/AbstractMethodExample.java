package ch07_상속.ex09_추상클래스;

public class AbstractMethodExample {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.sound();

		Cat cat = new Cat();
		cat.sound();

		//매개변수의 다형성
		animalSound(new Dog());
		animalSound(new Cat());
	}

	public static void animalSound( Animal animal ) {
		animal.sound();
	}
}