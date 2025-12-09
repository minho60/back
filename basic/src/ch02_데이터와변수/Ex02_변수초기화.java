package ch02_데이터와변수;

public class Ex02_변수초기화 {

	public static void main(String[] args) {
		// 변수를 연산식에 사용하려면 값을 할당해야한다.
		
//		int value=12;
//		int result= value + 10;
//		System.out.println(result);
		
		int hour =3;
		int minute =5;
		// + 는 문자열 연결 연산
		System.out.println(hour+"시간"+minute+"분");

	
		int x=3;
		int y=5;
		System.out.println("x:"+x+",y:"+y);
		
		// 변수 값 교환
		int temp =x;
		x= y;
		y = temp;
		System.out.println("x:"+x+",y:"+y);
	}

}
