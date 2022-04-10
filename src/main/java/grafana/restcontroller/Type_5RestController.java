
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
import grafana.entity.Type_5;
import grafana.repo.Type_5Repo;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")

public class Type_5RestController {

	@Autowired
	private Type_5Repo type_5repo;
	
	
	@GetMapping("/page_type_5")
	public Page<Type_5> findAll(Pageable pageable){
		
		return type_5repo.findAll(pageable);
		
	}
	
	@GetMapping("/type_5")
	public List<Type_5> findAllType_5(){
		
		return type_5repo.findAll();
		
	}
	
	@GetMapping("/type_5String")
	public List<String> findAllType_5String(){
		List<String> ergebnis=new ArrayList<String>();
		 for(Type_5 type_5:type_5repo.findAll()) {
			 ergebnis.add(type_5.getType5());
		 }
		
	return ergebnis;
	}
	
	
	@GetMapping("/type_5/{type_5}")
	public Type_5 findType_5ById(@PathVariable("type_5") String type_5){
		
		return type_5repo.findById(type_5).get();
	}
	
	@GetMapping("/type_5String/{type_5}")
	public String findType_5StringById(@PathVariable String type_5) {
		if(type_5repo.existsById(type_5)) {
		return type_5repo.findById(type_5).get().getType5();
		}
		else {
		return type_5+ " doesn t exist";	
		}
		}
	
	@DeleteMapping("/type_5/{type_5}")
	public String deleteType_5ById(@PathVariable String type_5) {
		String result;
	 
		if(!type_5repo.existsById(type_5)) {
			result=type_5 + "  doesnt exist";
		}
		else {
			type_5repo.deleteById(type_5);
			result=type_5 + " deleted";
		}
	return result;
	}
	
	@PostMapping("/type_5")
	public String addType_5(@RequestBody String type_5 ) {
		String result;
		
		
		if(!type_5repo.existsById(type_5)) {
			type_5repo.save(new Type_5(type_5));
			result=type_5 + " added";
		}
		else {
			result=type_5 + " already exists";
		}
		return result;
	}
}
