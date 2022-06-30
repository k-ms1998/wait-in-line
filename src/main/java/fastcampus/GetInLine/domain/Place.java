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

    public Place() {
    }

    public Place(Long id, PlaceType placeType, String placeName, String address, String phoneNumber, Integer capacity, String memo) {
        this.id = id;
        this.placeType = placeType;
        this.placeName = placeName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.capacity = capacity;
        this.memo = memo;
    }
}
