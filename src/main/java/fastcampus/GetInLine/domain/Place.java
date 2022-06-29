package fastcampus.GetInLine.domain;

import fastcampus.GetInLine.domain.constant.PlaceType;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Place {
    private Long id;

    private PlaceType placeType;
    private String placeName;
    private String address;
    private String phoneNumber;
    private Integer capacity;
    private String memo;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
