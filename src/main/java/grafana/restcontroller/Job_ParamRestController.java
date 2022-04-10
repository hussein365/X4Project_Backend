package grafana.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import grafana.entity.Job;
import grafana.entity.JobId;
import grafana.entity.Job_Param;
import grafana.entity.Job_paramId;
import grafana.repo.JobRepo;
import grafana.repo.Job_paramRepo;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Job_ParamRestController {

	@Autowired
	private Job_paramRepo job_paramRepo;
	
	@Autowired
	private JobRepo jobRepo;
	
	
	

	
	
	@GetMapping("/job_paramById1")
	public Job_Param findById(@RequestParam("id") int id,@RequestParam("key") String key) {
			 
		if(job_paramRepo.existsById(new Job_paramId(id, key))) {
			return job_paramRepo.findById(new Job_paramId(id, key)).get();
		}
		else {
			return null;
		}
		
	}
	
	
	
	@GetMapping("/job_paramById2")
	public 	Job_Param findById(@RequestBody Job_paramId job_paramId) {
		if(job_paramRepo.existsById(job_paramId)) {
			return job_paramRepo.findById(job_paramId).get();
		}
		else {
			return null;
		}
		
	}
	
	@DeleteMapping("/job_paramById3")
	public String deleteById(@RequestParam("id") int id,@RequestParam("key") String key) {
		
		
		if(job_paramRepo.existsById(new Job_paramId(id,key))) {
			job_paramRepo.deleteById(new Job_paramId(id, key));
	        return "Job_Param with Id= "+ id+" & key= "+ key + " succeffuly deleted";
		}
		else {
			 return "Job_Param with Id= "+ id+" & key= "+key  +
		        		 " not found";
		}
	}
	
	
	
	@PostMapping("/addorupdateJobParam")
	public Job_Param addJob_param( @RequestBody Job_Param job_param) {
		return job_paramRepo.saveAndFlush(job_param);
		
	}
	
	@PostMapping("/addJobParamFirstJob")
	public Job_Param addJob_paramfirstjob( @RequestBody Job_Param job_param) {
		if(!jobRepo.existsById(job_param.getJob().getJobId())) {
			
			Job job=this.jobRepo.save(job_param.getJob());
		}
		
		
		return job_paramRepo.save(job_param);
		
	}
	
	
	@GetMapping("/job_param")
	public Page<Job_Param>findAll(Pageable pageable){
		return job_paramRepo.findAll(pageable);
	}

	
	
	@GetMapping("/job_paramByJob")
	public Page<Job_Param> findByJob(@RequestParam("jobid") int id,Pageable pageable){
		Job job=jobRepo.findById(id);
		
		
		return job_paramRepo.findByJob(job, pageable);
		
	}
	
	@PostMapping("/deleteJobParamByJobId")
	public String deleteByJobId2(@RequestBody Job_paramId jobParamId) {
		
		if(job_paramRepo.existsById(jobParamId)) {
			job_paramRepo.deleteById(jobParamId);
	        return "Job_Param with Id= "+ jobParamId.getId()+" & key= "+ jobParamId.getKey() + " succeffuly deleted";
		}
		else {
			 return "Job_Param with Id= "+ jobParamId.getId()+" & key= "+jobParamId.getKey()  +
		        		 " not found";
		}
	}

	
}
