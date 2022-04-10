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
@Table(name="file_export")
public class File_export {

	@EmbeddedId
	private File_exportId file_exportId;
	
	@Column(name="id")
	private int id;
	
	@Column(name="last_replic_time")
	private Timestamp last_replic_time;
	
	
}
