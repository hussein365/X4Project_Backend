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
@Table(name="bmx_performance_tests")
public class Bmx_performance_tests {

	@EmbeddedId
	private Bmx_performance_testsId id;
	
	@Column(name="rowcount")
	private int rowcount;
	
	@Column(name="file_count")
	private int file_count;
	
	@Column(name="repl_start")
	private Timestamp repl_start;
	
	@Column(name="repl_end")
	private Timestamp repl_end;
	
	@Column(name="diff_sek")
	private double diff_sek;
	
	@Column(name="success")
	private boolean success;
	
	@Column(name="kommentar")
	private String kommentar;
	
	
	
	
	
	
	
	
}
