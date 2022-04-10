package grafana.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bmx_arclist_ta")
public class Bmx_arclist_ta {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="process")
	private int process;
	
	@Column(name="cycle")
	private int cycle;
	
	@Column(name="available_from")
	private Timestamp available_from;
	
	@Column(name="avaialable_until")
	private Timestamp available_until;
	
	@Column(name="replication_thread")
	private int replication_thread;
	
	@Column(name="replication_active")
	private int replication_active;
		
		
}
