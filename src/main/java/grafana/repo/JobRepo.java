package grafana.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import grafana.entity.JobId;
import grafana.entity.Job;

public interface JobRepo extends JpaRepository<Job, JobId> {
	Page<Job> findAll(Pageable pageable);
	Job findById(int id);

	

    @Query(value = "SELECT id FROM job", nativeQuery = true)
    public List<Integer> findAllIds();
    
    @Query(value = "SELECT DISTINCT sftp_con FROM job", nativeQuery = true)
    public List<String> findAllConn();
	
    @Query(value = "SELECT DISTINCT email_result_file FROM job", nativeQuery = true)
    public List<String> findAllResults();
    
    @Query(value = "SELECT DISTINCT date_relativ FROM job", nativeQuery = true)
    public List<Boolean> findAlldateRelativ();
    
    @Query(value = "SELECT DISTINCT dezimal_punkt FROM job", nativeQuery = true)
    public List<String> findAlldezimalPunkt();
    
    public Page<Job>findByIdIn(List<Integer> ids,Pageable pageable);
    
    public Page<Job> findByFtpdirectory(String ftp_directory,Pageable pageable);
    public Page<Job> findByMaxfilesize(String max_file_size,Pageable pageable);
    public Page<Job> findBySftpconIn(List<String> sftp_cons,Pageable pageable);
    public Page<Job> findByFtpdirectoryAndMaxfilesize(String ftp_directory,String max_file_size,Pageable pageable);
    public Page<Job> findByFtpdirectoryAndSftpconIn(String ftp_directory,List<String> sftp_cons,Pageable pageable);
    public Page<Job> findByMaxfilesizeAndSftpconIn(String max_file_size,List<String> sftp_cons,Pageable pageable);
    public Page<Job> findByFtpdirectoryAndMaxfilesizeAndSftpconIn(String ftp_directory,String max_file_size,List<String> sftp_cons,Pageable pageable);
    
    

    public Page<Job> findByEmailresultfile(String emailresultfile,Pageable pageable);
    public Page<Job> findByDaterelativ(boolean daterelativ,Pageable pageable);
    public Page<Job> findByDezimalpunkt(String dezimalpunkt,Pageable pageable);
    public Page<Job> findByEmailresultfileAndDaterelativ(String emailresultfile,boolean daterelativ,Pageable pageable);
    public Page<Job> findByEmailresultfileAndDezimalpunkt(String emailresultfile,String dezimalpunkt,Pageable pageable);
    public Page<Job> findByDaterelativAndDezimalpunkt(boolean daterelativ,String dezimalpunkt,Pageable pageable);
    public Page<Job> findByDaterelativAndDezimalpunktAndEmailresultfile(boolean daterelativ,String dezimalpunkt,String emailresultfile,Pageable pageable);
    
    



}
