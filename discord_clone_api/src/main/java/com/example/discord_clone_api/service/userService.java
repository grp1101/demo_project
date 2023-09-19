package com.example.discord_clone_api.service;

import com.example.discord_clone_api.repository.UserMapper;
import com.example.discord_clone_api.vo.CustomUserDetails;
import com.example.discord_clone_api.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /*회원가입 저장*/
    public int signup(UserVo userVo) { // 회원 가입

        int insertCNT = 0;

        if (!userVo.getUsername().equals("") && !userVo.getEmail().equals("")) {
            // password 암호화
            userVo.setPassword(passwordEncoder.encode(userVo.getPassword()));

            insertCNT = userMapper.insertUser(userVo);
        }

        return insertCNT;
    }

    /*password 암호화*/
    public PasswordEncoder passwordEncoder() {
        return this.passwordEncoder;
    };

    /*개인정보 가져오기*/
    public CustomUserDetails getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    /*User 테이블 가져오기*/
    public List<UserVo> getUserList() {
        return userMapper.getUserList();
    }

    /*토큰에 저장된 객체 인증값으로 유저 정보 가져오기*/
    public UserVo getUserByEmailInUservo(String email) {
        return userMapper.getUserByEmailInUservo(email);
    }
}
