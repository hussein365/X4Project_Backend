package grafana.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import grafana.entity.Type_0;
import grafana.entity.Type_4;

public interface Type_4Repo extends JpaRepository<Type_4, String> {

	Page<Type_4>findAll(Pageable pageable);

}
