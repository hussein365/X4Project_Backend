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

import grafana.entity.Mandant;
import grafana.entity.UserMandantList;
import grafana.repo.MandantRepo;

@RestController
@RequestMapping("/api")
public class MandantRestController {

	
	@Autowired
	private MandantRepo mandantRepo;



	@GetMapping("/mandant")
	public List<Mandant> findAll(){
		return mandantRepo.findAll();
	}
	
	@GetMapping("/mandant/{id}")
	public Mandant findById(@PathVariable int id) {
		if(mandantRepo.existsById(id)) {
			return mandantRepo.findById(id).get();
		}
		else {
			return null;
		}
		
	}
	
	@DeleteMapping("/mandant/{id}")
	public String deleteById(@PathVariable int id) {
		
		
		if(mandantRepo.existsById(id)) {
			mandantRepo.deleteById(id);
	        return "Mandant with Id= "+ id+ " succeffuly deleted";
		}
		else {
	        return "Mandant with Id= "+ id+ " not found";
		}
	}
	
	
	
	@PostMapping("/mandant")
	public Mandant addUser( @RequestBody Mandant mandant) {
		return mandantRepo.save(mandant);
		
	}
	
	
	
}
