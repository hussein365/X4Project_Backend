package grafana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import grafana.entity.Arc_repl_analyse;
import grafana.entity.Arc_repl_analyseId;

public interface Arc_repl_analyseRepo extends JpaRepository<Arc_repl_analyse, Arc_repl_analyseId> {

}
