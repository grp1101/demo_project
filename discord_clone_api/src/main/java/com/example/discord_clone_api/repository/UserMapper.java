package com.example.discord_clone_api.repository;

import com.example.discord_clone_api.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserMapper")
public class UserMapper {

    @Autowired
    SqlSession session;

    /*회원가입 저장*/
    public int insertUser(UserVo userVo) {
        return session.insert("UserMapper.insertUser" , userVo);
    }

    /*개인정보 가져오기*/
    public UserVo getUserByEmail(String email){
        return session.selectOne("UserMapper.getUserByEmail" , email);
    }

    /*User 테이블 가져오기*/
    public List<UserVo> getUserList(){
        return session.selectList("UserMapper.getUserList");
    }

}
