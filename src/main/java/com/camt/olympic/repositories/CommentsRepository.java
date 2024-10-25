package com.camt.olympic.repositories;

import com.camt.olympic.entity.Comments;
import com.camt.olympic.security.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Integer> {

    @Query(value = "SELECT * FROM Comments WHERE country_id = :country", nativeQuery = true)
    List<Comments> getCommentsByCountry(@Param("country") String country);

    @Query(value = "SELECT * FROM Comments WHERE comment_id = :id", nativeQuery = true)
    Optional<Comments> getCommentsByCommentId(@Param("id") int id);


}
