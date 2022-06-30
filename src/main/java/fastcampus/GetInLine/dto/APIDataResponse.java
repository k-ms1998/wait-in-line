package fastcampus.GetInLine.dto;

import fastcampus.GetInLine.constant.ErrorCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true) // 부모 클래스(APIErrorResponse)의 EqualsANdHashCode도 호출
public class APIDataResponse<T> extends APIErrorResponse{

    private final T data;

    private APIDataResponse(T data) {
        super(true, ErrorCode.OK.getCode(), ErrorCode.OK.getMessage());
        this.data = data;
    }

    public static <T> APIDataResponse<T> of(T data) {
        return new APIDataResponse<>(data);
    }

    public static <T> APIDataResponse<T> empty() {
        return new APIDataResponse<>(null);
    }
}
