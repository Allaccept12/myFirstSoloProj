package solo.project1.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class CommentRequestDto {

    @NotEmpty(message = "내용을 입력해 주세요.")
    private String content;

}
