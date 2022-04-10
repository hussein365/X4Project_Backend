package grafana.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import grafana.entity.File_export;
import grafana.entity.File_exportId;
import grafana.entity.Job_Param;
import grafana.entity.Job_paramId;
import grafana.repo.File_exportRepo;

@RestController
@RequestMapping("/api")
public class File_exportRestController {

	
	@Autowired
	private File_exportRepo file_exportRepo;
	
	

	@GetMapping("/file_export")
	public List<File_export> findAll(){
		return file_exportRepo.findAll();
	}

	
	@GetMapping("/file_exportById1")
	public File_export findById(@RequestParam("key") String key,@RequestParam("last_filename") String last_filename) {
			 
		if(file_exportRepo.existsById(new File_exportId(key, last_filename))) {
			return file_exportRepo.findById(new File_exportId(key, last_filename)).get();
		}
		else {
			return null;
		}
		
	}
	
	
	
	@GetMapping("/file_exportById2")
	public 	File_export findById(@RequestBody File_exportId file_exportId) {
		if(file_exportRepo.existsById(file_exportId)) {
			return file_exportRepo.findById(file_exportId).get();
		}
		else {
			return null;
		}
		
	}
	
	@DeleteMapping("/file_exportById")
	public String deleteById(@RequestParam("key") String key,@RequestParam("last_filename") String last_filename) {
		
		
		if(file_exportRepo.existsById(new File_exportId(key,last_filename))) {
			file_exportRepo.deleteById(new File_exportId(key, last_filename));
	        return "File_export with Key= "+ key+" & last_filename= "+ last_filename + " succeffuly deleted";
		}
		else {
			 return "File_export with Key= "+ key+" & last_filename= "+last_filename  +
		        		 " not found";
		}
	}
	
	
	
	@PostMapping("/file_export")
	public File_export addFile_export( @RequestBody File_export file_export) {
		return file_exportRepo.save(file_export);
		
	}
	
	
	
	
	
	
	
}
