package fastcampus.GetInLine.domain;

import fastcampus.GetInLine.domain.BaseEntity.TimeEntity;
import fastcampus.GetInLine.domain.constant.PlaceType;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(indexes = {
        @Index(columnList = "placeName"),
        @Index(columnList = "address"),
        @Index(columnList = "phoneNumber"),
})
@EntityListeners(AuditingEntityListener.class)
public class Place extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "varchar(20) default 'COMMON'") // MySQL 으로 DB를 설정 시 varchar 의 크기를 지정해줘야됨
    @Enumerated(EnumType.STRING)
    private PlaceType placeType;

    @Column(nullable = false)
    private String placeName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer capacity;

    private String memo;

    public Place() {
    }

    public Place(Long id, PlaceType placeType, String placeName, String address, String phoneNumber, Integer capacity, String memo) {
        this.id = id;
        this.placeType = placeType;
        this.placeName = placeName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.capacity = capacity;
        this.memo = memo;
    }

    public Place of(Long id, PlaceType placeType, String placeName, String address, String phoneNumber, Integer capacity, String memo) {
        return new Place(id, placeType, placeName, address, phoneNumber, capacity, memo);
    }
}
