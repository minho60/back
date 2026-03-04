package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardBean {
	private int num;
	private String userid;
	private String subject;
	private String content;
	private String regdate;
	private int readcount;
	// 비밀번호, 업로드 파일명, 파일 크기 추가
	private String pass;
	private String filename;
	private int filesize;
}