package fastcampus.GetInLine.constant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ErrorCodeTest {

    static String exceptionMessage = "Exception Test";

    /**
     * ErrorCode 의 모든 오류 메세지를 편하게 테스트하기
     * 같은 이름의 메소드를 생성해서, Stream 으로 모든 인자들을 넘겨줌
     * @ParameterizedTest
     * @MethodSource: 테스트의 파라미터들을 메소드로 부터 받음 -> 테스트가 이루어지는 메소드 이름이랑 파라미터를 넘겨주는 메소드의 이름들이 인식됨
     */
    @ParameterizedTest
    @MethodSource
    void givenMessageAndException_whenGettingMessage_thenReturnsMessage(ErrorCode errorCode, String expected) {
        // Given
        Exception e = new Exception(exceptionMessage);

        // When
        String actual = errorCode.getMessage(e);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> givenMessageAndException_whenGettingMessage_thenReturnsMessage() {
        return Stream.of(
                /**
                 * Arguments.arguments(ErrorCode errorCode, String expected);
                 */
                Arguments.arguments(ErrorCode.OK, "Ok - " + exceptionMessage),
                Arguments.arguments(ErrorCode.BAD_REQUEST, "Bad request - " + exceptionMessage),
                Arguments.arguments(ErrorCode.SPRING_BAD_REQUEST, "Spring-detected bad request - " + exceptionMessage),
                Arguments.arguments(ErrorCode.VALIDATION_ERROR, "Validation error - " + exceptionMessage),
                Arguments.arguments(ErrorCode.NOT_FOUND, "Requested resource is not found - " + exceptionMessage),
                Arguments.arguments(ErrorCode.INTERNAL_ERROR, "Internal error - " + exceptionMessage),
                Arguments.arguments(ErrorCode.SPRING_INTERNAL_ERROR, "Spring-detected internal error - " + exceptionMessage),
                Arguments.arguments(ErrorCode.DATA_ACCESS_ERROR, "Data access error - " + exceptionMessage)
        );
    }
}