package base.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "job", schema = "public")
public class Job implements Serializable {

    private static final long serialVersionUID = 7987104867724519825L;
    public static final String ID ="id";
    public static final String JOB_TYPE ="jobType";
    public static final String JOB_NAME ="jobName";
    public static final String JOB_DESCRIPTION ="jobDescription";
    public static final String USER_COMMISION_BY ="userCommisionBy";
    public static final String JOB_EXPIRE_DATE ="jobExpireDate";
    public static final String COST ="cost";
    public static final String ADDRESS ="address";

    public Long id;
    public JobType jobType;
    public String jobName;
    public String jobDescription;
    public User userCommisionBy;
    public LocalDate jobExpireDate;
    public Double cost;
    public Address address;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "job_type", nullable = false)
    public JobType getJobType() {
        return jobType;
    }
    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    @Column(name = "job_name", nullable = false)
    public String getJobName() {
        return jobName;
    }
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Column(name = "job_description", nullable = false)
    public String getJobDescription() {
        return jobDescription;
    }
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }


    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "users", nullable = false)
    public User getUserCommisionBy() {
        return userCommisionBy;
    }
    public void setUserCommisionBy(User userCommisionBy) {
        this.userCommisionBy = userCommisionBy;
    }

    @Column(name = "job_expire_date", nullable = false)
    public LocalDate getJobExpireDate() {
        return jobExpireDate;
    }
    public void setJobExpireDate(LocalDate jobExpireDate) {
        this.jobExpireDate = jobExpireDate;
    }

    @Column(name = "cost", nullable = false)
    public Double getCost() {
        return cost;
    }
    public void setCost(Double cost) {
        this.cost = cost;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "address", nullable = false)
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
