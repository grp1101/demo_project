package com.example.vue_chat_server.repository;

import com.example.vue_chat_server.vo.CustomUserDetails;
import com.example.vue_chat_server.vo.UserVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserMapper")
public class UserMapper {

    @Autowired
    SqlSession session;

    /*개인정보 가져오기*/
    public CustomUserDetails getUserByEmail(String email){
        return session.selectOne("UserMapper.getUserByEmail" , email);
    }

    /*User 테이블 가져오기*/
    public List<UserVo> getUserList(){
        return session.selectList("UserMapper.getUserList");
    }

    /*토큰에 저장된 객체 인증값으로 유저 정보 가져오기*/
    public UserVo getUserByEmailInUservo(String email){
        return session.selectOne("UserMapper.getUserByEmailInUservo" , email);
    }

    /*토큰에 저장된 객체 인증값으로 유저 정보 가져오기*/
    public int UpdateUser(UserVo user){
        return session.update("UserMapper.UpdateUser" , user);
    }
}
