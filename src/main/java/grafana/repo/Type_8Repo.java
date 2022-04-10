package grafana.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import grafana.entity.Type_0;
import grafana.entity.Type_8;



public interface Type_8Repo extends JpaRepository<Type_8, String> {

	Page<Type_8>findAll(Pageable pageable);

}
