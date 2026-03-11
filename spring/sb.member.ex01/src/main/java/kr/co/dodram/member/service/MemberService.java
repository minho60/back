package kr.co.dodram.member.service;

import org.springframework.stereotype.Service;

import kr.co.dodram.member.dto.MemberDTO;
import kr.co.dodram.member.repository.MemberDAO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberDAO memberDAO;

    public boolean registerMember(MemberDTO dto) {
        // [취미 처리 로직] 서비스 레이어로 이동
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

        // DAO 호출
        return memberDAO.insertMember(dto, encodedHobby);
    }
}