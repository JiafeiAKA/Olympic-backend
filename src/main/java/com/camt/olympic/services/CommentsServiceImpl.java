package com.camt.olympic.services;


import com.camt.olympic.dao.CommentsDao;
import com.camt.olympic.entity.Comments;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentsServiceImpl implements  CommentsService{

    private final CommentsDao commentsDao;


    @Override
    public List<Comments> getCommentsByCountry(String id) {
        return commentsDao.getCommentsByCountry(id);
    }

    @Override
    public Optional<Comments> getCommentByCommentId(int id) {
        return commentsDao.getCommentByCommentId(id);
    }

    @Override
    public Optional<Comments> updateCommentById(int id,Comments newComment) {
        return commentsDao.updateCommentById(id,newComment);
    }

    @Override
    public void deleteCommentById(int id) {
        commentsDao.deleteCommentById(id);
    }

    @Override
    public Comments saveCommentToDatabase(Comments comments) {
        return commentsDao.saveCommentToDatabase(comments);
    }
}
