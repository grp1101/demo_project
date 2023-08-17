package com.example.discord_clone_api_ver2.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    //HttpSecurity : http요청에 대한 웹 기반 보안 구성하는 곳
    //SessionCreationPolicy.STATELESS : 스프링 시큐리티가 생성하지 않음. JWT같은 토큰 방식을 쓸 때 사용
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/api/hello" , "/login_page" , "/").permitAll()
                .antMatchers("/api/login").authenticated()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();

        return http.build();
    }


    @Bean
    AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("foo")
                .password("bar")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }


}
