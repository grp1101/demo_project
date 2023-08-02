package com.example.discord_clone_api.service;

import com.example.discord_clone_api.repository.UserMapper;
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
    public void signup(UserVo userVo) { // 회원 가입
        if (!userVo.getUsername().equals("") && !userVo.getEmail().equals("")) {
            // password는 암호화해서 DB에 저장
            userVo.setPassword(passwordEncoder.encode(userVo.getPassword()));
            userMapper.insertUser(userVo);
        }
    };

    /*비밀번호 암호화?....*/
    public PasswordEncoder passwordEncoder() {
        return this.passwordEncoder;
    };

    /*회원정보 가져오기*/
    public UserVo getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }


}
