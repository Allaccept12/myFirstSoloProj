package solo.project1.dto;


import lombok.*;

@Getter @Setter
public class UpdatePostRequestDto {

    private String title;
    private String name;
    private String content;
}
