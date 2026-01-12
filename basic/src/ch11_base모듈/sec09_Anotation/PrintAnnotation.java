package ch11_base모듈.sec09_Anotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @Override: 메서드 재정의 -> 기본
 * @Getter: 게터 -> 롬복 설치
 * 
 * 1. 애노테이션 타입 정의
 * 	 public @interface 애노테이션명 {
 * 		타입 이름() [default 값];
 *   }
 *
 * 2. 애노테이션 적용 대상
 * 	 @Target({ElementType.열거상수, ...})
 * 
 * 		열거상수				적용 요소
 * 		TYPE				클래스, 인터페이스, 열거타입
 * 		ANNOTATION_TYPE		애노테이션
 * 		FIELD				필드
 * 		CONSTRUCTOR			생성자
 * 		METHOD				메서드
 * 		LOCAL_VARIABLE		로컬 변수
 * 		PACKAGE				패키지
 * 
 * 3. 애노테이션 유지 정책
 * 	 @Retention(RetentionPolicy.열거상수)
 * 
 * 		열거상수		적용 시점			제거 시점
 * 		SOURCE		컴파일시			컴파일된 후 제거
 * 		CLASS		메모리로 로딩시		메모리로 로딩 후 제거
 * 		RUNTIME		실행시			계속 유지
 * 
 */

// 사용자 애노테이션: @PrintAnnotation
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PrintAnnotation {
	String value() default "-";
	int number() default 15;
}