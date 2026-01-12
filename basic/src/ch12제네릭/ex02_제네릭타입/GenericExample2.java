package ch12제네릭.ex02_제네릭타입;

public class GenericExample2 {
	public static void main(String[] args) {
		HomeAgency homeAgency = new HomeAgency();
		Home home = homeAgency.rent();
		home.turnOnLight();

		CarAgency carAgency = new CarAgency();
		Car2 car = carAgency.rent();
		car.run();
	}
}