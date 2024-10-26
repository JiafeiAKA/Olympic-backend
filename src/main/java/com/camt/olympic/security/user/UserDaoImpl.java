package com.camt.olympic.security.user;

import com.camt.olympic.security.user.token.AuthService;
import com.camt.olympic.security.user.token.TokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
    private  final UserRepository userRepository;
    private  final TokenUtil tokenUtil;

    @Autowired
    private AuthService authService;

    @Override
    public List<Users> getAllUser() {
        return userRepository.findAllUser();
    }

    @Override
    public Optional<Users> getUser(String username) {

        return userRepository.getUser(username);
    }

    @Override
    public Users saveUserToDatabase(Users user) {
        userRepository.save(user);
        return user;

    }

    @Override
    public ResponseEntity<Void> deleteById(int id) {
        userRepository.deleteById(id);
        return null;
    }

    @Override
    public Optional<Users> updateRole(int id, Users users) {

        Optional<Users> user = userRepository.findById(id);
        if(user.isPresent()){
            Users newUser = user.get();
            newUser.setRole(users.getRole());

            return Optional.of(userRepository.save(newUser));
        }


        return Optional.empty();
    }

    @Override
    public ResponseEntity<?> login(LoginRequest loginRequest) {
       Optional<Users> users =  userRepository.getUser(loginRequest.getUsername());

        if(users.isPresent()){

            boolean isMatch = authService.matchPassword(loginRequest.getPassword(),users.get().getPasswordHash());

            if(!isMatch){
                return ResponseEntity.status(401).body("Invalid password");
            }

            String token = tokenUtil.generateToken(loginRequest.getUsername());
            return ResponseEntity.ok(new AuthResponse(token,users.get().getUsername(),users.get().getUserId()));
        }
        return ResponseEntity.status(404).body("User not found");
    }
}
