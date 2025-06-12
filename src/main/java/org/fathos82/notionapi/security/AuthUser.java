package org.fathos82.notionapi.security;

import org.fathos82.notionapi.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class AuthUser implements UserDetails {
    private final User user;
    public AuthUser(User user){
        this.user = user;
    }

    //Hoje não trataremos sobre Roles de acesso, por isso definimos apenas uma ROLE
    // "USER".
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(() -> "USER");
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

}
