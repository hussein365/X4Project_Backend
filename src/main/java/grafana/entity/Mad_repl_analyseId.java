package grafana.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
public class Mad_repl_analyseId implements Serializable {

	@Column(name="process")
	private int  process;

	@Column(name="lastmodified")
	private BigInteger lastmodified;

	@Column(name="filesize")
	private BigInteger filesize;

	@Column(name="file")
	private String file;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Mad_repl_analyseId))
			return false;
		Mad_repl_analyseId mad_repl_analyseId = (Mad_repl_analyseId) o;
		return Objects.equals(getProcess(), mad_repl_analyseId.getProcess())
				&& Objects.equals(getLastmodified(), mad_repl_analyseId.getLastmodified())
				&& Objects.equals(getFilesize(), mad_repl_analyseId.getFilesize())
				&& Objects.equals(getFile(), mad_repl_analyseId.getFile());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getProcess(), getLastmodified(), getFilesize(), getFile());
	}

}
