package ch12.sec03.exam05;


import lombok.Value;

/**
 * @NoAgrsConstructor -> 기본생성자
 * @AllArgsConstructor -> 모든 필드가 포함된 생성자 생성
 * @RequiredArgsConstructor -> final 또는 @NonNull 필드만 포함하는 생성자 생성
 * @EqualsAndHashCode -> equals() / hashCode() 자동 생성
 * @ToString -> toString() 메서드 자동 생성
 * @Setter -> 모든 필드에 대한 setter 메서드 생성
 * @Getter -> 모든 필드에 대한 getter 메서드 생성
 * @Builder -> 빌더 패턴 자동 생성
 * @Data -> @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor 를 한 번에 적용
 * @Value -> 불변 객체(모든 필드 private final, getter만) 생성
 * @NonNull -> null 방지 (널 체크 자동 추가)
 */

@Value
public class Member {
	private final String id;
	private String name;
	private int age;
}