package fastcampus.GetInLine.service;

import fastcampus.GetInLine.domain.constant.EventStatus;
import fastcampus.GetInLine.dto.EventDTO;
import fastcampus.GetInLine.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public List<EventDTO> findEvents(Long placeId, String eventName,
                                     EventStatus eventStatus, LocalDateTime eventStartDatetime, LocalDateTime eventEndDatetime) {

        return eventRepository.findEvents(placeId, eventName, eventStatus, eventStartDatetime, eventEndDatetime);
    }

    @Override
    public Optional<EventDTO> findEvent(Long eventId) {
        return eventRepository.findEvent(eventId);
    }

    @Override
    public Boolean createEvent(EventDTO eventDTO) {
        return eventRepository.createEvent(eventDTO);
    }

    @Override
    public Boolean modifyEvent(Long eventId, EventDTO eventDTO) {
        return eventRepository.modifyEvent(eventId, eventDTO);
    }

    @Override
    public Boolean removeEvent(Long eventId) {
        return eventRepository.removeEvent(eventId);
    }

}
