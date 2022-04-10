package grafana.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="sftp_con")
public class Sftp_con {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="mandant")
    private String mandant;
	
	@Column(name="name")
	private String name;
	
	@Column(name="server")
	private String server;
	
	@Column(name="username")
	private String username;
	
	@Column(name="port")
	private String port;
	
	@Column(name="protokoll")
	private String protokoll;
	
	@Column(name="password")
	private String password;
	
	@Column(name="login")
	private String login;
	
}
