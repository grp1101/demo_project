package com.example.discord_clone_api.config.security;

import com.example.discord_clone_api.service.UserService;
import com.example.discord_clone_api.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //지금 springSecurityFilterChain 필터에서 가지고 있는 인증 리스트들 중에 UsernamePasswordAuthenticationFilter 인증으로 인증받아서 넘어가는 것 같음
        //참고 사이트 : https://jeong-pro.tistory.com/205

        String email = (String) authentication.getPrincipal(); // 로그인 창에 입력한 email
        String password = (String) authentication.getCredentials(); // 로그인 창에 입력한 password

        PasswordEncoder passwordEncoder = userService.passwordEncoder();
        //UsernamePasswordAuthenticationToken은 Authentication 인터페이스의 구현체라고 함...
        UsernamePasswordAuthenticationToken token;
        UserVo userVo = userService.getUserByEmail(email);

        if (userVo != null && passwordEncoder.matches(password, userVo.getPassword())) {
            // 일치하는 user 정보가 있는지 확인
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("USER")); // 권한 부여

            token = new UsernamePasswordAuthenticationToken(userVo, null, roles);
            // 인증된 user 정보를 담아 SecurityContextHolder에 저장되는 token

//            Authentication auth = SecurityContextHolder.getContext().getAuthentication(); //인증되서 SecurityContextSecurityContextHolder에 저장되어 있는 Authentication객체를 가져오는 방법
             return token; //밑에와 같이 ProviderManager클래스의 authenticate를 실행하지 않아도 토큰에 담긴 인증객체가 인증되서 SecurityContextHolder에 저장되는 느낌임...
//             return this.authenticate(token); //여기서 인증하고 인증이 성공하면 isAuthenticated(boolean)값을 TRUE로 바꿔준다?
        }

        throw new BadCredentialsException("No such user or wrong password.");
        // Exception을 던지지 않고 다른 값을 반환하면 authenticate() 메서드는 정상적으로 실행된 것이므로 인증되지 않았다면 Exception을 throw 해야 한다.
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

}
