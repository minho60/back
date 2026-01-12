package ch11_base모듈.sec07_Format;

import java.text.DecimalFormat;
/**
 * java.text.DecimalFormat
 * 	- 숫자를 형식화된 문자열로 변환
 * 
 * 패턴 문자
 *  1. 0 - 필수 숫자 자리(빈 자리는 0으로 채움)
 *  2. # - 선택적 숫자 자리(빈자리는 채우지 않음)
 *  3. , - 천 단위 구분자(3자리 마다 구분)
 *  
 *   	예) 	패턴 기호			숫자			결과
 *   		0				1234.89		1235
 *   		0.0				1234.89		1234.9
 *   		00000.00000		1234.89		01234.89000
 *   		#				1234.89		1235
 *   		#.#				1234.89		1234.9
 *   		#####.#####		1234.89		1234.89
 *   		#,###			1234.89		1,235
 *   		#,###.0			1234.89		1,234.9
 *
 */
public class Ex04_DecimalFormat {
	public static void main(String[] args) {
		double num = 1234567.89;

		DecimalFormat df;
		
		//정수 자리까지 표기
		df = new DecimalFormat("#,###");
		System.out.println( df.format(num) );
		
		//무조건 소수 첫째 자리까지 표기
		df = new DecimalFormat("#,###.0");
		System.out.println( df.format(num) );
	}
}