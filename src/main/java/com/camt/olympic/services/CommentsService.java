package com.camt.olympic.services;

import com.camt.olympic.entity.Comments;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CommentsService {
    List<Comments> getCommentsByCountry(String id);
    Optional<Comments> getCommentByCommentId(int id);
    Optional<Comments> updateCommentById(int id,Comments comments);
    void deleteCommentById(int id);
    Comments saveCommentToDatabase(Comments comments);
}
