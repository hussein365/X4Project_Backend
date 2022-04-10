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
public class File_exportId implements Serializable {


	@Column(name="key")
	private String key;
	
	@Column(name="last_filename")
	private String last_filename;
	
	
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof File_exportId))
			return false;
		File_exportId file_exportId = (File_exportId) o;
		return Objects.equals(getKey(), file_exportId.getKey()) && Objects.equals(getLast_filename(), file_exportId.getLast_filename());
				
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(getKey(), getLast_filename());
	}
	
}
