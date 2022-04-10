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

import grafana.entity.Server_ParamId;
import grafana.entity.Server_param;
import grafana.entity.Sftp_con;
import grafana.repo.Server_paramRepo;

@RestController
@RequestMapping("/api")
public class Server_ParamRestController {

	
	@Autowired
	private Server_paramRepo server_paramRepo;


	
	@GetMapping("/server_param")
	public List<Server_param> findAll(){
		return server_paramRepo.findAll();
	}

	
	@GetMapping("/server_paramById1")
	public Server_param findById(@RequestParam("id") int id,@RequestParam("key") String key) {
		if(server_paramRepo.existsById(new Server_ParamId(id, key))) {
			return server_paramRepo.findById(new Server_ParamId(id, key)).get();
		}
		else {
			return null;
		}
		
	}
	
	
	
	@GetMapping("/server_paramById2")
	public Server_param findById(@RequestBody Server_ParamId server_ParamId) {
		if(server_paramRepo.existsById(server_ParamId)) {
			return server_paramRepo.findById(server_ParamId).get();
		}
		else {
			return null;
		}
		
	}
	
	@DeleteMapping("/server_paramById")
	public String deleteById(@RequestParam("id") int id,@RequestParam("key") String key) {
		
		
		if(server_paramRepo.existsById(new Server_ParamId(id, key))) {
			server_paramRepo.deleteById(new Server_ParamId(id, key));
	        return "Server_param with Id= "+ id+" and key= "+key + " succeffuly deleted";
		}
		else {
	        return "Server_param with Id= "+ id+" and key= "+key + " not found";
		}
	}
	
	
	
	@PostMapping("/server_param")
	public Server_param addServer_param( @RequestBody Server_param server_param) {
		return server_paramRepo.save(server_param);
		
	}
	
	
	
	
	
}
