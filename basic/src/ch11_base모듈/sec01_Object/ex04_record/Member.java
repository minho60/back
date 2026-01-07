package ch11_base모듈.sec01_Object.ex04_record;

import java.util.Objects;

import lombok.Data;


/**
 * record
 *  - Java14+ 레코드 도입
 *  - 왜? 반복적으로 사용되는 코드를 줄이기 위해 
 *  - 어디에? DTO(Data Transfer Object, 데이터 전송 객체)
 *  - 변수의 타입과 필드 이름을 이용하여
 *    private final 필드가 자동 생성되고,
 *    필수 생성자, 게터가 추가,
 *    hashCode(), equals(), toString() 재정의 하여 추가
 *    
 *    	[public] record	
 */

@Data
public class Member{
	 String id;
     String name;
	 int age;
}
	 
//	
//	public Member(String id, String name, int age) {
//		this.id = id;
//		this.name = name;
//		this.age = age;
//	}
//
//	@Override
//	public String toString() {
//		return "Member [id=" + id + ", name=" + name + ", age=" + age + "]";
//	}
//
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
//	public String getId() {
//		return id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//}

//public record Member(String id, String name, int age) {
//}