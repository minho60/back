package ch11_base모듈.sec01_Object.ex05_loombok;

import lombok.Data;
import lombok.NonNull;

@Data
public class Member {
	private final String id;
	@NonNull private String name;
	private int age;
}