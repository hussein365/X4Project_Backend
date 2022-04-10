package grafana.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="job_param")
public class Job_Param implements Serializable {

	@EmbeddedId
	private Job_paramId job_ParamId;
	
	
	
	
	@Column(name="value")
	private String value;
	
	@Column(name="nr")
	private int nr;
	
	@ManyToOne
	@JoinColumn(name="id",referencedColumnName ="id",insertable=false,updatable=false)
	private Job job;
	
}
