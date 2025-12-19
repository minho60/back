package ch06_클래스.ex03_필드초기화;

public class KoreanMain {

	public static void main(String[] args) {
		// 객체생성
		// 클래스 참조변수 = new 생성자([인자,...]);
		Korean k1 = new Korean("망나뇽","010721-1234567"); 
		Korean k2 = new Korean("헤카톤","990516-2734521"); 
		
		System.out.println("k1.nation:"+k1.nation);
		System.out.println("k1.name:"+k1.name);
		System.out.println("k1.ssn:"+k1.ssn);
		System.out.println();
		System.out.println("k2.nation:"+k2.nation);
		// final 필드가 아닌 경우 재할당 가능
		k2.name = "꼬부기";
		System.out.println("k2.name:"+k2.name);
		
		// final 필드는 재할당 불가!
		System.out.println("k2.ssn:"+k2.ssn);

	}

}
