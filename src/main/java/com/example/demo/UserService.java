package com.example.demo;

import com.example.demo.logick.entity.Authority;
import com.example.demo.logick.entity.AuthoritiesRepository;
import com.example.demo.logick.entity.User;
import com.example.demo.logick.entity.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthoritiesRepository authoritiesRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    Logger log = LoggerFactory.getLogger(UserService.class);

    User user;

    public UserService() {
    }

    public UserService(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public  void saveUser(){
        log.info("createUser {}", user);
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        User saved = userRepository.save(user);
        log.info("User {} saved", saved);
        Authority authority = new Authority();
        authority.setUsername(user.getUsername());
        Authority savedAuthority = authoritiesRepository.save(authority);
        log.info("authoritiesSaved - {}", savedAuthority);
        log.info("authorities.username - {}", savedAuthority.getUsername());
    }
}
