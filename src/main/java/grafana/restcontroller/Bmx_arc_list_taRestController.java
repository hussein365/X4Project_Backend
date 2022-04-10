package grafana.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grafana.entity.Bmx_arclist_ta;
import grafana.entity.Sftp_con;
import grafana.repo.Bmx_arclist_taRepo;

@RestController
@RequestMapping("/api")
public class Bmx_arc_list_taRestController {
	
	
	@Autowired
	private Bmx_arclist_taRepo bmx_arclist_taRepo;
	
	
	
	@GetMapping("/bmx_arclist_ta")
	public List<Bmx_arclist_ta> findAll(){
		return  bmx_arclist_taRepo.findAll();
	}
	
	@GetMapping("/bmx_arclist_ta/{id}")
	public Bmx_arclist_ta findById(@PathVariable int id) {
		if(bmx_arclist_taRepo.existsById(id)) {
			return bmx_arclist_taRepo.findById(id).get();
		}
		else {
			return null;
		}
		
	}
	
	@DeleteMapping("/bmx_arclist_ta/{id}")
	public String deleteById(@PathVariable int id) {
		
		
		if(bmx_arclist_taRepo.existsById(id)) {
			bmx_arclist_taRepo.deleteById(id);
	        return "Bmx_arclist_ta with Id= "+ id+ " succeffuly deleted";
		}
		else {
	        return "Bmx_arclist_ta with Id= "+ id+ " not found";
		}
	}
	
	
	
	@PostMapping("/bmx_arclist_ta")
	public Bmx_arclist_ta addBmx_arclist_ta( @RequestBody Bmx_arclist_ta bmx_arclist_ta) {
		return bmx_arclist_taRepo.save(bmx_arclist_ta);
		
	}
	
	
	
	

}
