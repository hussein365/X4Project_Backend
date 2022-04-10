package grafana.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import grafana.entity.Email;
import grafana.entity.EmailId;
import grafana.entity.File_export;
import grafana.entity.File_exportId;
import grafana.repo.EmailRepo;

@RestController
@RequestMapping("/api")
public class EmailRestController {

	
	@Autowired
	private EmailRepo emailRepo;
	
	

	@GetMapping("/email")
	public List<Email> findAll(){
		return emailRepo.findAll();
	}

	
	@GetMapping("/emailById1")
	public Email findById(@RequestParam("grafana_user") String grafana_user,@RequestParam("email") String email) {
			 
		if(emailRepo.existsById(new EmailId(grafana_user,email))) {
			return emailRepo.findById(new EmailId(grafana_user,email)).get();
		}
		else {
			return null;
		}
		
	}
	
	
	
	@GetMapping("/emailById2")
	public 	Email findById(@RequestBody EmailId emailId) {
		if(emailRepo.existsById(emailId)) {
			return emailRepo.findById(emailId).get();
		}
		else {
			return null;
		}
		
	}
	
	@DeleteMapping("/emailById")
	public String deleteById(@RequestParam("grafana_user") String grafana_user,@RequestParam("email") String email) {
		
		
		if(emailRepo.existsById(new EmailId(grafana_user,email))) {
			emailRepo.deleteById(new EmailId(grafana_user,email));
	        return "Email with Grafana_user= "+ grafana_user+" & email= "+ email + " succeffuly deleted";
		}
		else {
			 return "Email with Grafana_user= "+ grafana_user+" & emial= "+email  +
		        		 " not found";
		}
	}
	
	
	
	@PostMapping("/email")
	public Email addEmail( @RequestBody Email email) {
		return emailRepo.save(email);
		
	}
	
	
	
	
	
	
	
	
	
}
