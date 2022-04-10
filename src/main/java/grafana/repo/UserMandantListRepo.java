package grafana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import grafana.entity.UserMandantList;

public interface UserMandantListRepo extends JpaRepository<UserMandantList, Integer> {

}
