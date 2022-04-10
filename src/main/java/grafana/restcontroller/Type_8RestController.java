
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
import grafana.entity.Type_8;
import grafana.repo.Type_8Repo;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")

public class Type_8RestController {

	@Autowired
	private Type_8Repo type_8repo;
	
	@GetMapping("/page_type_8")
	public Page<Type_8> findAll(Pageable pageable){
		
		return type_8repo.findAll(pageable);
		
	}
	
	
	@GetMapping("/type_8")
	public List<Type_8> findAllType_8(){
		
		return type_8repo.findAll();
		
	}
	
	@GetMapping("/type_8String")
	public List<String> findAllType_8String(){
		List<String> ergebnis=new ArrayList<String>();
		 for(Type_8 type_8:type_8repo.findAll()) {
			 ergebnis.add(type_8.getType8());
		 }
		
	return ergebnis;
	}
	
	
	@GetMapping("/type_8/{type_8}")
	public Type_8 findType_8ById(@PathVariable("type_8") String type_8){
		
		return type_8repo.findById(type_8).get();
	}
	
	@GetMapping("/type_8String/{type_8}")
	public String findType_8StringById(@PathVariable String type_8) {
		if(type_8repo.existsById(type_8)) {
		return type_8repo.findById(type_8).get().getType8();
		}
		else {
		return type_8+ " doesn t exist";	
		}
		}
	
	@DeleteMapping("/type_8/{type_8}")
	public String deleteType_8ById(@PathVariable String type_8) {
		String result;
	 
		if(!type_8repo.existsById(type_8)) {
			result=type_8 + "  doesnt exist";
		}
		else {
			type_8repo.deleteById(type_8);
			result=type_8 + " deleted";
		}
	return result;
	}
	
	@PostMapping("/type_8")
	public String addType_8(@RequestBody String type_8 ) {
		String result;
		
		
		if(!type_8repo.existsById(type_8)) {
			type_8repo.save(new Type_8(type_8));
			result=type_8 + " added";
		}
		else {
			result=type_8 + " already exists";
		}
		return result;
	}
}
