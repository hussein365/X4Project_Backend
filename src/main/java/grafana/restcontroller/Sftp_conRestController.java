package grafana.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grafana.entity.Mandant;
import grafana.entity.Sftp_con;
import grafana.repo.Sftp_conRepo;

@RestController
@RequestMapping("/api")
public class Sftp_conRestController {

	
	@Autowired
	private Sftp_conRepo sftp_conRepo;
	
	
	@GetMapping("/sftp_con")
	public List<Sftp_con> findAll(){
		return sftp_conRepo.findAll();
	}
	
	@GetMapping("/sftp_con/{id}")
	public Sftp_con findById(@PathVariable int id) {
		if(sftp_conRepo.existsById(id)) {
			return sftp_conRepo.findById(id).get();
		}
		else {
			return null;
		}
		
	}
	
	@DeleteMapping("/sftp_con/{id}")
	public String deleteById(@PathVariable int id) {
		
		
		if(sftp_conRepo.existsById(id)) {
			sftp_conRepo.deleteById(id);
	        return "Sftp_con with Id= "+ id+ " succeffuly deleted";
		}
		else {
	        return "Sftp_con with Id= "+ id+ " not found";
		}
	}
	
	
	
	@PostMapping("/sftp_con")
	public Sftp_con addUser( @RequestBody Sftp_con sftp_con) {
		return sftp_conRepo.save(sftp_con);
		
	}
	
	
}
