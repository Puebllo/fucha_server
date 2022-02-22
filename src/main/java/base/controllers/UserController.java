package base.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import base.commons.CommonStatics;
import base.dto.LoginDTO;
import base.entities.Person;
import base.entities.User;

public class UserController {

    EntityManager em;

    public UserController(EntityManager em) {
        this.em=em;
    }

    public User getUserByLogin(String login) throws Exception {
        try {
            Query q = em.createQuery("SELECT u FROM "+User.class.getSimpleName()+" u WHERE u."+ User.LOGIN+"=:u");
            q.setParameter("u", login);  
            return (User) q.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }

    }

    public Person getPersonByUser(User user) throws Exception {
        try {
            Query q = em.createQuery("SELECT p FROM "+Person.class.getSimpleName()+" p where p." +Person.USER+" =:u");
            q.setParameter("u", user);  
            return (Person) q.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }

    }

    public LoginDTO checkLoginCredentials(String login, String password) throws Exception {
        try {
            LoginDTO loginDto = new LoginDTO();

            User user =getUserByLogin(login);

            if(user!=null && user.getPassword().equals(password)){
                    loginDto.setOnLoginResponse(CommonStatics.ON_LOGIN_OK);
                    loginDto.setLogin(user.getLogin());
                    loginDto.setUserTypeEnum(user.getUserTypeEnum());
                    loginDto.setLanguageCodeEnum(user.getLanguageCodeEnum());
                    loginDto.setAvatar(user.getAvatar());
                }
                else {
                    loginDto.setOnLoginResponse(CommonStatics.ON_LOGIN_WRONG_CREDENTIALS);
                }
            
                 return loginDto;
        } catch (Exception e) {
            throw(e);
        }
    }
    
    public void saveAvatarForUser() throws Exception{
       User user = getUserByLogin("pueblo");
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("indeks.jpg");
        user.setAvatar(toByteArray(inputStream));
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }
    
    
    public static byte[] toByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            byte[] b = new byte[4096];
            int n = 0;
            while ((n = is.read(b)) != -1) {
                output.write(b, 0, n);
            }
            return output.toByteArray();
        } finally {
            output.close();
        }
    }
    
    public static int[] toIntArray(byte buf[]) 
    {
        final ByteBuffer buffer = ByteBuffer.wrap(buf)
            .order(ByteOrder.LITTLE_ENDIAN);
        final int[] ret = new int[buf.length / 4];
        buffer.asIntBuffer().put(ret);
        return ret;
    }
    
/*    public JsonElement serialize(byte[] src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(Base64.encodeToString(src, Base64.NO_WRAP));
}
*/

}
