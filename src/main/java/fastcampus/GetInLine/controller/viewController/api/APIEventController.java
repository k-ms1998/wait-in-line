package fastcampus.GetInLine.controller.viewController.api;

import fastcampus.GetInLine.domain.constant.EventStatus;
import fastcampus.GetInLine.dto.APIDataResponse;
import fastcampus.GetInLine.dto.EventDTO;
import fastcampus.GetInLine.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class APIEventController {

    private final EventService eventService;

    @GetMapping("/events")
    public APIDataResponse<List<EventDTO>> findEvents(
            @Positive Long placeId,
            @Size(min = 2)String eventName,
            EventStatus eventStatus,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime eventStartDateTime,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime eventEndDateTime
    ) {
        //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) => String을 ISO 규격에 맞는 시간으로 변환해주는 애노테이션

        return APIDataResponse.of(eventService
                .findEvents(placeId, eventName, eventStatus, eventStartDateTime, eventEndDateTime)
                .stream()
                .map(EventDTO::from) // == .map(e -> {return EventDTO.from(e));}
                .collect(Collectors.toList()));
    }

    @PostMapping("/events")
    public Boolean createEvent() {
        return true;
    }

    @GetMapping("/events/{eventId}")
    public String getEvent(@PathVariable Integer eventId) {
        return "event " + eventId;
    }

    @PutMapping("/events/{eventId}")
    public Boolean modifyEvent(@PathVariable Integer eventId) {
        return true;
    }

    @DeleteMapping("/events/{eventId}")
    public Boolean removeEvent(@PathVariable Integer eventId) {
        return true;
    }

}