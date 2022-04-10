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
public class Arc_repl_analyseId implements Serializable {

	@Column(name="archivnummer")
	private int archivnummer;
	
	@Column(name="rowcount")
	private int rowcount;
	
	@Column(name="file")
	private String file;
	
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Arc_repl_analyseId))
			return false;
		Arc_repl_analyseId arc_repl_analyseId = (Arc_repl_analyseId) o;
		return Objects.equals(getArchivnummer(),arc_repl_analyseId.getArchivnummer() )
				&& Objects.equals(getRowcount(), arc_repl_analyseId.getRowcount())
				&& Objects.equals(getFile(), arc_repl_analyseId.getFile());
				
	}

	@Override
	public int hashCode() {
		return Objects.hash(getArchivnummer(),getRowcount(),getFile());
	}
	
	
	
	
	
	
	
}
