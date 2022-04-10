package grafana.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="mandant")
public class Mandant {

	
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mandantid")
	private int mandantid;
	
	@Column(name="mandant")
	private int mandant;
	
	@Column(name="groupname")
	private String groupname;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY , mappedBy="mandant",cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<UserMandantList> users;
	
	
	
	
	public void add(UserMandantList user) {
		
		if(users==null) {
			users=new ArrayList<UserMandantList>();
		}
	  users.add(user);
	 user.setMandant(this);
	
	}




	public Mandant(int mandantid, int mandant, String groupname) {
		this.mandantid = mandantid;
		this.mandant = mandant;
		this.groupname = groupname;
	}

}
