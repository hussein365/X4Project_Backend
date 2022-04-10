
package grafana.restcontroller;

import java.util.ArrayList;
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

import grafana.entity.Type_0;
import grafana.entity.Type_6;
import grafana.repo.Type_6Repo;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")

public class Type_6RestController {

	@Autowired
	private Type_6Repo type_6repo;
	
	@GetMapping("/page_type_6")
	public Page<Type_6> findAll(Pageable pageable){
		
		return type_6repo.findAll(pageable);
		
	}
	
	
	@GetMapping("/type_6")
	public List<Type_6> findAllType_6(){
		
		return type_6repo.findAll();
		
	}
	
	@GetMapping("/type_6String")
	public List<String> findAllType_6String(){
		List<String> ergebnis=new ArrayList<String>();
		 for(Type_6 type_6:type_6repo.findAll()) {
			 ergebnis.add(type_6.getType6());
		 }
		
	return ergebnis;
	}
	
	
	@GetMapping("/type_6/{type_6}")
	public Type_6 findType_6ById(@PathVariable("type_6") String type_6){
		
		return type_6repo.findById(type_6).get();
	}
	
	@GetMapping("/type_6String/{type_6}")
	public String findType_6StringById(@PathVariable String type_6) {
		if(type_6repo.existsById(type_6)) {
		return type_6repo.findById(type_6).get().getType6();
		}
		else {
		return type_6+ " doesn t exist";	
		}
		}
	
	@DeleteMapping("/type_6/{type_6}")
	public String deleteType_6ById(@PathVariable String type_6) {
		String result;
	 
		if(!type_6repo.existsById(type_6)) {
			result=type_6 + "  doesnt exist";
		}
		else {
			type_6repo.deleteById(type_6);
			result=type_6 + " deleted";
		}
	return result;
	}
	
	@PostMapping("/type_6")
	public String addType_6(@RequestBody String type_6 ) {
		String result;
		
		
		if(!type_6repo.existsById(type_6)) {
			type_6repo.save(new Type_6(type_6));
			result=type_6 + " added";
		}
		else {
			result=type_6 + " already exists";
		}
		return result;
	}
}
