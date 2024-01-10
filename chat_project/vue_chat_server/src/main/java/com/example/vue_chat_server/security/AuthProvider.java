package com.example.vue_chat_server.security;

import com.example.discord_clone_api.service.UserService;
import com.example.discord_clone_api.vo.CustomUserDetails;
import com.example.discord_clone_api.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //지금 springSecurityFilterChain 필터에서 가지고 있는 인증 리스트들 중에 UsernamePasswordAuthenticationFilter 인증으로 인증받아서 넘어가는 것 같음
        //참고 사이트 : https://jeong-pro.tistory.com/205

        //*입력한 아이디(이메일), 비밀번호 가져오기
        String email = (String) authentication.getPrincipal(); // 로그인 창에 입력한 email
        String password = (String) authentication.getCredentials(); // 로그인 창에 입력한 password

        PasswordEncoder passwordEncoder = userService.passwordEncoder();

        //*UserDetailsService , UserDe tails을 구현한 커스텀 클래스 (유저의 개인 정보를 DB에서 가져오기)
//        UserDetails userVo = (UserDetails) userService.getUserByEmail(email);
        CustomUserDetails userVo = (CustomUserDetails)userDetailsService.loadUserByUsername(email);

        //*인증 객체를 담은 토큰 생성. UsernamePasswordAuthenticationToken은 Authentication 인터페이스의 구현체라고 함...
        UsernamePasswordAuthenticationToken token;


        if (userVo != null && passwordEncoder.matches(password, userVo.getPassword())) {
            // 일치하는 user 정보가 있는지 확인
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("USER")); // 권한 부여

            //인증된 user 정보를 담아 SecurityContextHolder에 저장되는 token . User의 ID가 Principal 역할을 하고, Password가 Credential
//            UsernamePasswordAuthenticationToken token = UsernamePasswordAuthenticationToken.authenticated(userVo.getID(),null,roles);
            token = new UsernamePasswordAuthenticationToken(email , password , roles);

             return token;
        }
        // Exception을 던지지 않고 다른 값을 반환하면 authenticate() 메서드는 정상적으로 실행된 것이므로 인증되지 않았다면 Exception을 throw 해야 한다.
        throw new BadCredentialsException("비밀번호 맞지않음");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        //필터에서 보내준 Authentication 객체가 맞는지 확인하는 메서드
        boolean result = authentication.equals(UsernamePasswordAuthenticationToken.class);
        return result;
    }

}
