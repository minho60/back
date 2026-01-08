package ch11_base모듈.sec01_Object.ex04_record;

import java.util.Objects;

import lombok.NonNull;
import lombok.Value;

/**
 * record
 *	- Java 14+ 레코드 도입
 *	- 왜? 반복적으로 사용되는 코드를 줄이기 위해 
 *  - 어디에? DTO(Data Transfer Object, 데이터 전송 객체)
 *  - 변수의 타입과 필드이름을 이용하여
 *    private final 필드가 생성되고,
 *    필수 생성자, 게터가 추가, 
 *    hashCode(), equals(), toString() 재정의 하여 추가
 *  
 *  	[public] record 레코드명(타입 필드1, 타입 필드2, ...) {}
 *  
 */

//@NoArgsConstructor -> 기본 생성자
//@AllArgsConstructor -> 모든 필드 생성자
//@RequiredArgsConstructor -> 필수 필드(final, @NonNull) 생성자
//@ToString
//@EqualsAndHashCode 
//@Getter 
//@Setter
//@Data -> @RequiredArgsConstructor, @ToString, @EqualsAndHashCode, @Getter, @Setter
//@Value -> @RequiredArgsConstructor, @ToString, @EqualsAndHashCode, @Getter

// @Value는 모든 필드를 private final로 선언
@Value
public class Member {
	@NonNull String id;
	String name;
	int age;
	
//	// alt+shift+s,o
//	public Member(String id, String name, int age) {
//		this.id = id;
//		this.name = name;
//		this.age = age;
//	}
//
//	// alt+shift+s,r
//	public String id() {
//		return id;
//	}
//
//	public String name() {
//		return name;
//	}
//
//	public int age() {
//		return age;
//	}
//
//	// alt+shift+s,h
//	@Override
//	public int hashCode() {
//		return Objects.hash(age, id, name);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Member other = (Member) obj;
//		return age == other.age && Objects.equals(id, other.id) && Objects.equals(name, other.name);
//	}
//
//	// alt+shift+s,s
//	@Override
//	public String toString() {
//		return "Member [id=" + id + ", name=" + name + ", age=" + age + "]";
//	}
	
}

//public record Member(String id, String name, int age) {}