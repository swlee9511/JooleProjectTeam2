package com.javatraining.jooleprojectteam2.Service.impl;

import com.javatraining.jooleprojectteam2.Entity.LoginUserDetails;
import com.javatraining.jooleprojectteam2.Entity.User;
import com.javatraining.jooleprojectteam2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.HashSet;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username).orElse(null);
        if (ObjectUtils.isEmpty(user)) {
            throw new RuntimeException("user not found");
        }

        return new LoginUserDetails(user);
    }
}
