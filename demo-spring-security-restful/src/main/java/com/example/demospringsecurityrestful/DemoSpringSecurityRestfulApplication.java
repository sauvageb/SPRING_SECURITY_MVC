package com.example.demospringsecurityrestful;

import com.example.demospringsecurityrestful.repository.UserRepository;
import com.example.demospringsecurityrestful.repository.entity.Role;
import com.example.demospringsecurityrestful.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@SpringBootApplication
public class DemoSpringSecurityRestfulApplication {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;


    public static void main(String[] args) {
        SpringApplication.run(DemoSpringSecurityRestfulApplication.class, args);
    }


    @Bean
    @Transactional
    CommandLineRunner commandLineRunner() {
        return args -> {
            Role roleUser = new Role("USER");
            User user = new User("boris", passwordEncoder.encode("boris"));
            user.setRoleList(Arrays.asList(roleUser));
            userRepository.save(user);
        };
    }


}
