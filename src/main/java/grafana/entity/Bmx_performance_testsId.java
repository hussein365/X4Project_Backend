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
public class Bmx_performance_testsId implements Serializable {

	
	@Column(name="repl_type")
	private String repl_type;
	
	@Column(name="test")
	private String test;
	
	@Column(name="file")
	private String file;
	
	@Column(name="filesize")
	private int filesize;
	
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Bmx_performance_testsId))
			return false;
		Bmx_performance_testsId bmx_performancetestsId = (Bmx_performance_testsId) o;
		return Objects.equals(getRepl_type(), bmx_performancetestsId.getRepl_type())
				&& Objects.equals(getTest(), bmx_performancetestsId.getTest())
				&& Objects.equals(getFile(), bmx_performancetestsId.getFile())
				&& Objects.equals(getFilesize(), bmx_performancetestsId.getFilesize());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getRepl_type(), getTest(), getFile(), getFilesize());
	}
	
	
	
	
	
}
