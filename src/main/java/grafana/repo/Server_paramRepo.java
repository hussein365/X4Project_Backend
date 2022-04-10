package grafana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import grafana.entity.Server_ParamId;
import grafana.entity.Server_param;

public interface Server_paramRepo extends JpaRepository<Server_param, Server_ParamId>{

}
