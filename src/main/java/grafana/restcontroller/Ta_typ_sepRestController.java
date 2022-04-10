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

import grafana.entity.Ta_typ_sep;
import grafana.entity.UserMandantList;
import grafana.repo.Ta_typ_sepRepo;

@RestController
@RequestMapping("/api")
public class Ta_typ_sepRestController {

	
	@Autowired
	private Ta_typ_sepRepo ta_typ_sepRepo;


	@GetMapping("/ta_typ_sep")
	public List<Ta_typ_sep> findAll(){
		
		return ta_typ_sepRepo.findAll();
	}
	
	@GetMapping("/ta_typ_sep/{id}")
	public Ta_typ_sep findById(@PathVariable int id) {
		if(ta_typ_sepRepo.existsById(id)) {
			return ta_typ_sepRepo.findById(id).get();
		}
		else {
			return null;
		}
		
	}
	
	@DeleteMapping("/ta_typ_sep/{id}")
	public String deleteById(@PathVariable int id) {
		
		
		if(ta_typ_sepRepo.existsById(id)) {
		ta_typ_sepRepo.deleteById(id);
	        return "Ta_typ_sep with Id= "+ id+ " succeffuly deleted";
		}
		else {
	        return "Ta_typ_sep with Id= "+ id+ " not found";
		}
	}
	
	
	
	@PostMapping("/ta_typ_sep")
	public Ta_typ_sep addTa_typ_sep( @RequestBody Ta_typ_sep ta_typ_sep) {
		return ta_typ_sepRepo.save(ta_typ_sep);
		
	}

}
