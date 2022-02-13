package solo.project1.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class CommentRequestDto {

    private String content;

}
