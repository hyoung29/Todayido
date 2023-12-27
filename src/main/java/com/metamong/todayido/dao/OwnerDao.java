package com.metamong.todayido.dao;


import com.metamong.todayido.dto.OwnerDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OwnerDao {
    //idcheck용 메소드
    int selectId(String ownerid);
    //회원 정보 저장(가입, insert) 메소드
    void insertOwner(OwnerDto owner);
    //로그인 pw 가져오는 메소드
    String selectPassword(String ownerid);
    //로그인 성공 시 회원 정보를 가져오는 메소드
    OwnerDto selectOwner(String ownerid);
}
