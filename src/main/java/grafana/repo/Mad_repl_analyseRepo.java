package grafana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import grafana.entity.Mad_repl_analyse;
import grafana.entity.Mad_repl_analyseId;

public interface Mad_repl_analyseRepo extends JpaRepository<Mad_repl_analyse, Mad_repl_analyseId> {

}
