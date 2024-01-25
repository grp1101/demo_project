package com.example.vue_chat_server.service;


import com.example.vue_chat_server.repository.UserMapper;
import com.example.vue_chat_server.vo.CustomUserDetails;
import com.example.vue_chat_server.vo.UserVo;
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

    /**
     * 패스워드 암호화
     * @return
     */
    public PasswordEncoder passwordEncoder() {
        return this.passwordEncoder;
    };

    /**
     * email의 회원정보 가져오기
     * @param email
     * @return
     */
    public CustomUserDetails getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    /**
     * user테이블 조회
     * @return
     */
    public List<UserVo> getUserList(UserVo user) {
        return userMapper.getUserList(user);
    }

    /**
     * 토큰에 저장된 객체 인증값으로 유저 정보 가져오기
     * @param email
     * @return
     */
    public UserVo getUserByEmailInUservo(String email) {
        return userMapper.getUserByEmailInUservo(email);
    }

    /**
     * user
     *
     * @param user
     * @return
     */
    public int UpdateUser(UserVo user) {
        return userMapper.UpdateUser(user);
    }
}
