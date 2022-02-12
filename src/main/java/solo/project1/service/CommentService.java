package solo.project1.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solo.project1.domain.Account;
import solo.project1.domain.Comment;
import solo.project1.dto.CommentRequestDto;
import solo.project1.repository.CommentRepository;
import solo.project1.repository.PostRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public Long createComment(CommentRequestDto commentRequestDto, Long postId) {
        Account account = postRepository.findById(postId).orElseThrow(NullPointerException::new);
        Comment comment = Comment.builder()
                .content(commentRequestDto.getContent())
                .post(account)
                .build();
        return commentRepository.save(comment).getId();
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










