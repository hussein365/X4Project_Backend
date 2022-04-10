package grafana.entity;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="bmx_masterdata_ta")
public class Bmx_masterdata_ta {

	
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="oid")
	private String oid;
	
	@Column(name="id")
	private BigInteger id;
	
	@Column(name="xid")
	private String xid;
	
	@Column(name="description")
	private String description;
	
	@Column(name="external_object_id")
	private String external_object_id;
	
	@Column(name="moddate")
	private Timestamp moddate;
	
	@Column(name="name")
	private String name;
	
	@Column(name="object_class")
	private int object_class;
	
	@Column(name="object_type")
	private String object_type;
	
	@Column(name="fk_md")
	private BigInteger fk_md;
	
	@Column(name="init_date")
	private BigInteger init_date;
	
	@ManyToOne
	@JoinColumn(name="mandant")
	private Mandant mandant;;
	
	@Column(name="process")
	private int process;
	
	@Column(name="randmandant")
	private int randmandant;
	
	@Column(name="short_name")
	private String short_name;
	
	@Column(name="tid")
	private BigInteger tid;
	
	@Column(name="valid_from")
	private Timestamp valid_from;
	
	@Column(name="valid_until")
	private Timestamp valid_until;
	
	@Column(name="dmt")
	private String dmt;
	
	@Column(name="type_0")
	private String type0;
	
	@Column(name="type_1")
	private String type1;
	
	@Column(name="name_1")
	private String name1;
	
	@Column(name="type_2")
	private String type2;
	
	@Column(name="name_2")
	private String name2;
	
	@Column(name="type_3")
	private String type3;
	
	@Column(name="name_3")
	private String name3;
	
	@Column(name="type_4")
    private String type4;
	
    @Column(name="name_4")
	private String name4;
	
    @Column(name="type_5")
    private String type5;
    
    @Column(name="name_5")
	private String name5;
	
    @Column(name="type_6")
    private String type6;
	
    @Column(name="name_6")
	private String name6;
	
    @Column(name="type_7")
    private String type7;
	
    @Column(name="name_7")
	private String name7;
	
    @Column(name="type_8")
    private String type8;
    
    @Column(name="name_8")
	private String name8;
	
    @Column(name="type_9")
    private String type9;
    
    @Column(name="name_9")
	private String name9;
	
    @Column(name="type_10")
    private String type10;
	
    @Column(name="name_10")
	private String name10;
	
	@ManyToOne
	@JoinColumn(name="ta_typ")
	private Ta_typ tatyp;
	
	@Column(name="ta")
	private int ta;
	
	@Column(name="children_link")
	private String children_link;
	
	@Column(name="level")
	private int level;
	
	
	
	
}
