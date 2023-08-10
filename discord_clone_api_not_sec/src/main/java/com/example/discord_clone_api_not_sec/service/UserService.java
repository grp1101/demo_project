package com.example.discord_clone_api_not_sec.service;

import com.example.discord_clone_api_not_sec.repository.UserMapper;
import com.example.discord_clone_api_not_sec.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /*회원가입 저장*/
    public int signup(UserVo userVo) { // 회원 가입
        return userMapper.insertUser(userVo);
    };

}
