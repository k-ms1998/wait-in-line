package fastcampus.GetInLine.controller.viewController;

import fastcampus.GetInLine.domain.constant.PlaceType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/places")
    public ModelAndView adminPlaces(
            @RequestParam(required = false) PlaceType placeType, @RequestParam(required = false) String placeName, @RequestParam(required = false) String address) {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("placeType", placeType);
        attributes.put("placeName", placeName);
        attributes.put("address", address);

        return new ModelAndView("admin/places", attributes);
    }

    @GetMapping("/places/{placeId}")
    public String adminPlaceDetail(@PathVariable Integer placeId) {
        return "admin/place-detail";
    }

    @GetMapping("/events")
    public String adminEvents() {
        return "admin/events";
    }

    @GetMapping("/events/{eventId}")
    public String adminEventDetail(@PathVariable Integer eventId) {
        return "admin/event-detail";
    }

}
