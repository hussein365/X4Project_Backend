
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
import grafana.entity.Type_1;
import grafana.repo.Type_1Repo;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class Type_1RestController {

	@Autowired
	private Type_1Repo type_1repo;
	
	@GetMapping("/page_type_1")
	public Page<Type_1> findAll(Pageable pageable){
		
		return type_1repo.findAll(pageable);
		
	}
	
	
	@GetMapping("/type_1")
	public List<Type_1> findAllType_1(){
		
		return type_1repo.findAll();
		
	}
	
	@GetMapping("/type_1String")
	public List<String> findAllType_1String(){
		List<String> ergebnis=new ArrayList<String>();
		 for(Type_1 type_1:type_1repo.findAll()) {
			 ergebnis.add(type_1.getType1());
		 }
		
	return ergebnis;
	}
	
	
	@GetMapping("/type_1/{type_1}")
	public Type_1 findType_1ById(@PathVariable("type_1") String type_1){
		
		return type_1repo.findById(type_1).get();
	}
	
	@GetMapping("/type_1String/{type_1}")
	public String findType_1StringById(@PathVariable String type_1) {
		if(type_1repo.existsById(type_1)) {
		return type_1repo.findById(type_1).get().getType1();
		}
		else {
		return type_1+ " doesn t exist";	
		}
		}
	
	@DeleteMapping("/type_1/{type_1}")
	public String deleteType_1ById(@PathVariable String type_1) {
		String result;
	 
		if(!type_1repo.existsById(type_1)) {
			result=type_1 + "  doesnt exist";
		}
		else {
			type_1repo.deleteById(type_1);
			result=type_1 + " deleted";
		}
	return result;
	}
	
	@PostMapping("/type_1")
	public String addType_1(@RequestBody String type_1 ) {
		String result;
		
		
		if(!type_1repo.existsById(type_1)) {
			type_1repo.save(new Type_1(type_1));
			result=type_1 + " added";
		}
		else {
			result=type_1 + " already exists";
		}
		return result;
	}
}
