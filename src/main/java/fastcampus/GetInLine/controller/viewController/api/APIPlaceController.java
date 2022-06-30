package fastcampus.GetInLine.controller.viewController.api;

import fastcampus.GetInLine.domain.Place;
import fastcampus.GetInLine.domain.constant.PlaceType;
import fastcampus.GetInLine.dto.APIDataResponse;
import fastcampus.GetInLine.dto.PlaceDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
public class APIPlaceController {

    Map<Long, Place> placeMemory = new HashMap<>();

    @PostConstruct
    public void init() {
        Place place1 = new Place(1L, PlaceType.SPORTS, "베드민턴", "서울시 송파구", "010-1234-5678", 30, "Hello");
        placeMemory.put(1L, place1);
    }

    @GetMapping("/places")
    public APIDataResponse<List<PlaceDTO>> getPlaces() {
        List<PlaceDTO> data = new ArrayList<>();
        data.add(
                PlaceDTO.of(PlaceType.COMMON, "베드민턴", "서울시 강남구", "010-1234-5678", 30, "Hello"));

        return APIDataResponse.of(data);
    }

    @PostMapping("/places")
    public Boolean createPlace() {
        return true;
    }

    @GetMapping("/places/{placeId}")
    public APIDataResponse<Place> getPlace(@PathVariable Integer placeId) {

        return APIDataResponse.of(placeMemory.get(Long.valueOf(placeId)));
    }

    @PutMapping("/places/{placeId}")
    public Boolean modifyPlace(@PathVariable Integer placeId) {
        return true;
    }

    @DeleteMapping("/places/{placeId}")
    public Boolean removePlace(@PathVariable Integer placeId) {
        return true;
    }

}