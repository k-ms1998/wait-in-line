package fastcampus.GetInLine.service;

import fastcampus.GetInLine.constant.ErrorCode;
import fastcampus.GetInLine.domain.constant.EventStatus;
import fastcampus.GetInLine.dto.EventDTO;
import fastcampus.GetInLine.exception.GeneralException;
import fastcampus.GetInLine.repository.EventRepository;
import fastcampus.GetInLine.repository.EventRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepositoryImpl eventRepository;

    @Override
    public List<EventDTO> findEvents(Long placeId, String eventName,
                                     EventStatus eventStatus, LocalDateTime eventStartDatetime, LocalDateTime eventEndDatetime) {

        try {
            return eventRepository.findEvents(placeId, eventName, eventStatus, eventStartDatetime, eventEndDatetime);
        } catch (Exception e) {
            throw new GeneralException(ErrorCode.DATA_ACCESS_ERROR, e);
        }

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
