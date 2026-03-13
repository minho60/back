package kr.co.dodram.login.service;

import org.springframework.stereotype.Service;

import kr.co.dodram.login.dto.MemberDTO;
import kr.co.dodram.login.repository.MemberDAO;
import lombok.RequiredArgsConstructor;

/**
 * [Service 레이어]
 * 애플리케이션의 핵심 비즈니스 로직을 담당하는 클래스입니다.
 * 컨트롤러와 레포지토리(DAO) 사이에서 데이터 가공 및 트랜잭션 관리를 수행합니다.
 * @Service: 스프링이 비즈니스 로직 객체로 인식하여 빈(Bean)으로 등록합니다.
 */
@Service
@RequiredArgsConstructor // final이 붙은 MemberDAO에 대한 생성자 주입을 자동으로 생성합니다.
public class MemberService {

    private final MemberDAO memberDAO;

    /**
     * [회원가입 비즈니스 로직]
     * 사용자로부터 입력받은 데이터를 DB 형식에 맞게 가공한 후 저장 요청을 보냅니다.
     * @param dto 컨트롤러에서 넘어온 회원 정보 객체 (hobby 필드는 String[] 형태)
     * @return DB 저장 성공 여부 (true/false)
     */
    public boolean registerMember(MemberDTO dto) {
        // 1. 취미 비트 문자열(Bit String) 변환 로직
        // DB 테이블의 컬럼 수를 줄이기 위해 여러 개의 체크박스 값을 5자리의 문자열(예: "10100")로 압축합니다.
        char[] hb = {'0', '0', '0', '0', '0'}; // 기본값: 모두 선택 안 함 ('0')
        String[] lists = {"인터넷", "여행", "게임", "영화", "운동"}; // 체크박스 순서 정의
        
        // 사용자가 선택한 취미가 있는 경우에만 처리 (Null 방지)
        if (dto.getHobby() != null) {
            for (String h : dto.getHobby()) { // 사용자가 선택한 값들을 순회
                for (int j = 0; j < lists.length; j++) { // 정의된 전체 리스트와 비교
                    if (h.equals(lists[j])) {
                        hb[j] = '1'; // 일치하는 위치의 인덱스를 '1'로 변경
                    }
                }
            }
        }
        
        // 가공된 char 배열을 "10100" 같은 문자열로 변환
        String encodedHobby = new String(hb);

        // 2. 가공된 데이터와 함께 DAO의 insert 메서드 호출
        return memberDAO.insertMember(dto, encodedHobby);
    }

    /**
     * [로그인 비즈니스 로직]
     * 아이디와 비밀번호를 검증하여 인증 결과를 반환합니다.
     * @param id 사용자 입력 ID
     * @param pwd 사용자 입력 비밀번호
     * @return 인증 성공 시 사용자의 이름(String), 실패 시 null 반환
     */
    public String login(String id, String pwd) {
        // 1. DAO를 통해 해당 ID에 저장된 실제 비밀번호를 가져옵니다.
        String dbPwd = memberDAO.getPasswordById(id);
        
        // 2. 비밀번호 대조 (보안을 위해 null 체크 필수)
        // dbPwd가 null이면 아이디가 존재하지 않는 것이고, 
        // equals(pwd)가 false면 비밀번호가 틀린 것입니다.
        if (dbPwd != null && dbPwd.equals(pwd)) {
            // 3. 인증 성공 시 세션에 저장할 사용자의 이름을 추가로 조회하여 반환합니다.
            return memberDAO.getNameById(id); 
        }
        
        // 인증 실패 시 null을 반환하여 컨트롤러에서 'msg'를 띄우도록 유도합니다.
        return null; 
    }
}