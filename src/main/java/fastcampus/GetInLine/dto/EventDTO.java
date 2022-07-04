package fastcampus.GetInLine.dto;

import fastcampus.GetInLine.domain.constant.EventStatus;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class EventDTO {

    private Long placeId;
    private String eventName;
    private EventStatus eventStatus;
    private LocalDateTime eventStartDatetime;
    private LocalDateTime eventEndDatetime;
    private Integer currentNumberOfPeople;
    private Integer capacity;
    private String memo;

    public EventDTO() {
    }

    public EventDTO(Long placeId, String eventName, EventStatus eventStatus,
                    LocalDateTime eventStartDatetime, LocalDateTime eventEndDatetime,
                    Integer currentNumberOfPeople, Integer capacity, String memo) {
        this.placeId = placeId;
        this.eventName = eventName;
        this.eventStatus = eventStatus;
        this.eventStartDatetime = eventStartDatetime;
        this.eventEndDatetime = eventEndDatetime;
        this.currentNumberOfPeople = currentNumberOfPeople;
        this.capacity = capacity;
        this.memo = memo;
    }

    public static EventDTO of(Long placeId, String eventName, EventStatus eventStatus,
                              LocalDateTime eventStartDatetime, LocalDateTime eventEndDatetime,
                              Integer currentNumberOfPeople, Integer capacity, String memo) {
        return new EventDTO(placeId, eventName, eventStatus, eventStartDatetime, eventEndDatetime, currentNumberOfPeople, capacity, memo);
    }
}

