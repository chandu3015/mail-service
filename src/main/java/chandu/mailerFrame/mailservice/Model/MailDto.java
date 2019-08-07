package chandu.mailerFrame.mailservice.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailDto {
    private String userName;
    private String from;
    private String to;
    private String content;
    private String host;
    private String password;
    private int port;


}
