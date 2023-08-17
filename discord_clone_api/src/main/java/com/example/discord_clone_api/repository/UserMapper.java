package com.example.discord_clone_api.repository;

import com.example.discord_clone_api.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("UserMapper")
public class UserMapper {

    @Autowired
    SqlSession session;

    /*회원가입 저장*/
    public int insertUser(UserVo userVo) // 회원 가입
    {
        return session.insert("UserMapper.insertUser" , userVo);
    }

    /*회원정보 가져오기*/
    public UserVo getUserByEmail(String email){// 회원 정보 가져오기
        return session.selectOne("UserMapper.getUserByEmail" , email);
    }

}
