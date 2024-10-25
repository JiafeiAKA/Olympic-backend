package com.camt.olympic.security.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
    final UserRepository userRepository;

    @Override
    public List<Users> getAllUser() {
        return userRepository.findAllUser();
    }

    @Override
    public Users getUser(String username) {

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
}
