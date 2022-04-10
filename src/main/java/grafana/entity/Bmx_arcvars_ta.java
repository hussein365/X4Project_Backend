package grafana.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name="bmx_arcvars_ta")
public class Bmx_arcvars_ta {

	
	@EmbeddedId
	private Bmx_arcvars_taId id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="process")
	private int process;
	
	@Column(name="available_from")
	private Timestamp available_from;
	
	@Column(name="available_until")
	private Timestamp available_until;
	
	
}
