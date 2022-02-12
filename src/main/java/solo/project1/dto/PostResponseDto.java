package solo.project1.dto;


import lombok.*;
import solo.project1.domain.Account;
import solo.project1.domain.TimeStamped;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {

    private Long postId;
    private String title;
    private String name;
    private String content;
    private List<CommentResponseDto> comments;
    private LocalDateTime createTime;

    @Builder
    public PostResponseDto(Account post) {
        this.postId = post.getId();
        this.title = post.getTitle();
        this.name = post.getName();
        this.content = post.getContent();
        this.createTime = post.getCreatedTime();
        this.comments = post.getComments().stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());
    }


}
