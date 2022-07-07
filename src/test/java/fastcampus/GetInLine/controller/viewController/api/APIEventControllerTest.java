package fastcampus.GetInLine.controller.viewController.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import fastcampus.GetInLine.constant.ErrorCode;
import fastcampus.GetInLine.domain.Place;
import fastcampus.GetInLine.domain.constant.EventStatus;
import fastcampus.GetInLine.domain.constant.PlaceType;
import fastcampus.GetInLine.dto.EventDTO;
import fastcampus.GetInLine.dto.PlaceDTO;
import fastcampus.GetInLine.service.EventService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(APIEventController.class)
class APIEventControllerTest {

    private final MockMvc mvc;
    private final ObjectMapper mapper;

    @MockBean
    private EventService eventService;

    public APIEventControllerTest(@Autowired MockMvc mvc, @Autowired ObjectMapper mapper) {
        this.mvc = mvc;
        this.mapper = mapper;
    }

    @DisplayName("[API][GET] 이벤트 리스트 조회 + 검색 파라미터")
    @Test
    void givenParameters_whenRequestingEvents_thenReturnsListOfEventsInStandardResponse() throws Exception {
        // Given
        given(eventService.findEvents(any(), any(), any(), any(), any())).willReturn(List.of(createEventDTO()));

        // When & Then
        mvc.perform(get("/api/events")
                        .queryParam("placeId", "1")
                        .queryParam("eventName", "운동")
                        .queryParam("eventStatus", EventStatus.OPENED.name())
                        .queryParam("eventStartDatetime", "2021-01-01T00:00:00")
                        .queryParam("eventEndDatetime", "2021-01-02T00:00:00"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isArray()) // $.data == APIDataResponse.data
                .andExpect(jsonPath("$.data[0].placeId").value(1L))
                .andExpect(jsonPath("$.data[0].eventName").value("오후 운동"))
                .andExpect(jsonPath("$.data[0].eventStatus").value(EventStatus.OPENED.name()))
                .andExpect(jsonPath("$.data[0].eventStartDatetime").value(LocalDateTime
                        .of(2021, 1, 1, 13, 0, 0)
                        .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)))
                .andExpect(jsonPath("$.data[0].eventEndDatetime").value(LocalDateTime
                        .of(2021, 1, 1, 16, 0, 0)
                        .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)))
                .andExpect(jsonPath("$.data[0].currentNumberOfPeople").value(10))
                .andExpect(jsonPath("$.data[0].capacity").value(30))
                .andExpect(jsonPath("$.data[0].memo").value("마스크 꼭 착용하세요"))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.errorCode").value(ErrorCode.OK.getCode()))
                .andExpect(jsonPath("$.message").value(ErrorCode.OK.getMessage()));

        then(eventService).should().findEvents(any(), any(), any(), any(), any());
    }

    @DisplayName("[API][GET] 이벤트 리스트 조회 + 검색 파라미터")
    @Test
    void givenWrongParameters_whenRequestingEvents_thenReturnsFailedResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/events")
                        .queryParam("placeId", "-1")
                        .queryParam("eventName", "H")
                        .queryParam("eventStatus", EventStatus.OPENED.name())
                        .queryParam("eventStartDatetime", "2021-01-01T00:00:00")
                        .queryParam("eventEndDatetime", "2021-01-02T00:00:00"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.errorCode").value(ErrorCode.VALIDATION_ERROR.getCode()))
                .andExpect(jsonPath("$.message").value(containsString(ErrorCode.VALIDATION_ERROR.getMessage())));

        then(eventService).shouldHaveNoInteractions();
    }

    @DisplayName("[API][POST] 이벤트 생성 - 잘못된 정보 입력")
    @Test
    void givenWrongEvent_whenCreatingAnEvent_thenReturnsFailedStandardResponse() throws Exception {
        // Given
        EventDTO eventResponse = EventDTO.of(
                new Place(1L),
                " ",
                null,
                null,
                null,
                -1,
                0,
                "마스크 꼭 착용하세요"
        );

        // When & Then
        mvc.perform(post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(eventResponse)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.errorCode").value(ErrorCode.SPRING_BAD_REQUEST.getCode()))
                .andExpect(jsonPath("$.message").value(containsString(ErrorCode.SPRING_BAD_REQUEST.getMessage())));

        then(eventService).shouldHaveNoInteractions();
    }


    private EventDTO createEventDTO() {
        return EventDTO.of(
                new Place(1L),
                "오후 운동",
                EventStatus.OPENED,
                LocalDateTime.of(2021, 1, 1, 13, 0, 0),
                LocalDateTime.of(2021, 1, 1, 16, 0, 0),
                10,
                30,
                "마스크 꼭 착용하세요"
        );
    }

    private PlaceDTO createPlaceDto(Long placeId) {
        return PlaceDTO.of(
                PlaceType.COMMON,
                "배트민턴장",
                "서울시 가나구 다라동",
                "010-1111-2222",
                10,
                null
        );
    }
    
}