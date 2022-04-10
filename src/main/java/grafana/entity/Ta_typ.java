package grafana.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="ta_typ")
public class Ta_typ {

	
	@Id
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
    @Column(name="aktiv")	
	private boolean aktiv;
	@Column(name="level")
	private int level;

	@JsonIgnore
	@OneToMany(mappedBy="ta_typ",cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<Ta_typ_sep> ta_typ_seps;
	
	
	public void add(Ta_typ_sep ta_typ_sep) {
		
		if(this.ta_typ_seps==null) {
			this.ta_typ_seps=new ArrayList<Ta_typ_sep>();
		}
		ta_typ_seps.add(ta_typ_sep);
		ta_typ_sep.setTa_typ(this);
	}
	
}
