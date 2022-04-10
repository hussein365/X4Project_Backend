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
public class Bmx_arcvars_taId implements Serializable {

	
	@Column(name="tid")
	private int tid;
	@Column(name="av")
	private int av;
	
	@Column(name="fk_arc")
	private int fk_arc;
	
	@Column(name="cycle")
	private int cycle;
	
	
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Bmx_arcvars_taId))
			return false;
		Bmx_arcvars_taId bmx_arcvars_taId = (Bmx_arcvars_taId) o;
		return Objects.equals(getTid(), bmx_arcvars_taId.getTid())
				&& Objects.equals(getAv(), bmx_arcvars_taId.getAv())
				&& Objects.equals(getFk_arc(), bmx_arcvars_taId.getFk_arc())
				&& Objects.equals(getCycle(), bmx_arcvars_taId.getCycle());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getTid(), getAv(), getFk_arc(), getCycle());
	}
	
	
	
	
	
	
	
}
