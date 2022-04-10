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
import grafana.entity.Type_2;

import grafana.repo.Type_2Repo;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")

public class Type_2RestController {

	
	@Autowired 
	private Type_2Repo type_2repo;
	
	
	@GetMapping("/page_type_2")
	public Page<Type_2> findAll(Pageable pageable){
		
		return type_2repo.findAll(pageable);
		
	}
	
	@GetMapping("/type_2")
	public List<Type_2> findAllType_2(){
		
		return type_2repo.findAll();
		
	}
	
	@GetMapping("/type_2String")
	public List<String> findAllType_2String(){
		List<String> ergebnis=new ArrayList<String>();
		 for(Type_2 type_2:type_2repo.findAll()) {
			 ergebnis.add(type_2.getType2());
		 }
		
	return ergebnis;
	}
	
	
	@GetMapping("/type_2/{type_2}")
	public Type_2 findType_2ById(@PathVariable("type_2") String type_2){
		
		return type_2repo.findById(type_2).get();
	}
	
	@GetMapping("/type_2String/{type_2}")
	public String findType_2StringById(@PathVariable String type_2) {
		if(type_2repo.existsById(type_2)) {
		return type_2repo.findById(type_2).get().getType2();
		}
		else {
		return type_2+ " doesn t exist";	
		}
		}
	
	@DeleteMapping("/type_2/{type_2}")
	public String deleteType_2ById(@PathVariable String type_2) {
		String result;
	 
		if(!type_2repo.existsById(type_2)) {
			result=type_2 + "  doesnt exist";
		}
		else {
			type_2repo.deleteById(type_2);
			result=type_2 + " deleted";
		}
	return result;
	}
	
	@PostMapping("/type_2")
	public String addType_2(@RequestBody String type_2 ) {
		String result;
		
		
		if(!type_2repo.existsById(type_2)) {
			type_2repo.save(new Type_2(type_2));
			result=type_2 + " added";
		}
		else {
			result=type_2 + " already exists";
		}
		return result;
	}
	
	
}
