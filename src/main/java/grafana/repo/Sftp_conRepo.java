package grafana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import grafana.entity.Sftp_con;

public interface Sftp_conRepo extends JpaRepository<Sftp_con, Integer> {

}
