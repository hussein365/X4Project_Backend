package grafana.entity;

import java.sql.Time;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Job_JobParam {

	
	private Job job;
	
	private int archiveNr;
	
	private String mandant;
	
	private Date end_date_abs;
	
	private int end_date_rel;
	
	private Time end_time;
	
	private String name_1;
	
	private String name_2;
	
	private String name_3;
	
	private String name_4;
	
	private String name_5;
	
	private String name_6;
	
	private String name_7;
	
	private String name_8;
	
	private Date start_date_abs;
	
	private int start_date_rel;
	
	private Time start_time;
	
	private Ta_typ[] ta_type;
	
	private String type_0;
	
	private String type_1;
	
	private String type_2;
	
	private String type_3;
	
	private String type_4;
	
	private String type_5;
	
	private String type_6;
	
	private String type_7;
	
	private String type_8;
	
	private String valueArt;
	
	
	
	
}
