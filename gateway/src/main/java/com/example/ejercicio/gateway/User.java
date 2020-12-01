package com.example.ejercicio.gateway;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Document
public class User implements UserDetails {

    private @Id String id;

    private String username;

    private String password;

    private String domain;

    private boolean active = true;

    private boolean acexpired = true;

    private boolean lock = true;

    private boolean expire = true;

    private Set<SimpleGrantedAuthority> roles= new HashSet<>();

    public User(){

    }

    public User(String id, String username, String password, String domain, boolean active, boolean acexpired, boolean lock, boolean expire, Set<SimpleGrantedAuthority> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.domain = domain;
        this.active = active;
        this.acexpired = acexpired;
        this.lock = lock;
        this.expire = expire;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return acexpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return lock;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return expire;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setAcexpired(boolean acexpired) {
        this.acexpired = acexpired;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public void setExpire(boolean expire) {
        this.expire = expire;
    }

    public String getId() {
        return id;
    }

    public String getDomain() {
        return domain;
    }

    public void setRoles(Set<SimpleGrantedAuthority> roles) {
        this.roles = roles;
    }
}
