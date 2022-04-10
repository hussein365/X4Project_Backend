package grafana.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import grafana.entity.Job;
import grafana.entity.Job_Param;
import grafana.entity.Job_paramId;

public interface Job_paramRepo extends JpaRepository<Job_Param, Job_paramId> {
	
	Page<Job_Param> findAll(Pageable pageable);
	Page<Job_Param> findByJob(Job job,Pageable pageable);
	

}
