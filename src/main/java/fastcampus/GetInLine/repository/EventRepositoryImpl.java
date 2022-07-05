package fastcampus.GetInLine.repository;

import fastcampus.GetInLine.domain.constant.EventStatus;
import fastcampus.GetInLine.dto.EventDTO;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class EventRepositoryImpl implements EventRepository {

    @Override
    public List<EventDTO> findEvents(Long placeId, String eventName, EventStatus eventStatus,
                                     LocalDateTime eventStartDatetime, LocalDateTime eventEndDatetime) {
        return List.of();
    }

    @Override
    public Optional<EventDTO> findEvent(Long eventId) {
        return Optional.empty();
    }

    @Override
    public Boolean createEvent(EventDTO eventDTO) {
        return null;
    }

    @Override
    public Boolean modifyEvent(Long eventId, EventDTO eventDTO) {
        return null;
    }

    @Override
    public Boolean removeEvent(Long eventId) {
        return null;
    }
}
