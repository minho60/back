package ch11_base모듈.sec01_Object.ex02_hashCode메서드;
/**
 * 객체 해시코드
 *  - 객체를 식별하는 정수
 *  - Object의 hashCode() 메서드는 객체의 메모리 번지를 이용하여 해시코드를 생성하기 때문에
 *    객체마다 다른 정수값을 리턴한다.
 *  - hashCode() 메서드는 두 객체가 동등한지 비교할 때 주로 사용한다.
 *  - hashcode() 메서드는 객체의 데이터를 기준으로 재정의해서 새로운 정수값을 리턴하도록 한다.
 *  -> 객체가 다르다 할지라도 내부 데이터가 동일하다면 같은 정수값을 리턴하기 위해서이다.
 *  
 *   		public int hashCode()
 *   
 *   
 */
public class Student {
	private int no;
	private String name;

	public Student(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public int getNo() { return no; }
	public String getName() { return name; }

	// Object의 hashCode() 메서드를 재정의해서 
	// 학생 번호와 이름 해시코드를 합한 새로운 해시코드를 리턴하도록 함
	// 번호와 이름이 같으면 동일한 해시코드가 생성됨
	// hashCode()를 재정하지 않으면 객체 번지로 해시코드를 생성하므로
	// 객체가 다를 경우 해시코드도 달라진다.
	
	@Override
	public int hashCode() {
		int hashCode = no + name.hashCode();
		return hashCode;
	}
	
	// Object의 equals() 메서드를 재정의해서
	// Student 객체인지를 확인하고,
	// 학생 번호와 이름이 같으면 true를 리턴하도록 함
	/*
	 * obj 변수에 할당된 객체가 student클래스의 인스턴스(객체)인지 비교
	 * -> 타입비교 + 강제 타입변환
	 * if (obj instanceof Student) { 
	 * 		Student target = (Student) obj; 
	 * }
	 */	

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student target) {
			if(no == target.getNo() && name.equals(target.getName())) {
				return true;
			}
		}
		return false;
	}
}