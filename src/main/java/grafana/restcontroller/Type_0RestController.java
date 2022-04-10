
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
import grafana.repo.Type_0Repo;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class Type_0RestController {

	@Autowired
	private Type_0Repo type_0repo;
	
	@GetMapping("/page_type_0")
	public Page<Type_0> findAll(Pageable pageable){
		
		return type_0repo.findAll(pageable);
		
	}
	
	@GetMapping("/type_0")
	public List<Type_0> findAllType_0(){
		
		return type_0repo.findAll();
		
	}
	
	@GetMapping("/type_0String")
	public List<String> findAllType_0String(){
		List<String> ergebnis=new ArrayList<String>();
		 for(Type_0 type_0:type_0repo.findAll()) {
			 ergebnis.add(type_0.getType0());
		 }
		
	return ergebnis;
	}
	
	
	@GetMapping("/type_0/{type_0}")
	public Type_0 findType_0ById(@PathVariable("type_0") String type_0){
		
		return type_0repo.findById(type_0).get();
	}
	
	@GetMapping("/type_0String/{type_0}")
	public String findType_0StringById(@PathVariable String type_0) {
		
		return type_0repo.findById(type_0).get().getType0();
	}
	
	@DeleteMapping("/type_0/{type_0}")
	public String deleteType_0ById(@PathVariable String type_0) {
		String result;
	  Type_0 theType_0 =type_0repo.findById(type_0).get();
		if(theType_0==null) {
			result=type_0 + "  doesnt exist";
		}
		else {
			type_0repo.deleteById(type_0);
			result=type_0 + " deleted";
		}
	return result;
	}
	
	@PostMapping("/type_0")
	public Type_0 addType_0(@RequestBody Type_0 type_0 ) {
		
			type_0repo.save(type_0);
		
		return type_0;
}
}
