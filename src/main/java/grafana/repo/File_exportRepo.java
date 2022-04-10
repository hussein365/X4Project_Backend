package grafana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import grafana.entity.File_export;
import grafana.entity.File_exportId;

public interface File_exportRepo extends JpaRepository<File_export,File_exportId >{

}
