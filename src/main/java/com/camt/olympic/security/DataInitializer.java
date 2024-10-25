package com.camt.olympic.security;

import com.camt.olympic.security.user.UserRepository;
import com.camt.olympic.security.user.Users;
import com.camt.olympic.security.user.token.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInitializer {

    private final UserRepository userRepository;
    @Autowired
    private AuthService authService;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.passwordEncoder = new BCryptPasswordEncoder(); // สำหรับเข้ารหัสรหัสผ่าน
    }

    @Bean
    public CommandLineRunner insertAdminUser() {
        return args -> {
            // เช็คว่ามี admin อยู่แล้วหรือไม่
            if (userRepository.getUser("admin").isEmpty()) {
                // เพิ่มผู้ใช้ admin
                Users admin = new Users();
                admin.setUsername("admin");
                String passHash = authService.encodePassword("admin");
                admin.setPasswordHash(passHash); // เข้ารหัสรหัสผ่าน
                admin.setEmail("admin@mail.com");
                admin.setRole(Users.Role.ADMIN);
                admin.setCreatedAt(LocalDateTime.now());

                userRepository.save(admin);
                System.out.println("Admin user created.");
            } else {
                System.out.println("Admin user already exists.");
            }
        };
    }
}