package com.example.vue_chat_server.vo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private String ID;
    private String PASSWORD;
    private String USERNAME;
    private String AUTHORITY;
    private boolean ENABLED;

    public CustomUserDetails(String ID, String PASSWORD, String USERNAME, String AUTHORITY, boolean ENABLED) {
        this.ID = ID;
        this.PASSWORD = PASSWORD;
        this.USERNAME = USERNAME;
        this.AUTHORITY = AUTHORITY;
        this.ENABLED = ENABLED;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        auth.add(new SimpleGrantedAuthority(AUTHORITY));
        return auth;
    }

    @Override
    public String getPassword() {
        return PASSWORD;
    }

    @Override
    public String getUsername() {
        return ID;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return ENABLED;
    }

    public String getNAME() {
        return USERNAME;
    }

    public void setNAME(String name) {
        USERNAME = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
