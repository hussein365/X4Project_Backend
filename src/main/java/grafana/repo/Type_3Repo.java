package grafana.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import grafana.entity.Type_0;
import grafana.entity.Type_3;

public interface Type_3Repo extends JpaRepository<Type_3, String> {

	Page<Type_3>findAll(Pageable pageable);

}
