package solo.project1.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import solo.project1.domain.Comment;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentResponseDto {

    private Long comment_id;
    private String account_name;
    @NotEmpty(message = "댓글 내용은 필수입니다.")
    private String content;
    private LocalDateTime createTime;


    public CommentResponseDto(Comment comment) {
        this.comment_id = comment.getId();
        this.account_name = comment.getAccount().getName();
        this.content = comment.getContent();
        this.createTime = comment.getCreatedTime();
    }
}
