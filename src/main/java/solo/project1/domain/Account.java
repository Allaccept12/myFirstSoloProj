package solo.project1.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import solo.project1.dto.UpdatePostRequestDto;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends TimeStamped { // 게시글임...

    @Id @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    private String title;

    private String name;

    private String content;

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Account(String title, String content, String name) {
        this.title = title;
        this.content = content;
        this.name = name;
    }

    public void updatePost(UpdatePostRequestDto dto) {
        this.title = dto.getTitle();
        this.name = dto.getName();
        this.content = dto.getContent();
    }



}
