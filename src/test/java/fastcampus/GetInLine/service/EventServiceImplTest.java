package fastcampus.GetInLine.service;

import fastcampus.GetInLine.domain.constant.EventStatus;
import fastcampus.GetInLine.dto.EventDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class EventServiceImplTest {

    private EventService eventService = new EventServiceImpl();

    /**
     * @SpringBootTest로 해서 eventService에 관계 주입을 통해 설정하지 않는 이유:
     * 해당 테스트는 EventService에만 있는 단순한 기능들만 테스트하는것이므로 Spring Boot 사용 X
     * 그러므로, Spring Boot Test로 설정해서 테스트에 걸리는 시간을 줄여주기 위해 @SpringBootTest으로 테스트 X
     * @SpringBootTest를 사용하지 않기 때문에 EventService 관계 주입 불가능
     */
//    @BeforeEach
//    void setUp() {
//        eventService = new EventServiceImpl();
//    }

    @DisplayName("[API][GET] 검색 조건 없이 검색시 모든 이벤트 반환")
    @Test
    void givenNothing_whenFindingEvents_thenReturnAllEvents() {
        // Given

        // When
        List<EventDTO> result = eventService.findEvents(null, null, null, null, null);

        // Then
        assertThat(result).hasSize(2);
    }

    @DisplayName("[API][GET] 검색 조건이 주어졌을때 조건들을 만족시키는 이벤트들 반환")
    @Test
    void givenSearchParameters_whenFindingEvents_thenReturnEvents() {
        // Given
        Long placeId = 1L;
        String eventName = "Morning Workout";
        EventStatus eventStatus = EventStatus.OPENED;
        LocalDateTime eventStartDatetime = LocalDateTime.of(2022, 1, 1, 0, 0, 0);
        LocalDateTime eventEndDatetime = LocalDateTime.of(2022, 1, 2, 0, 0, 0);

        // When
        List<EventDTO> result = eventService
                .findEvents(placeId, eventName, eventStatus,
                        eventStartDatetime, eventEndDatetime);

        // Then
        /**
         * 모든 결과 값들이 조건들을 만족시키는지 확인
         */
        assertThat(result)
                .allSatisfy(event -> {
                    assertThat(event)
                            .hasFieldOrPropertyWithValue("placeId", placeId)
                            .hasFieldOrPropertyWithValue("eventName", eventName)
                            .hasFieldOrPropertyWithValue("eventStatus", eventStatus);
                    assertThat(event.getEventStartDatetime()).isEqualTo(eventStartDatetime);
                    assertThat(event.getEventEndDatetime()).isEqualTo(eventEndDatetime);
                });
    }

    @DisplayName("[API][GET] 조건 없이 단건 조회")
    @Test
    void givenNothing_whenFindingSingleEvent_thenReturnsFirstEvent() {
        // Given

        // When
        Optional<EventDTO> result = eventService.findEvent(null);

        // Then
        assertThat(result).isNotNull();
    }

    @DisplayName("[API][GET] 조건을 만족하는 단건 조회")
    @Test
    void givenSearchParameters_whenFindingSingleEvent_thenReturnsFirstEvent() {
        // Given
        Long eventId = 1L;
        EventDTO afternoon_workout = createEventDTO(eventId, "Afternoon Workout", EventStatus.OPENED,
                LocalDateTime.of(2022, 1, 1, 0, 0, 0),
                LocalDateTime.of(2022, 1, 2, 0, 0, 0),
                20, 30, "Must arrive on time.");

        // When
        Optional<EventDTO> result = eventService.findEvent(eventId);

        // Then
        assertThat(result).hasValue(afternoon_workout);
    }

    @DisplayName("[API][PUT] 이벤트 ID와 정보를 주면, 이벤트 정보를 변경하고 true 반환")
    @Test
    void givenEventIdAndEventInfo_whenModifyingEvent_thenModifyEventAndReturnTrue() {
        // Given
        Long eventId = 1L;
        EventDTO afternoon_workout = createEventDTO(eventId, "Afternoon Workout", EventStatus.OPENED,
                LocalDateTime.of(2022, 1, 1, 0, 0, 0),
                LocalDateTime.of(2022, 1, 2, 0, 0, 0),
                29, 30, "Must arrive on time.");

        // When
        Boolean result = eventService.modifyEvent(eventId, afternoon_workout);

        // Then
        assertThat(result).isTrue();
    }

    @DisplayName("[API][PUT] 이벤트 ID는 주어지지 않고 변경할 정보만 주어질때, 변경을 하지 않고 false 반환")
    @Test
    void givenOnlyEventInfo_whenModifyingEvent_thenModifyEventAndReturnTrue() {
        // Given
        Long eventId = null;
        EventDTO afternoon_workout = createEventDTO(eventId, "Afternoon Workout", EventStatus.OPENED,
                LocalDateTime.of(2022, 1, 1, 0, 0, 0),
                LocalDateTime.of(2022, 1, 2, 0, 0, 0),
                29, 30, "Must arrive on time.");

        // When
        Boolean result = eventService.modifyEvent(eventId, afternoon_workout);

        // Then
        assertThat(result).isFalse();
    }

    @DisplayName("[API][PUT] 이벤트 ID만 주어지고 변경할 정보는 주어지지 않을때, 변경을 하지 않고 false 반환")
    @Test
    void givenOnlyEventId_whenModifyingEvent_thenModifyEventAndReturnTrue() {
        // Given
        Long eventId = 1L;
        EventDTO afternoon_workout = null;
        // When
        Boolean result = eventService.modifyEvent(eventId, afternoon_workout);

        // Then
        assertThat(result).isFalse();
    }

    @DisplayName("[API][DELETE] 이벤트 ID가 주어지고, 해당 이벤트를 삭제하고 true 반환")
    @Test
    void givenEventId_whenRemovingEvent_thenRemoveEventAndReturnTrue() {
        // Given
        Long eventId = 1L;

        // When
        Boolean result = eventService.removeEvent(eventId);

        // Then
        assertThat(result).isTrue();
    }


    @DisplayName("[API][DELETE] 이벤트 ID가 주어지지 않고, 해당 이벤트를 삭제하지 못하고 false 반환")
    @Test
    void givenEventId_whenRemovingEvent_thenNotRemoveEventAndReturnFalse() {
        // Given
        Long eventId = null;

        // When
        Boolean result = eventService.removeEvent(eventId);

        // Then
        assertThat(result).isFalse();
    }

    private EventDTO createEventDTO(Long placeId, String eventName, EventStatus eventStatus,
                                    LocalDateTime eventStartTime, LocalDateTime eventEndTime,
                                    Integer currentNumberOfPeople, Integer capacity, String memo) {

        return EventDTO.of(placeId, eventName, eventStatus, eventStartTime, eventEndTime, currentNumberOfPeople, capacity, memo);
    }
}