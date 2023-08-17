package com.example.discord_clone_api.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 권한에 따라 허용하는 url 설정
        // /login, /signup 페이지는 모두 허용, 다른 페이지는 인증된 사용자만 허용
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();

        // login 설정
//        http
//                .formLogin()
//                .loginPage("/login")    // GET 요청 (login form을 보여줌)
//                .loginProcessingUrl("/auth")    // POST 요청 (login 창에 입력한 데이터를 처리)
//                .usernameParameter("email")	// login에 필요한 id 값을 email로 설정 (default는 username)
//                .passwordParameter("password")	// login에 필요한 password 값을 password(default)로 설정
//                .defaultSuccessUrl("/");	// login에 성공하면 /로 redirect
//
//        // logout 설정
//        http
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/");	// logout에 성공하면 /로 redirect

        return http.build();
    }





}
