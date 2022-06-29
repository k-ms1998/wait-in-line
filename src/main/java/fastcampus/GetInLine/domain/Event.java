package fastcampus.GetInLine.domain;

import fastcampus.GetInLine.domain.constant.EventStatus;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Event {
    private Long id;

    private Long placeId;
    private String eventName;
    private EventStatus eventStatus;
    private LocalDateTime eventStartDatetime;
    private LocalDateTime eventEndDatetime;
    private Integer currentNumberOfPeople;
    private Integer capacity;
    private String memo;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
