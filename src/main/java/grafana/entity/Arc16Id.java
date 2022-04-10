package grafana.entity;

import java.io.Serializable;
import java.sql.Timestamp;
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
public class Arc16Id implements Serializable {

	@Column(name="time")
	private Timestamp time;
	@Column(name="tid")
	private int tid;
	@Column(name="av")
	private int av;
	
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Arc16Id))
			return false;
		Arc16Id arc16Id = (Arc16Id) o;
		return Objects.equals(getTime(),arc16Id.getTime() )
				&& Objects.equals(getTid(), arc16Id.getTid())
				&& Objects.equals(getAv(), arc16Id.getAv());
				
	}

	@Override
	public int hashCode() {
		return Objects.hash(getTime(),getTid(),getAv());
	}
	
}
