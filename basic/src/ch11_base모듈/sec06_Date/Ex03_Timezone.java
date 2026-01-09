package ch11_base모듈.sec06_Date;

import java.util.TimeZone;
/**
 * java.util.TimeZone
 * 
 * getAvailableIDs()
 * 	- JVM이 인식하고 있는 모든 시간대(Time Zone) ID 목록을 문자열 배열로 반환하는 정적 메서드
 */
public class Ex03_Timezone {
	public static void main(String[] args) {
		//System.out.println(TimeZone.getAvailableIDs());
		String[] availableIDs = TimeZone.getAvailableIDs();
		for(String id : availableIDs) {
			System.out.println(id);
		}
	}
}