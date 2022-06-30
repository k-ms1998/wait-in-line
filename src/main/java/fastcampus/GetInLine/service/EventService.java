package fastcampus.GetInLine.service;

import fastcampus.GetInLine.domain.constant.EventStatus;
import fastcampus.GetInLine.dto.EventDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * 이벤트 서비스
 */
public interface EventService {

    /**
     *
     * @param placeId 장소 ID
     * @param eventName 이벤트 이름
     * @param eventStatus 이벤트 상태
     * @param eventStartDatetime 이벤트 시작 시간
     * @param eventEndDatetime 이벤트 종료 시간
     * @return
     */
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
