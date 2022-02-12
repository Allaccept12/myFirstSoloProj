package solo.project1.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solo.project1.domain.Account;
import solo.project1.domain.Comment;
import solo.project1.dto.CommentRequestDto;
import solo.project1.repository.CommentRepository;
import solo.project1.repository.PostRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;


    public void createComment(CommentRequestDto commentRequestDto,Long postId) {
        Account post = postRepository.findById(postId).orElseThrow(NullPointerException::new);
        Comment comment = Comment.builder()
                .content(commentRequestDto.getContent())
                .post(post)
                .build();
        commentRepository.save(comment);
    }
    public void updateComment(CommentRequestDto commentRequestDto,Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(NullPointerException::new);
        comment.updateComment(commentRequestDto);
    }

    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(NullPointerException::new);
        comment.deleteComment();
        commentRepository.deleteById(commentId);
    }

}










