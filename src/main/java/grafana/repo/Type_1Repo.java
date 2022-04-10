package grafana.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import grafana.entity.Ta_typ;
import grafana.entity.Type_0;
import grafana.entity.Type_1;

public interface Type_1Repo extends JpaRepository<Type_1, String>  {

	Page<Type_1>findAll(Pageable pageable);

}
