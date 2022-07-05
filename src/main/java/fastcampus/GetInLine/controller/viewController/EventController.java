package fastcampus.GetInLine.controller.viewController;

import fastcampus.GetInLine.domain.constant.EventStatus;
import fastcampus.GetInLine.dto.EventDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/events")
@Controller
public class EventController {

    static Map<String, Object> map = new HashMap<>();

    @PostConstruct
    public void init() {
        // TODO: 임시 데이터. 추후 삭제 예정
        map.put("events", List.of(
                EventDTO.of(
                        1L,
                        "오전 운동",
                        EventStatus.OPENED,
                        LocalDateTime.of(2021, 1, 1, 13, 0, 0),
                        LocalDateTime.of(2021, 1, 1, 16, 0, 0),
                        5,
                        20,
                        "마스크 꼭 착용하세요. 물을 꼭 준비하세요."
                ), EventDTO.of(
                        2L,
                        "오후 운동",
                        EventStatus.OPENED,
                        LocalDateTime.of(2021, 1, 1, 13, 0, 0),
                        LocalDateTime.of(2021, 1, 1, 16, 0, 0),
                        10,
                        30,
                        "마스크 꼭 착용하세요"
                )
        ));
    }


    @GetMapping("/")
    public ModelAndView events() {

        return new ModelAndView("event/index", map);
    }

    @GetMapping("/{eventId}")
    public String eventDetail(@PathVariable Integer eventId) {

        return "event/detail";
    }

}