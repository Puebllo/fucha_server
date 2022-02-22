package base.dto;

import java.io.Serializable;

import base.entities.Address;
import base.entities.JobType;

 
public class NewJobDTO implements Serializable {


    private static final long serialVersionUID = -5438579979075486436L;
    
    String jobName;
    String jobDescription;
    JobType jobType;
    Double cost;
    
/*    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)*/
  /*  @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)*/
    String expireLocalDate;
    String userLogin;
    Address address;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

  // @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public String getExpireLocalDate() {
        return expireLocalDate;
    }

    public void setExpireLocalDate(String expireLocalDate) {
        this.expireLocalDate = expireLocalDate;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
