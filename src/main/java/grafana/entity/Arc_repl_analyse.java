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
@Table(name="arc_repl_analyse")
public class Arc_repl_analyse {

	@EmbeddedId
	private Arc_repl_analyseId id;
	
	@Column(name="repl_start")
	private Timestamp repl_start;
	
	@Column(name="repl_end")
	private Timestamp repl_end;
	
	@Column(name="diff_sek")
	private double diff_sek;
	
	@Column(name="success")
	private boolean success;
	
	
}
