package com.camt.olympic.security.user;

import com.camt.olympic.security.user.token.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private AuthService authService;

    final UserService userService;



    @GetMapping({"","/"})
    public List<Users> getAllUser(){
        return userService.getAllUser();
    }

    /**
     *
     * @param {
     *     "username": "user2",
     *     "passwordHash": "hashed_password_here",
     *     "email": "user2@example.com",
     *     "role": "REGISTERED",
     *     "createdAt" : "2024-10-25T10:15:30"
     * }
     * @return
     */
    @PostMapping("/newUser")
    public ResponseEntity<Users> createUser(@RequestBody Users users){
        Users userP = users;
        userP.setPasswordHash(authService.encodePassword(users.getPasswordHash()));
        Users create = userService.saveUser(userP);
        return ResponseEntity.ok(create);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id){

        userService.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

    /**
     * สำหรับ update User
     * @param id
     * @param userDetails
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable int id, @RequestBody Users userDetails) {
        Optional<Users> updatedUser = userService.updateRole(id, userDetails);
        if (updatedUser.isPresent()) {
            return ResponseEntity.ok(updatedUser.get());
        } else {
            return ResponseEntity.notFound().build(); // ส่งกลับ HTTP 404 Not Found
        }
    }




}
