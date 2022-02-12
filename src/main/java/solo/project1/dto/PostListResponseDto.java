package solo.project1.dto;


import lombok.*;
import solo.project1.domain.Account;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostListResponseDto {

    private Long postId;
    private String title;
    private String name;
    private String content;
    private LocalDateTime createTime;

    @Builder
    public PostListResponseDto(Account post) {
        this.postId = post.getId();
        this.title = post.getTitle();
        this.name = post.getName();
        this.content = post.getContent();
        this.createTime = post.getModifiedTime();
    }
}
