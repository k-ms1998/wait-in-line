package fastcampus.GetInLine.domain;

import fastcampus.GetInLine.domain.BaseEntity.TimeEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Table(indexes = {
        @Index(columnList = "phoneNumber")
})
public class Admin extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    private String memo;

    public Admin() {
    }

    public Admin(Long id, String email, String nickname, String password, String phoneNumber, String memo) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.memo = memo;
    }

    public Admin of(Long id, String email, String nickname, String password, String phoneNumber, String memo) {
        return new Admin(id, email, nickname, password, phoneNumber, memo);
    }
}
