package fastcampus.GetInLine.controller.error;

import fastcampus.GetInLine.constant.ErrorCode;
import fastcampus.GetInLine.dto.APIErrorResponse;
import fastcampus.GetInLine.exception.GeneralException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.handler.DispatcherServletWebRequest;

import javax.validation.ConstraintViolationException;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class APIExceptionHandlerTest {

    private APIExceptionHandler sut;
    private WebRequest request;

    @BeforeEach
    void setUp() {
        sut = new APIExceptionHandler();
        request = new DispatcherServletWebRequest(new MockHttpServletRequest());
    }

    @Test
    void givenValidationException_whenCallingValidation_thenReturnsResponseEntity() {
        // Given
        ConstraintViolationException e = new ConstraintViolationException(Set.of());

        // When
        ResponseEntity<Object> response = sut.validation(e, request);
        Object responseBody = response.getBody();
        HttpHeaders responseHeaders = response.getHeaders();
        HttpStatus responseStatusCode = response.getStatusCode();

        // Then
        assertThat(response)
                .hasFieldOrPropertyWithValue("body",
                        APIErrorResponse.of(false, ErrorCode.VALIDATION_ERROR, e))
                .hasFieldOrPropertyWithValue("headers", HttpHeaders.EMPTY)
                .hasFieldOrPropertyWithValue("statusCode", HttpStatus.BAD_REQUEST);
    }

    @DisplayName("프로젝트 일반 오류")
    @Test
    void givenGeneralException_whenCallingGeneral_thenReturnsResponseEntity() {

        // Given
        GeneralException e = new GeneralException("Test Message");

        // When
        ResponseEntity<Object> response = sut.general(e, request);

        // Then
        assertThat(response)
                .hasFieldOrPropertyWithValue("body",
                        APIErrorResponse.of(false, e.getErrorCode(), e))
                .hasFieldOrPropertyWithValue("headers", HttpHeaders.EMPTY)
                .hasFieldOrPropertyWithValue("statusCode",
                        response.getStatusCode().is4xxClientError() ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DisplayName("프로젝트 일반 오류")
    @Test
    void givenOtherException_whenCallingException_thenReturnsResponseEntity() {

        // Given
        Exception e = new Exception();

        // When
        ResponseEntity<Object> response = sut.exception(e, request);

        // Then
        assertThat(response)
                .hasFieldOrPropertyWithValue("body",
                        APIErrorResponse.of(false, ErrorCode.INTERNAL_ERROR, e))
                .hasFieldOrPropertyWithValue("headers", HttpHeaders.EMPTY)
                .hasFieldOrPropertyWithValue("statusCode", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}