package com.camt.olympic.security.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Integer> {

    @Query(value = "SELECT * FROM users WHERE username = :username;",nativeQuery = true)
    Optional<Users> getUser(@Param("username") String username);

    @Query(value = "SELECT * FROM users",nativeQuery = true)
    List<Users> findAllUser();


}
