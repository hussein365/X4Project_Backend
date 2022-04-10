package grafana.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import grafana.entity.Ta_typ;

public interface Ta_TypRepo extends JpaRepository<Ta_typ, Integer> {

	Page<Ta_typ> findAll(Pageable pageable);
	Ta_typ findById(int id);
	
}
