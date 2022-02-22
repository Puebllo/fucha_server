package base.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import base.enums.JobEnum;
import base.enums.LanguageCodeEnum;

@Entity
@Table(name = "job_type", schema = "public")
public class JobType implements Serializable {

	private static final long serialVersionUID = -5062547139350491229L;
	
	public static final String ID ="id";
	public static final String JOB_ENUM ="jobEnum";
	public static final String JOB_NAME ="jobName";
	public static final String LANGUAGE_NAME ="languageCode";

	public Long id;
	public JobEnum jobEnum;
	public String jobName;
	public LanguageCodeEnum languageCode;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "job_enum", nullable = false)
	public JobEnum getJobEnum() {
		return jobEnum;
	}
	
	public void setJobEnum(JobEnum jobEnum) {
		this.jobEnum = jobEnum;
	}
	
	@Column(name = "job_name", nullable = false)
	public String getJobName() {
		return jobName;
	}
	
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "language_code", nullable = false)
	public LanguageCodeEnum getLanguageCode() {
		return languageCode;
	}
	
	public void setLanguageCode(LanguageCodeEnum languageCode) {
		this.languageCode = languageCode;
	}

	@Override
	public String toString() {
		return jobEnum.name() + ": " + jobName + "[" +languageCode.name()+"]";
	}
}
