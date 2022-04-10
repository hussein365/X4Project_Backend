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
@Table(name="arc16")
public class Arc16 {

	@EmbeddedId
	private Arc16Id id;
	
	@Column(name="state")
	private String state;
	
	@Column(name="value")
	private double value;
	
	@Column(name="min")
	private double min;
	
	@Column(name="min_time")
	private Timestamp min_time;
	
	@Column(name="max")
	private double max;
	
	@Column(name="max_time")
	private Timestamp max_time;
	
	@Column(name="avg")
	private double avg;
	
	@Column(name="avg_3m")
	private double avg_3m;
	
	@Column(name="avg_5m")
	private double avg_5m;
}
