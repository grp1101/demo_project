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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

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
                .csrf().disable() // 회원가입 요청 시 CORS 에러
                .cors().configurationSource(corsConfigurationSource()); //로그인 요청 시 CORS 에러

        // login 설정
        http
                .formLogin() // form 로그인 인증 기능이 작동함
//                .loginPage("/login_page")    // GET 요청 (login form을 보여줌) //나는 이거 넣으면 get요청 : 500 오류남
                .loginProcessingUrl("/api/login")    // 사용자 이름과 암호를 제출할 URL . POST 요청 (login 창에 입력한 데이터를 처리). 예제는 form에서 넘기는 방식인데 vue의 date로 요청을 받을 수 있을지...
                .usernameParameter("email")	// login에 필요한 id 값을 email로 설정 (default는 username)
                .passwordParameter("password")	// login에 필요한 password 값을 password(default)로 설정
                .defaultSuccessUrl("http://localhost:8080/");	// login에 성공하면 /로 redirect


        // logout 설정
//        http
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/");	// logout에 성공하면 /로 redirect

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOriginPattern("*");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }





}
