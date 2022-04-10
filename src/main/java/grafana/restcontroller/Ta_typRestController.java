package grafana.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grafana.entity.Ta_typ;
import grafana.repo.Ta_TypRepo;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class Ta_typRestController {

	
	
	@Autowired
	private Ta_TypRepo ta_typRepo;
	

	
	@GetMapping("/ta_typ")
	public List<Ta_typ> findAll(){
		return ta_typRepo.findAll() ; 
	}
	

	
	@GetMapping("/ta_typ/{id}")
	public Ta_typ findById(@PathVariable int id) {
		return ta_typRepo.findById(id);
	}
	
	@DeleteMapping("/ta_typ/{id}")
	public String deleteById(@PathVariable int id) {
		
		
		if(ta_typRepo.existsById(id)) {
			ta_typRepo.deleteById(id);
	        return "Ta_typ with Id= "+ id+ " succeffuly deleted";
		}
		else {
	        return "Ta_typ with Id= "+ id+ " not found";
		}
	}
	
	
	
	@PostMapping("/ta_typ")
	public Ta_typ addTa_typ( @RequestBody Ta_typ ta_typ) {
		return ta_typRepo.save(ta_typ);
		
	}
	@GetMapping("/page_ta_typ")
	public Page<Ta_typ> findAll(Pageable pageable){
		return ta_typRepo.findAll(pageable) ; 
	}
	
	
}
