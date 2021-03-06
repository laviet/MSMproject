package com.group15.msm.service;

import com.group15.msm.config.CustomUserDetails;
import com.group15.msm.model.User;
import com.group15.msm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(s));
        user.orElseThrow(() -> new UsernameNotFoundException("not found user: " + s));
        return user.map(CustomUserDetails::new).get();
    }
}
