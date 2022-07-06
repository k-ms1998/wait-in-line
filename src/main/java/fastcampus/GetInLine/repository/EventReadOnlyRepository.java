package fastcampus.GetInLine.repository;

import fastcampus.GetInLine.domain.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface EventReadOnlyRepository<T, ID> extends JpaRepository<T, ID> {

    Optional<T> findReadOnlyById(Long id);
    List<T> findReadOnlyAll();
    List<T> findReadOnlyAllById(Iterable<Long> ids);
    List<T> findReadOnlyAll(Sort sort);
    Page<T> findReadOnlyAll(Pageable pageable);
}
