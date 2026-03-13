package kr.co.dodram.security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	private String num;
	private String userid;
	private String subject;
	private String content;
	private String regdate;
	private String readcount;
}