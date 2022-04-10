package grafana.restcontroller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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


import grafana.entity.JobId;
import grafana.entity.Job_JobParam;
import grafana.entity.Job;
import grafana.entity.Mad_repl_analyse;
import grafana.entity.Mad_repl_analyseId;
import grafana.repo.JobRepo;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class JobRestController {

	@Autowired
	private JobRepo jobRepo;
	
	
	



	
	@GetMapping("/jobById1")
	public Job findById(@RequestParam("name") String name,@RequestParam("mandant") String mandant,
			@RequestParam("grafana_user") String grafana_user) {
		if(jobRepo.existsById(new JobId(name, mandant, grafana_user))) {
			return jobRepo.findById(new JobId(name, mandant, grafana_user)).get();
		}
		else {
			return null;
		}
		
	}
	
	
	
	@GetMapping("/jobById2")
	public 	Job findById(@RequestBody JobId jobId) {
		if(jobRepo.existsById(jobId)) {
			return jobRepo.findById(jobId).get();
		}
		else {
			return null;
		}
		
	}
	
	@DeleteMapping("/deleteJobByJobId1")
	public String deleteByJobId1(@RequestParam("name") String name,@RequestParam("mandant") String mandant,
			@RequestParam("grafana_user") String grafana_user) {
		
		
		if(jobRepo.existsById(new JobId(name, mandant, grafana_user))) {
			jobRepo.deleteById(new JobId(name, mandant, grafana_user));
	        return "Job with Name= "+ name+" & mandant= "+mandant +" &grafana_user= "+ grafana_user +
	        		 " succeffuly deleted";
		}
		else {
			 return "Job with Name= "+ name+" & mandant= "+mandant +" &grafana_user= "+ grafana_user +
		        		 " not found";
		}
	}
	@PostMapping("/deleteJobByJobId2")
	public String deleteByJobId2(@RequestBody JobId jobId) {
		
		
		if(jobRepo.existsById(jobId)) {
			Job job = jobRepo.findById(jobId).get();
			job.setDezimalpunkt("aaaaaa");
			jobRepo.save(job);
			jobRepo.deleteById(jobId);
	        return "Job with Name= "+ jobId.getName()+" & mandant= "+jobId.getMandant()+" &grafana_user= "+ jobId.getGrafana_user()+
	        		 " succeffuly deleted";
		}
		else {
			
			 return "Job with Name= "+ jobId.getName()+" & mandant= "+jobId.getMandant() +" &grafana_user= "+ jobId.getGrafana_user() +
		        		 " not found";
		}
	}
	
	@DeleteMapping("/deleteJobById")
	public String deleteById(@RequestParam(required=false,name="id") String  id) {
		int Id = Integer.parseInt(id);
		Job job=jobRepo.findById(Id);
		if(job!=null) {
			jobRepo.delete(job);
			return "Job with id: "+Id+" succeffuly deleted";
		}
		else {
			return "Job with id: "+Id+" not found";
		}
		
	}
	
	
	@PostMapping("/addorupdateJob")
	public Job addorupdateJob( @RequestBody Job job) {
	
		return jobRepo.saveAndFlush(job);
	}
	
	
	
	
	
	@GetMapping("/job")
	public Page<Job> findAll(Pageable pageable){
		return jobRepo.findAll(pageable);
	}
	
	
	@GetMapping("/jobById")
	public Job findById(@RequestParam("id") int id) {
		return jobRepo.findById(id);
	}
	
	@GetMapping("/allIds")
	public List<Integer> findAllIds(){
		return jobRepo.findAllIds();
	}
	@GetMapping("/allResults")
	public List<String> findAllResults(){
		return jobRepo.findAllResults();
	}
	
	@GetMapping("/allConn")
	public List<String> findAllConn(){
		return jobRepo.findAllConn();
	}
	@GetMapping("/allDeziPunkt")
	public List<String> findAllDezimalpunkt(){
		List<String> result=jobRepo.findAlldezimalPunkt();
		result.removeAll(Collections.singleton(null));
		
		return result;
	}
	
	@GetMapping("/allDateRelativ")
	public List<Boolean> findAllDateRelativ(){

		List<Boolean> result=jobRepo.findAlldateRelativ();
		result.removeAll(Collections.singleton(null));
		
		return result;
	}
	@PostMapping("/page_job_by_ids")
	public Page<Job> findByIds(@RequestBody Integer[] ids,Pageable pageable){
		return jobRepo.findByIdIn(Arrays.asList(ids), pageable);
		
	}
	@GetMapping("/page_find_by_ftp_directory")
	public Page<Job> findByFtp(@RequestParam(required=false,name="ftp_directory") String ftp_directory ,Pageable pageable){
		
		return jobRepo.findByFtpdirectory(ftp_directory,pageable);
		
	}
	@GetMapping("/page_find_by_max_file_size")
	public Page<Job> findBysize(@RequestParam(required=false,name="max_file_size") String size ,Pageable pageable){
		
		return jobRepo.findByMaxfilesize(size,pageable);
		
	}
	
	@PostMapping("/page_find_by_sftp_cons")
	public Page<Job> findByConn(@RequestBody String[] conns ,Pageable pageable){
		
		return jobRepo.findBySftpconIn(Arrays.asList(conns), pageable);
		
	}
	@GetMapping("/page_find_by_ftp_directory_and_max_file_size")
	public Page<Job> findByFtpAndSize(@RequestParam(required=false,name="ftp_directory") String ftp_directory ,@RequestParam(required=false,name="max_file_size") String max_file_size, Pageable pageable){
		
		return jobRepo.findByFtpdirectoryAndMaxfilesize(ftp_directory, max_file_size, pageable);
		
	}
	@PostMapping("/page_find_by_ftp_directory_and_conns")
	public Page<Job> findByFtpAndConns(@RequestBody String[] conns,@RequestParam(required=false,name="ftp_directory") String ftp_directory , Pageable pageable){
		
		return jobRepo.findByFtpdirectoryAndSftpconIn(ftp_directory, Arrays.asList(conns), pageable);
		
	}
	@PostMapping("/page_find_by_max_file_size_and_conns")
	public Page<Job> findBySizeAndConns(@RequestBody String[] conns,@RequestParam(required=false,name="max_file_size") String max_file_size , Pageable pageable){
		
		return jobRepo.findByMaxfilesizeAndSftpconIn(max_file_size, Arrays.asList(conns), pageable);
		
	}
	@PostMapping("/page_find_by_max_file_size_and_ftp_directory_and_conns")
	public Page<Job> findByFtpAndSizeAndConns(@RequestBody String[] conns,@RequestParam(required=false,name="max_file_size") String max_file_size,@RequestParam(required=false,name="ftp_directory") String ftp_directory  , Pageable pageable){
		
		return jobRepo.findByFtpdirectoryAndMaxfilesizeAndSftpconIn(ftp_directory, max_file_size, Arrays.asList(conns), pageable);
		
	}
	@GetMapping("/page_find_by_emailresultfile")
	public Page<Job> findByemailresultfile(@RequestParam(required=false,name="emailresultfile") String emailresultfile ,Pageable pageable){
		
		return jobRepo.findByEmailresultfile(emailresultfile,pageable);
		
	}
	@GetMapping("/page_find_by_daterelativ")
	public Page<Job> findBydaterelativ(@RequestParam(required=false,name="daterelativ") String daterelativ ,Pageable pageable){
		
		if(daterelativ.equals("absolute")) {
			return jobRepo.findByDaterelativ(false,pageable);

		}
		if(daterelativ.equals("relative")) {
			return jobRepo.findByDaterelativ(true,pageable);

		}
		else {
			return null;
		}
		
	}
	@GetMapping("/page_find_by_dezimalpunkt")
	public Page<Job> findBydezimalpunkt(@RequestParam(required=false,name="dezimalpunkt") String dezimalpunkt ,Pageable pageable){
		
		return jobRepo.findByDezimalpunkt(dezimalpunkt,pageable);
		
	}
	@GetMapping("/page_find_by_emailresultfile_and_daterelativ")
	public Page<Job> findByemailresultfileanddaterelativ(@RequestParam(required=false,name="daterelativ") String daterelativ,@RequestParam(required=false,name="emailresultfile") String emailresultfile ,Pageable pageable){
		
		if(daterelativ.equals("absolute")) {
			return jobRepo.findByEmailresultfileAndDaterelativ(emailresultfile, false, pageable);

		}
		if(daterelativ.equals("relative")) {
			return jobRepo.findByEmailresultfileAndDaterelativ(emailresultfile, true, pageable);

		}
		else {
			return null;
		}
		
	}
	@GetMapping("/page_find_by_emailresultfile_and_dezimalpunkt")
	public Page<Job> findByemailresultfileanddezimalpunkt(@RequestParam(required=false,name="emailresultfile") String emailresultfile,@RequestParam(required=false,name="dezimalpunkt") String dezimalpunkt ,Pageable pageable){
		
		return jobRepo.findByEmailresultfileAndDezimalpunkt(emailresultfile,dezimalpunkt,pageable);
		
	}
	@GetMapping("/page_find_by_dezimalpunkt_and_daterelativ")
	public Page<Job> findBydezimalanddaterelativ(@RequestParam(required=false,name="daterelativ") String daterelativ,@RequestParam(required=false,name="dezimalpunkt") String dezimalpunkt,Pageable pageable){
		

		if(daterelativ.equals("absolute")) {
			return jobRepo.findByDaterelativAndDezimalpunkt(false, dezimalpunkt, pageable);

		}
		if(daterelativ.equals("relative")) {
			return jobRepo.findByDaterelativAndDezimalpunkt(true, dezimalpunkt, pageable);

		}
		else {
			return null;
		}
	}
	@GetMapping("/page_find_by_emailresultfile_and_daterelativ_and_dezimalpunkt")
	public Page<Job> findByemailresultfileanddaterelativanddezimalpunkt(@RequestParam(required=false,name="daterelativ") String daterelativ,@RequestParam(required=false,name="emailresultfile") String emailresultfile,@RequestParam(required=false,name="dezimalpunkt") String dezimalpunkt ,Pageable pageable){
		
		if(daterelativ.equals("absolute")) {
			return jobRepo.findByDaterelativAndDezimalpunktAndEmailresultfile(false, dezimalpunkt, emailresultfile, pageable);

		}
		if(daterelativ.equals("relative")) {
			return jobRepo.findByDaterelativAndDezimalpunktAndEmailresultfile(true, dezimalpunkt, emailresultfile, pageable);

		}
		else {
			return null;
		}		
	}
	
	
	@GetMapping("/page_find_by_batchjob_name")
	public List<Job> findByBatchjobname(@RequestParam(required=false,name="name") String batchjobName){
		List<Job> jobs=jobRepo.findAll();
		List<Job> result = new ArrayList<Job>();
		for(Job job:jobs) {
			if(job.getJobId().getName().equals(batchjobName)) {
			result.add(job);
			}
		}
		return  result;
	}
	
	
	//API to do
	@PostMapping("/addJobWithParam")
	public Job addJobWithParam(@RequestBody Job_JobParam job_jobparam ) {
		
		
		
		return null;
	}
	
}
