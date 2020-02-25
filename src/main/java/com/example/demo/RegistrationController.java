package com.example.demo;

import com.example.demo.logick.entity.AuthoritiesRepository;
import com.example.demo.logick.entity.Authority;
import com.example.demo.logick.entity.User;
import com.example.demo.logick.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class RegistrationController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthoritiesRepository authoritiesRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    Logger log = LoggerFactory.getLogger(UserController.class);
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user){
        log.info("createUser {}", user);
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        User saved = userRepository.save(user);
        log.info("User {} saved", saved);
       /* Authority authority = new Authority();
        authority.setUsername(user.getUsername());
        Authority savedAuthority = authoritiesRepository.save(authority);
        log.info("authoritiesSaved - {}", savedAuthority);
        log.info("authorities.username - {}", savedAuthority.getUsername());*/
        return "redirect:/login";
    }
}
