package com.camt.olympic.security.user;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<Users> getUser(String username);
    List<Users> getAllUser();
    Users saveUser(Users users);
    ResponseEntity<Void> deleteById(int id);
    Optional<Users> updateRole(int id, Users users);
}
