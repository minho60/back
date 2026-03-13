package kr.co.dodram.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType; // ★ 필수 임포트
import kr.co.dodram.security.service.MemberService;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final MemberService memberService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // ★ [핵심] JSP 화면을 못 찾아서 에러가 나더라도 무한 루프를 돌지 않게 내부 이동을 허용!
                .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
                // 기존 허용 경로들
                .requestMatchers("/member/login", "/member/join", "/member/process", "/assets/**" , "/css/**", "/js/**", "/").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/member/login")
                .loginProcessingUrl("/member/login") 
                .defaultSuccessUrl("/", true)
             // ★ 로그인 성공 시 실행될 로직 추가
                .successHandler((request, response, authentication) -> {
                    // 1. 로그인한 사용자의 아이디 가져오기
                    String userId = authentication.getName();
                    
                    // 2. 서비스를 통해 DB에서 이름 가져오기 (이미 Service에 getNameById가 있다고 가정)
                    // 만약 없다면 memberDAO를 직접 사용하거나 Service에 메서드를 만드세요.
                    String userName = memberService.getNameById(userId); 
                    
                    // 3. 세션에 이름 저장
                    request.getSession().setAttribute("userName", userName);
                    
                    // 4. 메인 페이지로 이동
                    response.sendRedirect("/");
                })
                
                .failureUrl("/member/login?error") // ★ 주소 뒤에 ?error가 붙어야 위 JSP 코드가 작동함
                .permitAll()
            );

        return http.build();
    }
}