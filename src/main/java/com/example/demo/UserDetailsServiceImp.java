package com.example.demo;

import com.example.demo.logick.entity.AuthoritiesRepository;
import com.example.demo.logick.entity.User;
import com.example.demo.logick.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


class UserDetailsServiceImp implements UserDetailsService {
    Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthoritiesRepository authoritiesRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("current name in userDetailService {}", username);
        User user = findUserbyUsername(username);
        log.info("current user in userDetailService {}", user);
        UserBuilder builder = null;
        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
            builder.authorities("ROLE_USER");
        
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }

    private User findUserbyUsername(String username) {
        List<User> users= (List<User>) userRepository.findAll();
        for(User user:users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
}