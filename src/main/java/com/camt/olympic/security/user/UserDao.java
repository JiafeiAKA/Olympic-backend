package com.camt.olympic.security.user;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<Users> getAllUser();
    Users getUser(String username);
    Users saveUserToDatabase(Users user);
    ResponseEntity<Void> deleteById(int id);

    Optional<Users> updateRole(int id, Users users);
}
