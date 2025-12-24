package ch07_상속.ex02_부모생성자호출;

class Phone {
	//필드
	String model;
	String color;
	//기본 생성자
	Phone(){
		System.out.println("Phone 생성자가 실행됨");
	}
	Phone(String model, String color) {
		super();
		this.model = model;
		this.color = color;
	}
	
}
