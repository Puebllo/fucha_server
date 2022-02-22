package base.dto;

import java.io.Serializable;

public class JobAssignDTO implements Serializable {

    private static final long serialVersionUID = 2098903358532594301L;
    
    String userLogin;
    Long jobId;

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
}
