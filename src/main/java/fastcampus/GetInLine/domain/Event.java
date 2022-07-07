package fastcampus.GetInLine.domain;

import fastcampus.GetInLine.domain.BaseEntity.TimeEntity;
import fastcampus.GetInLine.domain.constant.EventStatus;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(indexes = {
        @Index(columnList = "eventName"),
        @Index(columnList = "eventStartDateTime"),
        @Index(columnList = "eventEndDateTime")
})
public class Event extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false) // 여러개의 이벤트가 하나의 장소에서 일어남
    private Place place;

    @Column(nullable = false)
    private String eventName;

    @Column(nullable = false, columnDefinition = "varchar(20) default 'OPENED'") // MySQL 으로 DB를 설정 시 varchar 의 크기를 지정해줘야됨
    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;

    @Column(nullable = false, columnDefinition = "datetime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime eventStartDatetime;

    @Column(nullable = false, columnDefinition = "datetime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime eventEndDatetime;

    @Column(nullable = false)
    private Integer currentNumberOfPeople;

    @Column(nullable = false)
    private Integer capacity;

    private String memo;

    public Event() {
    }

    public Event(Long id, Place place, String eventName, EventStatus eventStatus,
                 LocalDateTime eventStartDatetime, LocalDateTime eventEndDatetime,
                 Integer currentNumberOfPeople, Integer capacity, String memo) {
        this.id = id;
        this.place = place;
        this.eventName = eventName;
        this.eventStatus = eventStatus;
        this.eventStartDatetime = eventStartDatetime;
        this.eventEndDatetime = eventEndDatetime;
        this.currentNumberOfPeople = currentNumberOfPeople;
        this.capacity = capacity;
        this.memo = memo;
    }

    public Event of(Long id, Place place, String eventName, EventStatus eventStatus,
                 LocalDateTime eventStartDatetime, LocalDateTime eventEndDatetime,
                 Integer currentNumberOfPeople, Integer capacity, String memo) {

        return new Event(id, place, eventName, eventStatus, eventStartDatetime, eventEndDatetime, currentNumberOfPeople, capacity, memo);
    }
}
