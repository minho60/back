package ch02_데이터와변수;

// 외부 패키지. 클래스를 가져올 때 (자동임포트)
// java.lang 패키지 외의 모든 외부 패키지는 임포트하여 사용한다.
import java.util.Scanner;

public class Ex14_표준입력 {

	public static void main(String[] args) {
		
		// 참조타입 변수 = new  생성자(인자);
		// Scanner 변수 = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.print("x 값 입력: ");
		// 콘솔에서 입력한 정보를 strX에 할당
		// nextLine()은 키보드로 입력한 내용을 '한 줄 전체' 그대로 읽어 문자열로 반환
		// nextLine()으로 입력한 데이터는 문자열이다.
		String strX = sc.nextLine();
		// strX를 정수로 전환
		int x =Integer.parseInt(strX);
		System.out.println(x);
	
		System.out.print("y 값 입력: ");
		String strY = sc.nextLine();
		int y =Integer.parseInt(strY);
		System.out.println(y);
		System.out.println();
		
		int result =x +y;
		System.out.println("x+y="+result);
		
		while(true) {
			System.out.println("입력문자열:");
			String data = sc.nextLine();
			if(data.equals("q")) {
				break;
			}
			System.out.println("출력 문자열:"+data);
			System.out.println("출력 주소:"+System.identityHashCode(data));
			System.out.println();
		}
		System.out.println("while문을 종료 합니다.");
		
		sc.close();
	}

}
