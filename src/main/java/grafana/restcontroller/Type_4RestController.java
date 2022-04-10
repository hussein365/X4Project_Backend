
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
import grafana.entity.Type_4;
import grafana.repo.Type_4Repo;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")

public class Type_4RestController {

	@Autowired
	private Type_4Repo type_4repo;
	
	@GetMapping("/page_type_4")
	public Page<Type_4> findAll(Pageable pageable){
		
		return type_4repo.findAll(pageable);
		
	}
	
	
	@GetMapping("/type_4")
	public List<Type_4> findAllType_4(){
		
		return type_4repo.findAll();
		
	}
	
	@GetMapping("/type_4String")
	public List<String> findAllType_4String(){
		List<String> ergebnis=new ArrayList<String>();
		 for(Type_4 type_4:type_4repo.findAll()) {
			 ergebnis.add(type_4.getType4());
		 }
		
	return ergebnis;
	}
	
	
	@GetMapping("/type_4/{type_4}")
	public Type_4 findType_4ById(@PathVariable("type_4") String type_4){
		
		return type_4repo.findById(type_4).get();
	}
	
	@GetMapping("/type_4String/{type_4}")
	public String findType_4StringById(@PathVariable String type_4) {
		if(type_4repo.existsById(type_4)) {
		return type_4repo.findById(type_4).get().getType4();
		}
		else {
		return type_4+ " doesn t exist";	
		}
		}
	
	@DeleteMapping("/type_4/{type_4}")
	public String deleteType_4ById(@PathVariable String type_4) {
		String result;
	 
		if(!type_4repo.existsById(type_4)) {
			result=type_4 + "  doesnt exist";
		}
		else {
			type_4repo.deleteById(type_4);
			result=type_4 + " deleted";
		}
	return result;
	}
	
	@PostMapping("/type_4")
	public String addType_4(@RequestBody String type_4 ) {
		String result;
		
		
		if(!type_4repo.existsById(type_4)) {
			type_4repo.save(new Type_4(type_4));
			result=type_4 + " added";
		}
		else {
			result=type_4 + " already exists";
		}
		return result;
	}
}
