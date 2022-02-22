package base.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import base.commons.CommonStatics;
import base.controllers.JobController;
import base.dto.GetNewJobDTO;
import base.dto.JobAssignDTO;
import base.dto.JobDTO;
import base.dto.NewJobDTO;
import base.entities.Job;
import base.listeners.LocalEntityManagerFactory;

@Path("/job")
public class JobResources {
    
    EntityManager em;
    JobController jobController;
    
    public JobResources() {
        em = LocalEntityManagerFactory.getEntityManager(); 
        jobController= new JobController(em);
    }
    
    @GET
    @Path("/getData/{login}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public GetNewJobDTO getDataForNewJob(@PathParam("login") String login) throws Exception{
        GetNewJobDTO gnjdto = jobController.getDataForNewJob(login);
        return gnjdto;
    }
    
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public String registerNewJob(NewJobDTO dto) throws Exception{
        jobController.saveNewJob(dto);
        return CommonStatics.RESPONSE_OK;
    }
    
    @GET
    @Path("/find/city/{city}")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<JobDTO> getJobsByCity(@PathParam("city") String city) throws Exception{
        List<JobDTO> toReturn = new ArrayList<>();
        
        List<Job> jobsList = jobController.getJobsByCity(city);
        for(Job job : jobsList) {
            JobDTO dto = new JobDTO();
            dto.setJobName(job.getJobName());
            dto.setJobDescription(job.getJobDescription());
            dto.setJobType(job.getJobType());
            dto.setAddress(job.getAddress());
            dto.setCost(job.getCost());
            dto.setId(job.getId());
            dto.setJobExpireDate(job.getJobExpireDate().toString());
            
            toReturn.add(dto);
        }
        return toReturn;
    }
    
    @POST
    @Path("/associate")
    @Consumes(MediaType.APPLICATION_JSON)
    public String associateJobToUser(JobAssignDTO dto) throws Exception{
        
        return jobController.assignJobToUser(dto);
    }
}
