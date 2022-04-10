package grafana.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import grafana.entity.Type_0;

public interface Type_0Repo extends JpaRepository<Type_0, String> {

	Page<Type_0>findAll(Pageable pageable);
}