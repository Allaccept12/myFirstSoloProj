package solo.project1.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UpdatePostRequestDto {

    private String title;
    private String name;
    private String content;
}
