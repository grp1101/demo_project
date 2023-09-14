package com.example.discord_clone_api.config.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequiredArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        log.info("로그인 시도: UsernamePasswordAuthenticationFilter.attemptAuthentication");
//        System.out.println("로그인 인증 단계");
//
//        //아이디, 비밀번호 가져오기
//        String username = obtainUsername(request);
////        username = (username != null) ? username : "";
////        username = username.trim();
//        String password = obtainPassword(request);
//
//        try {
//
//
//
//            Authentication authentication = authenticationManager.authenticate();
//        }
}
