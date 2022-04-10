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
@Table(name="mad_repl_analyse")
public class Mad_repl_analyse {

	@EmbeddedId
	private Mad_repl_analyseId id;
	
	@Column(name="rowcount")
	private int rowcount;
	
	@Column(name="repl_start")
	private Timestamp repl_start;
	
	@Column(name="repl_end")
	private Timestamp repl_end;
	
	@Column(name="diff_sek")
	private double diff_sek;
	
	@Column(name="success")
	private boolean success;
	
	
}
