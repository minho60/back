package ch17_IO.ex08_객체스트림;

import java.io.Serializable;
/**
 * Serializable 인터페이스
 *  - Serializable 인터페이스를 구현한 클래스만 직렬화할 수 있도록 제한한다.
 *  - Serializable 인터페이스는 멤버가 없는 빈 인터페이스이지만,
 *    객체를 직렬화할 수 있다고 표시하는 역할을 한다.
 *  - 객체가 직렬화될 때 인스턴스 필드값은 직렬화 대상이지만 
 *    정적 필드와 transient로 선언된 필드는 직렬화에서 제외되므로 출력되지 않는다. 
 *    
 * serialVersionUID 필드
 *  - 직렬화할 때 사용된 클래스와 역직렬화할 때 사용된 클래스는 기본적으로 동일한 클래스여야 한다.
 *  - 클래스의 이름이 같더라도 클래스의 내용이 다르면 역직렬화에 실패한다.
 *  	
 *  	// Member 클래스로 생성한 객체를 직렬화하면
 *      // 추가된 field3이 있어 아래 Member 클래스로 역직렬화할 수 없다.
 *  	public class Member implements Serializable {
 *  		int field1;
 *  		int field2;
 *  	}
 *  
 *  	public class Member implements Serializable {
 *  		int field1;
 *  		int field2;
 *  		int field3;
 *  	}
 *  
 *  
 *  - 그러나, 두 클래스가 동일한 serialVersionUID 상수값을 가지고 있으면 가능하다.
 *  
 *  	public class Member implements Serializable {
 *  		static final long serialVersionUID = 1;
 *  		int field1;
 *  		int field2;
 *  	}
 *  
 *  	public class Member implements Serializable {
 *  		static final long serialVersionUID = 1;
 *  		int field1;
 *  		int field2;
 *  		int field3;
 *  	}
 * 
 */
public class Product implements Serializable {
	private static final long serialVersionUID = -621812868470078544L;
	private String name;
	private int price;

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() { return name + ": " + price; }
}