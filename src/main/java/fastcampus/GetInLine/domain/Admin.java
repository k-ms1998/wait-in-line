package fastcampus.GetInLine.domain;

import lombok.Getter;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Getter
public class Admin {
    private Long id;

    private String email;
    private String nickname;
    private String password;
    private String phoneNumber;
    private String memo;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
