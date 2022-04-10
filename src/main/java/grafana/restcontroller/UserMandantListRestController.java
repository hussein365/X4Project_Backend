package grafana.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grafana.entity.UserMandantList;
import grafana.repo.UserMandantListRepo;

@RestController
@RequestMapping("/api")
public class UserMandantListRestController {

	
	@Autowired
	private UserMandantListRepo userMandantListrepo;
	
	
	@GetMapping("/userMandantList")
	public List<UserMandantList> findAll(){
		
		return userMandantListrepo.findAll();
	}
	
	@GetMapping("/userMandantList/{id}")
	public UserMandantList findById(@PathVariable int id) {
		if(userMandantListrepo.existsById(id)) {
			return userMandantListrepo.findById(id).get();
		}
		else {
			return null;
		}
		
	}
	
	@DeleteMapping("/userMandantList/{id}")
	public String deleteById(@PathVariable int id) {
		
		
		if(userMandantListrepo.existsById(id)) {
			userMandantListrepo.deleteById(id);
	        return "User with Id= "+ id+ " succeffuly deleted";
		}
		else {
	        return "User with Id= "+ id+ " not found";
		}
	}
	
	
	
	@PostMapping("/userMandantList")
	public UserMandantList addUser( @RequestBody UserMandantList user) {
		return userMandantListrepo.save(user);
		
	}
}
