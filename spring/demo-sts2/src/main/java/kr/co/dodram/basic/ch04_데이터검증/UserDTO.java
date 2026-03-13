package kr.co.dodram.basic.ch04_데이터검증;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    @NotBlank(message = "이름은 필수 입력 항목입니다.") // 공백 불허
    @Size(min = 2, max = 10, message = "이름은 2자 이상, 10자 이하로 입력해주세요.")
    private String name;

    @Min(value = 0, message = "나이는 0세 이상이어야 합니다.")
    private int age;

    // Getter, Setter, 기본 생성자 생략 (반드시 있어야 함)
}