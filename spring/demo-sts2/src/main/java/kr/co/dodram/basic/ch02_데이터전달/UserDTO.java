package kr.co.dodram.basic.ch02_데이터전달;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDTO {
	private String name;
	private String email;
	private int age;	
}
