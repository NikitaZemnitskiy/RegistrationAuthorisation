package com.example.demo;

import com.example.demo.logick.entity.AuthoritiesRepository;
import com.example.demo.logick.entity.Authority;
import com.example.demo.logick.entity.User;
import com.example.demo.logick.entity.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class UserController {
   /* @Autowired
    UserRepository userRepository;
    @Autowired
    AuthoritiesRepository authoritiesRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    Logger log = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/registration")
    public void createUser(@RequestBody User user){
       *//* UserService userService = new UserService(user);
        userService.saveUser();*//*

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

    @GetMapping("/registration")
    public Optional<User> getUser(@RequestParam("id")int id){
        log.info("getUser({})", id);
        Optional<User> u = userRepository.findById(id);
        log.info("getUser({}) => {}", id, u);
        return u;
    }*/
}
