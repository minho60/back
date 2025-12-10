package ch02_데이터와변수;

public class Ex05_char정수 {

	public static void main(String[] args) {
		// ctrl+alt+ 방향키: 복제
		
		// 문자는 단일 따옴표, 문자열은 이중 따옴표로 묶는다.
		char var1= 'A';
		char var2= '가';
		// 유니코드 직접 저장
		//10진수 65와 매칭되는 문자는'A'
		char var3= 65;
		//16 진수 0ㅌ0041과 매칭 되는 문자는 'A'
		char var4= 44032;
		char var6= 0x0041;
		String var5 = "가능한";
		
		// sysout 쏘고, ctrl+spacebar
		System.out.println("var1:"+var1);
		System.out.println("var2:"+var2);
		System.out.println("var3:"+var3);
		System.out.println("var4:"+var4);
		System.out.println("var5:"+var5);
		System.out.println("var6:"+var6);

	}

}
