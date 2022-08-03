package com.example.codeup.springblog.models;

import com.example.codeup.springblog.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

public class UserWithRoles extends User implements UserDetails {

    public UserWithRoles(User user) {
        super(user);  // Call the copy constructor defined in User
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = ""; // Since we're not using the authorization part of the component
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
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

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Service
    public class UserDetailsLoader implements UserDetailsService {
        private final UserRepository users;

        public UserDetailsLoader(UserRepository users) {
            this.users = users;
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = users.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("No user found for " + username);
            }

            return new UserWithRoles(user);
        }
    }
}
