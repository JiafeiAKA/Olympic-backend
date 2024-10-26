package com.camt.olympic.controllers;

import com.camt.olympic.entity.Comments;
import com.camt.olympic.security.user.Users;
import com.camt.olympic.services.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
@CrossOrigin
public class CommentController {

    final CommentsService commentsService;

    /**
     *
     * @param country ระหัสประเทศ 3 ตัว เช่น USA
     * @return
     */
    @GetMapping
    public List<Comments> getAllCommentsByCountry(
            @RequestParam(value = "country") String country
    ){
       return commentsService.getCommentsByCountry(country);
    }

    /**
     *
     * @param id id ของ comment
     * @return
     */
    @GetMapping("/get")
    public Optional<Comments> getCommentByCommentId(
            @RequestParam(value = "id") int id
    ){
        return commentsService.getCommentByCommentId(id);
    }

    /**
     *
     * @param {
     * "userId": 888888,
     * "countryId": "USA",
     * "commentText": "The WHERE clause is optional, but you'll usually want it, unless you really want to delete every row from the table.",
     * "createdAt": "2024-10-25T10:15:30",
     * "updatedAt": "2024-10-25T10:15:30",
     * "profileUri": "vvvvvvvv"
     * }
     * @return
     */
    @PostMapping("/newComment")
    public ResponseEntity<Comments> createUser(@RequestBody Comments comments){
        Comments comm = commentsService.saveCommentToDatabase(comments);
        return ResponseEntity.ok(comm);

    }


    /**
     * สำหรับ update Comment
     * @param id
     * @param newComment
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Comments> updateComment(@PathVariable int id, @RequestBody Comments newComment) {
        Optional<Comments> updatedUser = commentsService.updateCommentById(id,newComment);
        if (updatedUser.isPresent()) {
            return ResponseEntity.ok(updatedUser.get());
        } else {
            return ResponseEntity.notFound().build(); // ส่งกลับ HTTP 404 Not Found
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable int id){

        commentsService.deleteCommentById(id);

        return  ResponseEntity.noContent().build();
    }


}
