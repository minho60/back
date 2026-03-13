package kr.co.dodram.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 비밀번호 암호화 빈(Bean) 설정을 위한 독립 설정 클래스
 * * [분리 이유]
 * SecurityConfig에서 MemberService를 참조하고, MemberService가 다시 SecurityConfig의 
 * PasswordEncoder를 참조할 때 발생하는 '순환 참조' 에러를 방지하기 위해 
 * 암호화 도구만 별도로 떼어내어 관리합니다.
 */
@Configuration // 이 클래스가 스프링의 설정(Configuration) 정보를 담고 있음을 선언합니다.
public class PasswordEncoderConfig {
    
    /**
     * 비밀번호를 안전하게 해싱(Hashing)해주는 BCryptPasswordEncoder를 빈으로 등록합니다.
     * * @Bean: 스프링 컨테이너가 이 메서드에서 반환하는 객체를 관리하며, 
     * 어디서든 @Autowired나 생성자 주입으로 가져다 쓸 수 있게 합니다.
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // BCrypt는 비밀번호 암호화에 널리 사용되는 강력한 해시 함수입니다.
        // 매번 암호화할 때마다 내부적으로 랜덤한 '솔트(Salt)'를 사용하여 보안성을 높입니다.
        return new BCryptPasswordEncoder();
    }
}