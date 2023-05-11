package com.example.demospringsecurity;

import com.example.demospringsecurity.entity.Role;
import com.example.demospringsecurity.entity.User;
import com.example.demospringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@SpringBootApplication
public class DemoSpringSecurityApplication {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringSecurityApplication.class, args);
    }

    @Bean
    @Transactional
    CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Role roleUser = new Role("USER");

                User user = new User("boris", passwordEncoder.encode("boris"));
                user.setRoleList(Arrays.asList(roleUser));
                userRepository.save(user);

//                Role roleAdmin = new Role("ADMIN");
            }
        };
    }

}
