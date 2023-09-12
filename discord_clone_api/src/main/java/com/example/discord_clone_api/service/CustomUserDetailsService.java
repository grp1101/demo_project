package com.example.discord_clone_api.service;

import com.example.discord_clone_api.repository.UserMapper;
import com.example.discord_clone_api.vo.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    /**/
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        CustomUserDetails user = userMapper.getUserByEmail(email);
        if(email==null) {
            throw new UsernameNotFoundException(email);
        }

        System.out.println("CustomUserDetailsService 들어왔다!!!!!!!!!!!!!!!!");
        return user;
    }
}
