package org.dmiit3iy.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;


public class UserDetailsImpl implements UserDetails {
    private long id;
    private String userName;
    private String password;


    public UserDetailsImpl(User user) {
        this.id = user.getId();
        this.userName = user.getName();
        this.password = user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public long getId() {
        return id;
    }


    @Override
    public boolean isEnabled() {
        return true;
    }
}
