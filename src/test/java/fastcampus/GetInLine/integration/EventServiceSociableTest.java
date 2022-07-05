package fastcampus.GetInLine.integration;

import fastcampus.GetInLine.domain.constant.EventStatus;
import fastcampus.GetInLine.dto.EventDTO;
import fastcampus.GetInLine.service.EventService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class EventServiceSociableTest {

    @Autowired
    private EventService eventService;

    @DisplayName("[API][GET] 검색 조건 없이 검색시 모든 이벤트 반환")
    @Test
    void givenNothing_whenFindingEvents_thenReturnAllEvents() {
        // Given

        // When
        List<EventDTO> result = eventService.findEvents(null, null, null, null, null);

        // Then
        assertThat(result).hasSize(0);
    }


}
