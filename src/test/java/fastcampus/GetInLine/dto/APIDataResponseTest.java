package fastcampus.GetInLine.dto;

import fastcampus.GetInLine.constant.ErrorCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import static org.assertj.core.api.Assertions.*;

/**
 * TDD Practice
 * Red-Green-Yellow(Refactor) Method Testing
 * Red: Think about what I want to develop
 * Green: Think about how I want to make the tests pass
 * Yellow(Refactor): Think about how to improve the existing implementation
 */
class APIDataResponseTest {

    @DisplayName("[DTO] 문자열 데이터가 주어졌을때 표준 성공 응답 반환")
    @Test
    void givenStringData_whenCreatingResponse_thenReturnsSuccessfulResponse() {
        //Given
        String data = "Test Data";

        //When
        APIDataResponse response = APIDataResponse.of(data);

        //Then
        assertThat(response)
                .hasFieldOrPropertyWithValue("success", true)
                .hasFieldOrPropertyWithValue("errorCode", ErrorCode.OK.getCode())
                .hasFieldOrPropertyWithValue("message", ErrorCode.OK.getMessage())
                .hasFieldOrPropertyWithValue("data", data);
    }

}