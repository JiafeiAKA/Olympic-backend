package com.camt.olympic.security.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    final UserDao userDao;


    @Override
    public Users getUser(String username) {
        return userDao.getUser(username);
    }

    @Override
    public List<Users> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public Users saveUser(Users users) {
        return userDao.saveUserToDatabase(users);
    }

    @Override
    public ResponseEntity<Void> deleteById(int id) {
        return userDao.deleteById(id);
    }

    @Override
    public Optional<Users> updateRole(int id, Users users) {
        return userDao.updateRole(id, users);
    }


}
