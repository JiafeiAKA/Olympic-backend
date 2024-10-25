package com.camt.olympic.dao;

import com.camt.olympic.entity.Comments;
import com.camt.olympic.repositories.CommentsRepository;
import com.camt.olympic.security.user.Users;
import com.camt.olympic.services.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class CommentsDaoImpl implements CommentsDao {
    final CommentsRepository commentsRepository;


    @Override
    public List<Comments> getCommentsByCountry(String id) {
        return commentsRepository.getCommentsByCountry(id);
    }

    @Override
    public Optional<Comments> getCommentByCommentId(int id) {
        return commentsRepository.getCommentsByCommentId(id);
    }

    @Override
    public Optional<Comments> updateCommentById(int id, Comments comments) {
        Optional<Comments> comm = commentsRepository.getCommentsByCommentId(id);
        if (comm.isPresent()) {
            Comments newComment = comm.get();
            newComment.setCommentText(comments.getCommentText());
            newComment.setUpdatedAt(comments.getUpdatedAt());

            return Optional.of(commentsRepository.save(newComment));
        }
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Void> deleteCommentById(int id) {
        commentsRepository.deleteById(id);
        return null;
    }

    @Override
    public Comments saveCommentToDatabase(Comments comments) {
        return commentsRepository.save(comments);
    }
}
