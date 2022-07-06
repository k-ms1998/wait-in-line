package fastcampus.GetInLine.config;

import fastcampus.GetInLine.domain.constant.EventStatus;
import fastcampus.GetInLine.dto.EventDTO;
import fastcampus.GetInLine.repository.EventRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Configuration
public class RepositoryConfig {

    /**
     * EventRepository 가 JPARepository 를 상속받기 때문에 자동으로 빈 등록이 됨
     * 그러므로, Config 에서 따로 빈 등록하는 부분을 제거
     */
//    @Bean
//    public EventRepository eventRepository() {
//        return new EventRepository() {
//            @Override
//            public List<EventDTO> findEvents(Long placeId, String eventName, EventStatus eventStatus,
//                                             LocalDateTime eventStartDatetime, LocalDateTime eventEndDatetime) {
//                return null;
//            }
//
//            @Override
//            public Optional<EventDTO> findEvent(Long eventId) {
//                return Optional.empty();
//            }
//
//            @Override
//            public Boolean createEvent(EventDTO eventDTO) {
//                return null;
//            }
//
//            @Override
//            public Boolean modifyEvent(Long eventId, EventDTO eventDTO) {
//                return null;
//            }
//
//            @Override
//            public Boolean removeEvent(Long eventId) {
//                return null;
//            }
//        };
//    }
}
