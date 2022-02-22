package base.dto;

import java.io.Serializable;
import java.util.List;

import base.entities.Address;
import base.entities.JobType;

public class GetNewJobDTO implements Serializable{


    private static final long serialVersionUID = -7994608929809407752L;
    
    Address address;
    List<JobType> jobTypes;
    
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public List<JobType> getJobTypes() {
        return jobTypes;
    }
    public void setJobTypes(List<JobType> jobTypes) {
        this.jobTypes = jobTypes;
    }

}
