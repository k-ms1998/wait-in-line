package fastcampus.GetInLine.dto;

import fastcampus.GetInLine.domain.Place;
import fastcampus.GetInLine.domain.constant.EventStatus;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
public class EventDTO {

    private Place place;
    @NotBlank private String eventName;
    @NotNull private EventStatus eventStatus;
    @NotNull private LocalDateTime eventStartDatetime;
    @NotNull private LocalDateTime eventEndDatetime;
    @NotNull private Integer currentNumberOfPeople;
    @NotNull private Integer capacity;
    private String memo;

    public EventDTO() {
    }

    public EventDTO(Place place, String eventName, EventStatus eventStatus,
                    LocalDateTime eventStartDatetime, LocalDateTime eventEndDatetime,
                    Integer currentNumberOfPeople, Integer capacity, String memo) {
        this.place = place;
        this.eventName = eventName;
        this.eventStatus = eventStatus;
        this.eventStartDatetime = eventStartDatetime;
        this.eventEndDatetime = eventEndDatetime;
        this.currentNumberOfPeople = currentNumberOfPeople;
        this.capacity = capacity;
        this.memo = memo;
    }

    public static EventDTO of(Place place, String eventName, EventStatus eventStatus,
                              LocalDateTime eventStartDatetime, LocalDateTime eventEndDatetime,
                              Integer currentNumberOfPeople, Integer capacity, String memo) {
        return new EventDTO(place, eventName, eventStatus, eventStartDatetime, eventEndDatetime, currentNumberOfPeople, capacity, memo);
    }

    public static EventDTO from(EventDTO eventDTO) {
        if (eventDTO.equals(null)) {
            return null;
        }
        return EventDTO.of(eventDTO.getPlace(), eventDTO.getEventName(), eventDTO.getEventStatus(),
                eventDTO.getEventStartDatetime(), eventDTO.getEventEndDatetime(), eventDTO.getCurrentNumberOfPeople(),
                eventDTO.getCapacity(), eventDTO.getMemo());
    }
}

