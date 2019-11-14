package com.group15.msm;

import com.group15.msm.model.User;
import com.group15.msm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication

public class MsmApplication implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(MsmApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        User user=new User();
//        user.setUsername("laviet5");
//        user.setPassword(passwordEncoder.encode("lav"));
//        userRepository.save(user);
//        System.out.println(user);


//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//        System.out.println("day la: "+currentPrincipalName);
    }
}
