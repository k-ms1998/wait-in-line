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
        @Index(columnList = "placeId"),
        @Index(columnList = "eventName"),
        @Index(columnList = "eventStartDateTime"),
        @Index(columnList = "eventEndDateTime")
})
public class Event extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long placeId;

    @Column(nullable = false)
    private String eventName;

    @Column(nullable = false, columnDefinition = "varchar default 'OPENED'")
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

    public Event(Long id, Long placeId, String eventName, EventStatus eventStatus,
                 LocalDateTime eventStartDatetime, LocalDateTime eventEndDatetime,
                 Integer currentNumberOfPeople, Integer capacity, String memo) {
        this.id = id;
        this.placeId = placeId;
        this.eventName = eventName;
        this.eventStatus = eventStatus;
        this.eventStartDatetime = eventStartDatetime;
        this.eventEndDatetime = eventEndDatetime;
        this.currentNumberOfPeople = currentNumberOfPeople;
        this.capacity = capacity;
        this.memo = memo;
    }

    public Event of(Long id, Long placeId, String eventName, EventStatus eventStatus,
                 LocalDateTime eventStartDatetime, LocalDateTime eventEndDatetime,
                 Integer currentNumberOfPeople, Integer capacity, String memo) {

        return new Event(id, placeId, eventName, eventStatus, eventStartDatetime, eventEndDatetime, currentNumberOfPeople, capacity, memo);
    }
}
