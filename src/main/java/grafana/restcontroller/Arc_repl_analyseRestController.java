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

import grafana.entity.Arc_repl_analyse;
import grafana.entity.Arc_repl_analyseId;
import grafana.entity.Bmx_performance_tests;
import grafana.repo.Arc_repl_analyseRepo;

@RestController
@RequestMapping("/api")
public class Arc_repl_analyseRestController {

	
	@Autowired
	private Arc_repl_analyseRepo arc_repl_analyseRepo;
	
	@GetMapping("/arc_repl_analyse")
	public List<Arc_repl_analyse> findAll(){
		return arc_repl_analyseRepo.findAll();
	}

	
	@GetMapping("/arc_repl_analyseById1")
	public Arc_repl_analyse findById(@RequestParam("archivnummer") int archivnummer,@RequestParam("rowcount") int rowcount,
			@RequestParam("file") String file) {
			 
		if(arc_repl_analyseRepo.existsById(new Arc_repl_analyseId(archivnummer, rowcount, file))) {
			return arc_repl_analyseRepo.findById(new Arc_repl_analyseId(archivnummer, rowcount, file)).get();
		}
		else {
			return null;
		}
		
	}
	
	
	
	@GetMapping("/arc_repl_analyseById2")
	public 	Arc_repl_analyse findById(@RequestBody Arc_repl_analyseId arc_repl_analyseId) {
		if(arc_repl_analyseRepo.existsById(arc_repl_analyseId)) {
			return arc_repl_analyseRepo.findById(arc_repl_analyseId).get();
		}
		else {
			return null;
		}
		
	}
	
	@DeleteMapping("/arc_repl_analyse")
	public String deleteById(@RequestParam("archivnummer") int archivnummer,@RequestParam("rowcount") int rowcount,
			@RequestParam("file") String file) {
		
		
		if(arc_repl_analyseRepo.existsById(new Arc_repl_analyseId(archivnummer,rowcount,file))) {
			arc_repl_analyseRepo.deleteById(new Arc_repl_analyseId(archivnummer,rowcount,file));
	        return "Arc_repl_analyse with archivnummer= "+ archivnummer+" & rowcount= "+ rowcount + " & file= "+ file +  " succeffuly deleted";
		}
		else {
			 return "Arc_repl_anaylse with archivnummer= "+ archivnummer+" & rowcount= "+ rowcount + " & file= "+ file +
		        		 " not found";
		}
	}
	
	
	
	@PostMapping("/arc_repl_analyse")
	public Arc_repl_analyse addArc_repl_Analyse( @RequestBody Arc_repl_analyse arc_repl_analyse) {
		return arc_repl_analyseRepo.save(arc_repl_analyse);
		
	}
	
	
	
	
	
	
}
