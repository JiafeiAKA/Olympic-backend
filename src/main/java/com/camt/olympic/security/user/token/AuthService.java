package com.camt.olympic.security.user.token;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // ฟังก์ชันสำหรับเข้ารหัสรหัสผ่าน
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    // ฟังก์ชันสำหรับตรวจสอบรหัสผ่าน
    public boolean matchPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
