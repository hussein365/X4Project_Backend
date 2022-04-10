package grafana.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Job_paramId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="id")
	private int id;
	@Column(name="key")
	private String key;
	
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Job_paramId))
			return false;
		Job_paramId job_paramId = (Job_paramId) o;
		return Objects.equals(getId(), job_paramId.getId()) && Objects.equals(getKey(), job_paramId.getKey());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getKey());
	}
	
	
	
	
	
	
}
