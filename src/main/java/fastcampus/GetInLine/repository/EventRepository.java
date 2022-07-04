package fastcampus.GetInLine.repository;

import fastcampus.GetInLine.domain.constant.EventStatus;
import fastcampus.GetInLine.dto.EventDTO;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventRepository {
    List<EventDTO> findEvents(Long placeId,
                              String eventName,
                              EventStatus eventStatus,
                              LocalDateTime eventStartDatetime,
                              LocalDateTime eventEndDatetime);

    Optional<EventDTO> findEvent(Long eventId);

    Boolean createEvent(EventDTO eventDTO);

    Boolean modifyEvent(Long eventId, EventDTO eventDTO);

    Boolean removeEvent(Long eventId);
}
