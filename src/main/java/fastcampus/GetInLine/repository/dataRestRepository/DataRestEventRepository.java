package fastcampus.GetInLine.repository.dataRestRepository;

import com.querydsl.core.types.dsl.ComparableExpression;
import com.querydsl.core.types.dsl.StringExpression;
import fastcampus.GetInLine.domain.Event;
import fastcampus.GetInLine.domain.QEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

/**
 * Spring Data REST Practice
 * 1. application.properties에서 DATA REST를 사용할 Base Path 설정
 * => /rest/api 로 설정 => /rest/api/(엔티티의 복수 이름) 으로 REST 요청 보낼 수 있음 => Event 엔티티에 대해서 /rest/api/events 로 요청 가능
 * 2. Repository 가 JpaRepository, QuerydslPredicateExecutor, QuerydslBinderCustomizer 를 상속 받도록 설정
 * 3. customize 를 오버라이딩 해서 조건들을 설정 해줌
 * 4. 자동으로 해당 엔티티에 대한 CRUD & 페이징 & 설정한 필드들에 대한 검색이 가능한 api 들을 생성
 *
 * 외부에 노출되지 않고, 내부적으로 사용만하고 간단한 CRUD 만 필요로 할때만 사용하는 것을 권장
 * 손쉽게 CRUD가 구현되어서 편하지만, 제약이 많음
 */
public interface DataRestEventRepository
        extends JpaRepository<Event, Long>, QuerydslPredicateExecutor<Event>, QuerydslBinderCustomizer<QEvent> {

    @Override
    default void customize(QuerydslBindings bindings, QEvent root) {
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.placeId, root.eventName, root.eventStatus, root.eventStartDatetime, root.eventEndDatetime); // 파라미터로 검색이 가능하도록 할 필드들 지정
        bindings.bind(root.eventName).first(StringExpression::likeIgnoreCase);      // eventName으로 검색 할때, exactMatch가 아닌 like로 가능하도록 설정
        bindings.bind(root.eventStartDatetime).first(ComparableExpression::goe);    // eventStartDateTime으로 검색 할때, 크거나 같은 값을 가진 값들로 검색하도록 설정
        bindings.bind(root.eventEndDatetime).first(ComparableExpression::loe);      // eventEndDateTime으로 검색 할때, 작거나 같은 값을 가진 값들로 검색하도록 설정
    }
}
