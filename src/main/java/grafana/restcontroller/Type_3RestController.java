
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
import grafana.entity.Type_3;
import grafana.repo.Type_3Repo;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")

public class Type_3RestController {

	@Autowired
	private Type_3Repo type_3repo;
	
	@GetMapping("/page_type_3")
	public Page<Type_3> findAll(Pageable pageable){
		
		return type_3repo.findAll(pageable);
		
	}
	
	
	@GetMapping("/type_3")
	public List<Type_3> findAllType_3(){
		
		return type_3repo.findAll();
		
	}
	
	@GetMapping("/type_3String")
	public List<String> findAllType_3String(){
		List<String> ergebnis=new ArrayList<String>();
		 for(Type_3 type_3:type_3repo.findAll()) {
			 ergebnis.add(type_3.getType3());
		 }
		
	return ergebnis;
	}
	
	
	@GetMapping("/type_3/{type_3}")
	public Type_3 findType_3ById(@PathVariable("type_3") String type_3){
		
		return type_3repo.findById(type_3).get();
	}
	
	@GetMapping("/type_3String/{type_3}")
	public String findType_3StringById(@PathVariable String type_3) {
		if(type_3repo.existsById(type_3)) {
		return type_3repo.findById(type_3).get().getType3();
		}
		else {
		return type_3+ " doesn t exist";	
		}
		}
	
	@DeleteMapping("/type_3/{type_3}")
	public String deleteType_3ById(@PathVariable String type_3) {
		String result;
	 
		if(!type_3repo.existsById(type_3)) {
			result=type_3 + "  doesnt exist";
		}
		else {
			type_3repo.deleteById(type_3);
			result=type_3 + " deleted";
		}
	return result;
	}
	
	@PostMapping("/type_3")
	public String addType_3(@RequestBody String type_3 ) {
		String result;
		
		
		if(!type_3repo.existsById(type_3)) {
			type_3repo.save(new Type_3(type_3));
			result=type_3 + " added";
		}
		else {
			result=type_3 + " already exists";
		}
		return result;
	}
}
