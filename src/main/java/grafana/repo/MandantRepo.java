package grafana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import grafana.entity.Mandant;

public interface MandantRepo extends JpaRepository<Mandant, Integer> {

}
