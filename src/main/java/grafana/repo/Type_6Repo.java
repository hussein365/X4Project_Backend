package grafana.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import grafana.entity.Type_0;
import grafana.entity.Type_6;



public interface Type_6Repo extends JpaRepository<Type_6, String> {

	Page<Type_6>findAll(Pageable pageable);

}
