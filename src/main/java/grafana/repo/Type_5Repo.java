package grafana.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import grafana.entity.Type_0;
import grafana.entity.Type_5;

public interface Type_5Repo extends JpaRepository<Type_5, String> {

	Page<Type_5>findAll(Pageable pageable);

}
