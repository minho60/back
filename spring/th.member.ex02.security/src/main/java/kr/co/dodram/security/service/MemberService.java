package kr.co.dodram.security.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.dodram.security.dto.MemberDTO;
import kr.co.dodram.security.repository.MemberDAO;
import lombok.RequiredArgsConstructor;

/**
 * 회원 관련 비즈니스 로직을 처리하는 서비스 클래스
 * Spring Security의 UserDetailsService를 구현하여 커스텀 인증 로직을 제공합니다.
 */
@Service 
@RequiredArgsConstructor 
public class MemberService implements UserDetailsService { 

    private final MemberDAO memberDAO;
    // PasswordEncoderConfig에서 등록한 빈(Bean)을 주입받습니다.
    private final BCryptPasswordEncoder passwordEncoder;

    /**
     * [Spring Security 핵심 메서드]
     * 사용자가 로그인을 시도할 때(POST /member/login), 시큐리티가 내부적으로 아이디를 전달하며 호출합니다.
     * * @param username 로그인 폼에서 전달된 아이디
     * @return 시큐리티가 검증에 사용할 UserDetails 객체 (아이디, 비밀번호, 권한 포함)
     * @throws UsernameNotFoundException 아이디가 DB에 없을 경우 던지는 예외
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. DB에서 해당 아이디의 암호화된 비밀번호를 조회합니다.
        String dbPwd = memberDAO.getPasswordById(username);
        
        // 2. 일치하는 아이디가 없으면 예외를 발생시켜 인증 프로세스를 중단합니다.
        if (dbPwd == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
        }

        // 3. 시큐리티 표준 User 객체를 생성하여 반환합니다.
        // 이후 시큐리티가 입력받은 비번과 dbPwd를 내부적으로 matches() 하여 최종 승인합니다.
        return User.builder()
                .username(username)
                .password(dbPwd)   // 반드시 암호화된 형태여야 함
                .roles("USER")     // 기본 권한 부여 (ROLE_USER)
                .build();
    }

    /**
     * 회원가입 로직
     * 비밀번호 암호화 및 다중 선택 데이터(Hobby) 전처리를 수행합니다.
     */
    public boolean registerMember(MemberDTO dto) {
        // [1] 비밀번호 해싱: 평문 비번을 BCrypt 방식으로 암호화하여 보안을 강화합니다.
        String encodedPassword = passwordEncoder.encode(dto.getPwd());
        dto.setPwd(encodedPassword);

        // [2] 취미 데이터 비트 인코딩: 
        // 여러 개의 체크박스 값을 "10100" 형태의 문자열로 압축하여 DB 저장 효율을 높입니다.
        char[] hb = {'0', '0', '0', '0', '0'};
        String[] lists = {"인터넷", "여행", "게임", "영화", "운동"};
        
        if (dto.getHobby() != null) {
            for (String h : dto.getHobby()) {
                for (int j = 0; j < lists.length; j++) {
                    if (h.equals(lists[j])) hb[j] = '1';
                }
            }
        }
        String encodedHobby = new String(hb); 

        // [3] 최종적으로 가공된 정보를 DAO를 통해 DB에 저장합니다.
        return memberDAO.insertMember(dto, encodedHobby);
    }

    /**
     * 커스텀 로그인 메서드 (수동 인증 확인용)
     * 시큐리티 자동 로그인 외에 별도로 인증 여부를 확인하고 사용자 이름을 얻고 싶을 때 사용합니다.
     */
    public String login(String id, String pwd) {
        String dbPwd = memberDAO.getPasswordById(id);
        
        // passwordEncoder.matches(평문, 암호문)를 통해 두 비밀번호의 일치 여부를 판별합니다.
        if (dbPwd != null && passwordEncoder.matches(pwd, dbPwd)) {
            return memberDAO.getNameById(id); // 인증 성공 시 사용자 실명 반환
        }
        return null; // 실패 시 null
    }
    
    /**
     * 아이디를 기반으로 사용자 실명을 조회하는 메서드
     * SecurityConfig의 성공 핸들러(SuccessHandler)에서 세션에 이름을 담기 위해 사용됩니다.
     */
    public String getNameById(String id) {
        return memberDAO.getNameById(id);
    }
}