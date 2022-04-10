package grafana.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="job")
public class Job  implements Serializable {

	@EmbeddedId
	private JobId jobId;
	
	@Column(name="id")
	private int id;

	@Column(name = "curr_time")
	private Timestamp curr_time;

	@Column(name = "status")
	private String status;

	@Column(name = "user_mandant_id")
	private Integer user_mandant_id;

	@Column(name = "job_type")
	private String job_type;

	@Column(name = "email")
	private String email;

	@Column(name = "ftp_directory")
	private String ftpdirectory;

	@Column(name = "sftp_con")
	private String sftpcon;

	@Column(name = "email_result_file")
	private String emailresultfile;

	@Column(name = "max_file_size")
	private String maxfilesize;

	@Column(name = "date_relativ",nullable=false)
	private Boolean daterelativ;

	@Column(name = "dezimal_punkt",nullable=false)
    private String dezimalpunkt;

	@JsonIgnore
	@OneToMany(mappedBy = "job")
	private List<Job_Param> params;

	public void add(Job_Param job_param) {

		if (params == null) {
			params = new ArrayList<Job_Param>();
		}
		params.add(job_param);
		job_param.setJob(this);
		;

	}

}
