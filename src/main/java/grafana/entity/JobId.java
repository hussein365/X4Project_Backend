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
public class JobId implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="name")
	private String name;
	
	@Column(name="mandant")
	private String mandant;
	
	@Column(name="grafana_user")
	private String grafana_user;

	
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof JobId))
			return false;
		JobId jobId = (JobId) o;
		return Objects.equals(getName(), jobId.getName()) && Objects.equals(getMandant(), jobId.getMandant())
				 && Objects.equals(getGrafana_user(), jobId.getGrafana_user());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getMandant(),getGrafana_user());
	}
}
