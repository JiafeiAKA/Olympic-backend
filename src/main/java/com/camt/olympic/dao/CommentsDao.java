package com.camt.olympic.dao;

import com.camt.olympic.entity.Comments;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CommentsDao {
    List<Comments> getCommentsByCountry(String id);
    Optional<Comments> getCommentByCommentId(int id);
    Optional<Comments> updateCommentById(int id,Comments newComment);
    ResponseEntity<Void> deleteCommentById(int id);
    Comments saveCommentToDatabase(Comments comments);
}
