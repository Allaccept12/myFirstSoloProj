package solo.project1.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solo.project1.dto.CommentRequestDto;
import solo.project1.dto.CommentResponseDto;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "comment")
public class Comment extends TimeStamped {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;


    @Builder
    public Comment(String content, Account post) {
        this.content = content;
        this.account = post;
        this.account.getComments().add(this);
    }

    public void updateComment(CommentResponseDto dto) {
        this.content = dto.getContent();
    }

    public void deleteComment() {
        this.account.getComments().remove(this);
    }


}