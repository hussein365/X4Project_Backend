package grafana.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import grafana.entity.Type_0;
import grafana.entity.Type_7;



public interface Type_7Repo extends JpaRepository<Type_7, String> {

	Page<Type_7>findAll(Pageable pageable);

}
