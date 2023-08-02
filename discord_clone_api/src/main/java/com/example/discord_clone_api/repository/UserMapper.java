package com.example.discord_clone_api.repository;

import com.example.discord_clone_api.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {

    /*회원가입 저장*/
    void insertUser(UserVo userVo); // 회원 가입

    /*회원정보 가져오기*/
    UserVo getUserByEmail(String email); // 회원 정보 가져오기

}
