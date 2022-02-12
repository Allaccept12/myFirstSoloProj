package solo.project1.dto;


import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class UpdatePostRequestDto {

    private Long postId;

    @NotEmpty(message = "글 제목은 필수작성입니다.")
    private String title;

    @NotEmpty(message = "회원 이름은 필수작성입니다.")
    private String name;

    @NotEmpty(message = "글 내용은 필수작성입니다.")
    private String content;

}
