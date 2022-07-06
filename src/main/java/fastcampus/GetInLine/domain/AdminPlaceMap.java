package fastcampus.GetInLine.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fastcampus.GetInLine.domain.BaseEntity.TimeEntity;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(indexes = {
        @Index(columnList = "adminId"),
        @Index(columnList = "placeId")
})
@EntityListeners(AuditingEntityListener.class)
public class AdminPlaceMap extends TimeEntity {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long adminId;

    @Column(nullable = false)
    private Long placeId;

    public AdminPlaceMap() {
    }

    public AdminPlaceMap(Long adminId, Long placeId) {
        this.adminId = adminId;
        this.placeId = placeId;
    }

    public AdminPlaceMap of(Long adminId, Long placeId) {
        return new AdminPlaceMap(adminId, placeId);
    }
}
