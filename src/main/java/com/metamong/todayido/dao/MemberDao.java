package com.metamong.todayido.dao;

import com.aidata.springboard02.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    //idcheck용 메소드
    int selectId(String mid);
    //회원 정보 저장(가입, insert) 메소드
    void insertMember(MemberDto member);
    //로그인 pw 가져오는 메소드
    String selectPassword(String mid);
    //로그인 성공 시 회원 정보를 가져오는 메소드
    MemberDto selectMember(String mid);
    //회원 point 수정 메소드
    void updateMemberPoint(MemberDto member);
}
