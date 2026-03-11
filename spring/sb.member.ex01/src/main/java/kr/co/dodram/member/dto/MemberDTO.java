package kr.co.dodram.member.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
	 	private String id;
	    private String pwd;
	    private String name;
	    private String gender;
	    private String email;
	    private String phone;
	    private String zipcode;
	    private String address1;
	    private String address2;
	    private String[] hobby; // 다중 선택 대응
	    private String job;
}
