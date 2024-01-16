package com.example.vue_chat_server.service;

import com.example.vue_chat_server.repository.UserMapper;
import com.example.vue_chat_server.vo.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    /**
     * detailService 커스텀
     * @param email
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        CustomUserDetails user = userMapper.getUserByEmail(email);
        if(email==null) {
            throw new UsernameNotFoundException(email);
        }

        System.out.println("UserDetailsService의 loadUserByUsername 실행");
        return user;
    }
}
