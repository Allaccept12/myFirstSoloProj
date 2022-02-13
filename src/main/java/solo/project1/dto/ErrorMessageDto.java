package solo.project1.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.NamedAttributeNode;
import javax.websocket.server.ServerEndpoint;

@Getter @Setter
public class ErrorMessageDto {

    private String msg;
    private String href;

    public ErrorMessageDto(String msg, String href) {
        this.msg = msg;
        this.href = href;
    }
}
