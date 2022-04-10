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

import grafana.entity.Bmx_performance_tests;
import grafana.entity.Bmx_performance_testsId;
import grafana.repo.Bmx_performance_testsRepo;

@RestController
@RequestMapping("/api")
public class Bmx_performance_testsRestController {

	
	@Autowired
	private Bmx_performance_testsRepo bmx_performance_testsRepo;
	
	@GetMapping("/bmx_performance_tests")
	public List<Bmx_performance_tests> findAll(){
		return bmx_performance_testsRepo.findAll();
	}

	
	@GetMapping("/bmx_performance_testsById1")
	public Bmx_performance_tests findById(@RequestParam("repl_type") String repl_type,@RequestParam("test") String test,
			@RequestParam("file") String file,@RequestParam("filesize") int filesize) {
			 
		if(bmx_performance_testsRepo.existsById(new Bmx_performance_testsId(repl_type, test, file, filesize))) {
			return bmx_performance_testsRepo.findById(new Bmx_performance_testsId(repl_type, test, file, filesize)).get();
		}
		else {
			return null;
		}
		
	}
	
	
	
	@GetMapping("/bmx_performance_testsById2")
	public 	Bmx_performance_tests findById(@RequestBody Bmx_performance_testsId bmx_performance_testsId) {
		if(bmx_performance_testsRepo.existsById(bmx_performance_testsId)) {
			return bmx_performance_testsRepo.findById(bmx_performance_testsId).get();
		}
		else {
			return null;
		}
		
	}
	
	@DeleteMapping("/bmx_performance_tests")
	public String deleteById(@RequestParam("repl_type") String repl_type,@RequestParam("test") String test,
			@RequestParam("file") String file,@RequestParam("filesize") int filesize) {
		
		
		if(bmx_performance_testsRepo.existsById(new Bmx_performance_testsId(repl_type, test, file, filesize))) {
			bmx_performance_testsRepo.deleteById(new Bmx_performance_testsId(repl_type, test, file, filesize));
	        return "Bmx_performance_tests with repl_type= "+ repl_type+" & test= "+ test + " & file= "+ file +
	        		" & filesize= "+ filesize + " succeffuly deleted";
		}
		else {
			 return "Bmx_performance_tests with repl_type= "+ repl_type+" & test= "+ test + " & file= "+ file +
		        		" & filesize= "+ filesize + 
		        		 " not found";
		}
	}
	
	
	
	@PostMapping("/bmx_performance_tests")
	public Bmx_performance_tests addBmx_performance_tests( @RequestBody Bmx_performance_tests bmx_performance_tests) {
		return bmx_performance_testsRepo.save(bmx_performance_tests);
		
	}
	
	
	
}
