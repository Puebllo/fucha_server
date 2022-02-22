package base.pojo;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import base.controllers.UserController;
import base.dto.LoginDTO;
import base.dto.TestDao;
import base.entities.User;
import base.listeners.LocalEntityManagerFactory;

@Path("/user")
public class UserResources {
	EntityManager em;
	UserController userController;
	
	public UserResources() {
		em = LocalEntityManagerFactory.getEntityManager(); 
		userController = new UserController(em);
	}
	
	@GET
	@Path("/signin/{login}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public LoginDTO checkCredentials(@PathParam("login") String login,@PathParam("password") String password)throws Exception{
		LoginDTO response = new UserController(em).checkLoginCredentials(login,password);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("/list")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<User> listUser(){
		List<User> usersList = new ArrayList<>();
		
		Query q  = em.createQuery("SELECT u FROM " + User.class.getSimpleName() + " u");
		usersList = q.getResultList();
		
		return usersList;
	}
	
	@GET
	@Path("/saveAvatar")
	@Consumes(MediaType.TEXT_HTML)    
	public String saveAvatar() throws Exception{
	    userController.saveAvatarForUser();
	    return "OK";
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public TestDao testt(){
	    TestDao test = new TestDao();
	    test.setLdt(LocalDateTime.now());
	    return test;
	}

}
