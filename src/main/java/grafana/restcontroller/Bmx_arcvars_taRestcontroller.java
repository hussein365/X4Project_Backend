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

import grafana.entity.Bmx_arcvars_ta;
import grafana.entity.Bmx_arcvars_taId;
import grafana.entity.Email;
import grafana.entity.EmailId;
import grafana.repo.Bmx_arcvars_taRepo;

@RestController
@RequestMapping("/api")
public class Bmx_arcvars_taRestcontroller {

	
	@Autowired
	private Bmx_arcvars_taRepo bmx_arcvars_taRepo;
	
	
	

	@GetMapping("/bmx_arcvars_ta")
	public List<Bmx_arcvars_ta> findAll(){
		return bmx_arcvars_taRepo.findAll();
	}

	
	@GetMapping("/bmx_arcvars_taById1")
	public Bmx_arcvars_ta findById(@RequestParam("tid") int tid,@RequestParam("av") int av
			                          ,@RequestParam("fk_arc") int fk_arc,@RequestParam("cycle") int cycle ) {
			 
		if(bmx_arcvars_taRepo.existsById(new Bmx_arcvars_taId(tid, av, fk_arc, cycle))) {
			return bmx_arcvars_taRepo.findById(new Bmx_arcvars_taId(tid, av, fk_arc, cycle)).get();
		}
		else {
			return null;
		}
		
	}
	
	
	
	@GetMapping("/bmx_arcvars_taById2")
	public 	Bmx_arcvars_ta findById(@RequestBody Bmx_arcvars_taId bmx_arcvars_taId) {
		if(bmx_arcvars_taRepo.existsById(bmx_arcvars_taId)) {
			return bmx_arcvars_taRepo.findById(bmx_arcvars_taId).get();
		}
		else {
			return null;
		}
		
	}
	
	@DeleteMapping("/bmx_arcvars_taById")
	public String deleteById(@RequestParam("tid") int tid,@RequestParam("av") int av
            ,@RequestParam("fk_arc") int fk_arc,@RequestParam("cycle") int cycle) {
		
		
		if(bmx_arcvars_taRepo.existsById(new Bmx_arcvars_taId(tid, av, fk_arc, cycle))) {
			bmx_arcvars_taRepo.deleteById(new Bmx_arcvars_taId(tid, av, fk_arc, cycle));
	        return "Bmx_arcvars_ta with tid= "+ tid+" & av= "+ av+
	        		" fk_arc= "+ fk_arc+" & cycle= "+ cycle +  " succeffuly deleted";
		}
		else {
			 return "Bmx_arcvars_ta with tid= "+ tid+" & av= "+ av+
		        		" fk_arc= "+ fk_arc+" & cycle= "+ cycle +
		        		 " not found";
		}
	}
	
	
	
	@PostMapping("/bmx_arcvars_ta")
	public Bmx_arcvars_ta addBmx_arcvars_ta( @RequestBody Bmx_arcvars_ta bmx_arcvars_ta) {
		return bmx_arcvars_taRepo.save(bmx_arcvars_ta);
		
	}
	
	
	
	
	
	
	
}
