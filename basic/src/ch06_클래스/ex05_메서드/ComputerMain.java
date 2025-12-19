package ch06_클래스.ex05_메서드;

public class ComputerMain {

	public static void main(String[] args) {
		Computer myComputer = new Computer();
		
		int result = myComputer.sum(1,2,3);
		int result2 = myComputer.sum(1,2,3,4,5);
		System.out.println(result);
		System.out.println(result2);
		
		//배열을 직접 매개값으로 지정
		int[] values = {10, 20, 30};
		int result3 = myComputer.sum(values);
		System.out.println("result3:"+result3);// 60
		
//		int result4 = myComputer.sum({10,20,30});
//		System.out.println("result4:"result4);
		

	}

}
