package grafana.restcontroller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import grafana.entity.Mad_repl_analyse;
import grafana.entity.Mad_repl_analyseId;
import grafana.repo.Mad_repl_analyseRepo;

@RestController
@RequestMapping("/api")
public class Mad_repl_analyseRestController {

	
	@Autowired
	private Mad_repl_analyseRepo mad_repl_analyseRepo;
	
	
	@GetMapping("/mad_repl_analyse")
	public List<Mad_repl_analyse> findAll(){
		return mad_repl_analyseRepo.findAll();
	}

	
	@GetMapping("/mad_repl_analyseById1")
	public Mad_repl_analyse findById(@RequestParam("process") int process,@RequestParam("lastmodified") BigInteger lastmodified,
			@RequestParam("filesize") BigInteger filesize,@RequestParam("file")String file) {
		if(mad_repl_analyseRepo.existsById(new Mad_repl_analyseId(process, lastmodified, filesize, file))) {
			return mad_repl_analyseRepo.findById(new Mad_repl_analyseId(process, lastmodified, filesize, file)).get();
		}
		else {
			return null;
		}
		
	}
	
	
	
	@GetMapping("/mad_repl_analyseById2")
	public Mad_repl_analyse findById(@RequestBody Mad_repl_analyseId mad_repl_analyseId) {
		if(mad_repl_analyseRepo.existsById(mad_repl_analyseId)) {
			return mad_repl_analyseRepo.findById(mad_repl_analyseId).get();
		}
		else {
			return null;
		}
		
	}
	
	@DeleteMapping("/mad_repl_analyseById")
	public String deleteById(@RequestParam("process") int process,@RequestParam("lastmodified") BigInteger lastmodified,
			@RequestParam("filesize") BigInteger filesize,@RequestParam("file")String file) {
		
		
		if(mad_repl_analyseRepo.existsById(new Mad_repl_analyseId(process, lastmodified, filesize, file))) {
			mad_repl_analyseRepo.deleteById(new Mad_repl_analyseId(process, lastmodified, filesize, file));
	        return "Mad_repl_analyse with Process= "+ process+" & lastmodified= "+lastmodified +" &filesize= "+ filesize +
	        		" &file= "+ file + " succeffuly deleted";
		}
		else {
			 return "Mad_repl_analyse with Process= "+ process+" & lastmodified= "+lastmodified +" &filesize= "+ filesize +
		        		" &file= "+ file + " not found";
		}
	}
	
	
	
	@PostMapping("/mad_repl_analyse")
	public Mad_repl_analyse addServer_param( @RequestBody Mad_repl_analyse mad_repl_analyse) {
		return mad_repl_analyseRepo.save(mad_repl_analyse);
		
	}
	
	
	
	
	
	
	
}
