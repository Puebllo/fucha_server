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
@Table(name = "job_assignment", schema = "public")
public class JobAssignment implements Serializable {

    private static final long serialVersionUID = 2606713412855254314L;
    public static final String ID ="id";
    public static final String ASSIGNMENT_TO ="assignmentTo";
    public static final String JOB ="job";
    public static final String ASSIGN_DATE ="assignDate";
    public static final String IS_FINISHED ="isFinished";

    public Long id;
    public User assignmentTo;
    public Job job;
    public LocalDate assignDate;
    public boolean isFinished;



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
    @JoinColumn(name = "users", nullable = false)
    public User getAssignmentTo() {
        return assignmentTo;
    }
    public void setAssignmentTo(User assignmentTo) {
        this.assignmentTo = assignmentTo;
    }
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "job", nullable = false)
    public Job getJob() {
        return job;
    }
    public void setJob(Job job) {
        this.job = job;
    }
    
    @Column(name="is_finished", nullable = false)
    public boolean isFinished() {
        return isFinished;
    }
    public void setFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }
    

    @Column(name="assign_date", nullable = false)
    public LocalDate getAssignDate() {
        return assignDate;
    }
    public void setAssignDate(LocalDate assignDate) {
        this.assignDate = assignDate;
    }
    
    @Override
    public String toString() {
        return job + ": " + assignmentTo + " at: " + assignDate +" is finished: " + isFinished ;
    }
}
