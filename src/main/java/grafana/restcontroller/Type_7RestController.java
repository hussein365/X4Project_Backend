
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
import grafana.entity.Type_7;
import grafana.repo.Type_7Repo;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")

public class Type_7RestController {

	@Autowired
	private Type_7Repo type_7repo;
	
	@GetMapping("/page_type_7")
	public Page<Type_7> findAll(Pageable pageable){
		
		return type_7repo.findAll(pageable);
		
	}
	
	
	@GetMapping("/type_7")
	public List<Type_7> findAllType_7(){
		
		return type_7repo.findAll();
		
	}
	
	@GetMapping("/type_7String")
	public List<String> findAllType_7String(){
		List<String> ergebnis=new ArrayList<String>();
		 for(Type_7 type_7:type_7repo.findAll()) {
			 ergebnis.add(type_7.getType7());
		 }
		
	return ergebnis;
	}
	
	
	@GetMapping("/type_7/{type_7}")
	public Type_7 findType_7ById(@PathVariable("type_7") String type_7){
		
		return type_7repo.findById(type_7).get();
	}
	
	@GetMapping("/type_7String/{type_7}")
	public String findType_7StringById(@PathVariable String type_7) {
		if(type_7repo.existsById(type_7)) {
		return type_7repo.findById(type_7).get().getType7();
		}
		else {
		return type_7+ " doesn t exist";	
		}
		}
	
	@DeleteMapping("/type_7/{type_7}")
	public String deleteType_7ById(@PathVariable String type_7) {
		String result;
	 
		if(!type_7repo.existsById(type_7)) {
			result=type_7 + "  doesnt exist";
		}
		else {
			type_7repo.deleteById(type_7);
			result=type_7 + " deleted";
		}
	return result;
	}
	
	@PostMapping("/type_7")
	public String addType_7(@RequestBody String type_7 ) {
		String result;
		
		
		if(!type_7repo.existsById(type_7)) {
			type_7repo.save(new Type_7(type_7));
			result=type_7 + " added";
		}
		else {
			result=type_7 + " already exists";
		}
		return result;
	}
}
