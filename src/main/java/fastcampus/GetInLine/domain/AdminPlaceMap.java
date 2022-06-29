package fastcampus.GetInLine.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AdminPlaceMap {
    private Long id;

    private Long adminId;
    private Long placeId;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
