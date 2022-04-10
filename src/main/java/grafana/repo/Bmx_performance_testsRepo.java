package grafana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import grafana.entity.Bmx_performance_tests;
import grafana.entity.Bmx_performance_testsId;

public interface Bmx_performance_testsRepo extends JpaRepository<Bmx_performance_tests, Bmx_performance_testsId> {

}
