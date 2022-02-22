package base.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import base.commons.CommonStatics;
import base.dto.GetNewJobDTO;
import base.dto.JobAssignDTO;
import base.dto.NewJobDTO;
import base.entities.Address;
import base.entities.Job;
import base.entities.JobAssignment;
import base.entities.JobType;
import base.entities.Person;
import base.entities.User;
import base.enums.LanguageCodeEnum;

public class JobController {
    EntityManager em;

    public JobController(EntityManager em) {
        this.em=em;
    }

    public GetNewJobDTO getDataForNewJob(String login) throws Exception{
        try {
            GetNewJobDTO gnjdto = new GetNewJobDTO();

            UserController uc = new UserController(em);
            User user = uc.getUserByLogin(login);
            if(user!=null) {
                Person person =  uc.getPersonByUser(user);
                if(person!=null && person.getAddress()!=null) {
                    gnjdto.setAddress(person.getAddress());
                }

                List<JobType> jobTypes = getJobTypesByLanguge(user.getLanguageCodeEnum());
                gnjdto.setJobTypes(jobTypes);
            }
            return gnjdto;
        } catch (Exception e) {
            throw(e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<JobType> getJobTypesByLanguge(LanguageCodeEnum languageCodeEnum) throws Exception{
        try {
            Query q = em.createQuery("SELECT u FROM "+JobType.class.getSimpleName()+" u WHERE u."+ JobType.LANGUAGE_NAME +"=:lce");
            q.setParameter("lce", languageCodeEnum);  
            return (List<JobType>) q.getResultList();
        } catch (Exception e) {
            throw(e);
        }
    }

    public void saveNewJob(NewJobDTO dto) throws Exception {
        em.getTransaction().begin();
        em.persist(dto.getAddress());
        LocalDate expireLocalDate = LocalDate.parse(dto.getExpireLocalDate());
        Job toSave = new Job();
        toSave.setJobName(dto.getJobName());
        toSave.setJobDescription(dto.getJobDescription());
        toSave.setJobType(dto.getJobType());
        toSave.setAddress(dto.getAddress());
        toSave.setJobExpireDate(expireLocalDate);
        toSave.setCost(dto.getCost());
        User user = new UserController(em).getUserByLogin(dto.getUserLogin());
        toSave.setUserCommisionBy(user);
        em.persist(toSave);

        //em.flush();
        em.getTransaction().commit();


    }

    @SuppressWarnings("unchecked")
    public List<Job> getJobsByCity(String city){
        Query q = em.createQuery("SELECT j FROM "+ Job.class.getSimpleName() + " j WHERE j." + Job.ADDRESS+"."+Address.CITY +" =:city");
        q.setParameter("city", city);
        return (List<Job>) q.getResultList();
    }

    public String assignJobToUser(JobAssignDTO dto) throws Exception{
        String result = CommonStatics.JOB_ALREADY_ASSIGNED;
        User user = new UserController(em).getUserByLogin(dto.getUserLogin());
        Job job = getJobById(dto.getJobId());
        if(!checkIfJobIsAlreadyAssigned(dto.getJobId())) {
            JobAssignment jobAssignment = new JobAssignment();
            jobAssignment.setAssignDate(LocalDate.now());
            jobAssignment.setAssignmentTo(user);
            jobAssignment.setJob(job);


            em.getTransaction().begin();
            em.persist(jobAssignment);
            em.getTransaction().commit();
            result = CommonStatics.RESPONSE_OK;
        }
        return result;
    }

    private Job getJobById(Long jobId) {
        Query q = em.createQuery("SELECT j FROM "+ Job.class.getSimpleName() + " j WHERE j." + Job.ID+" =:id");
        q.setParameter("id", jobId);
        return (Job) q.getSingleResult();
    }

    private boolean checkIfJobIsAlreadyAssigned(Long jobId) {
        boolean toReturn = true;
        Query q = em.createQuery("SELECT j FROM "+ JobAssignment.class.getSimpleName() + " j WHERE j." + JobAssignment.JOB+"."+Job.ID+" =:id");
        q.setParameter("id", jobId);
        try {
            JobAssignment jobAssignment = (JobAssignment) q.getSingleResult();       
        } catch (NoResultException e) {
            toReturn = false;
        }
        return toReturn;
    }

}
