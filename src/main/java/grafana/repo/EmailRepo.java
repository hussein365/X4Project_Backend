package grafana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import grafana.entity.Email;
import grafana.entity.EmailId;

public interface EmailRepo extends JpaRepository<Email, EmailId> {

}
