package grafana.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import grafana.entity.Type_0;
import grafana.entity.Type_2;

public interface Type_2Repo extends JpaRepository<Type_2 , String> {

	Page<Type_2>findAll(Pageable pageable);

}
