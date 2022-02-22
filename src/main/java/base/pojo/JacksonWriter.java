package base.pojo;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonWriter implements MessageBodyWriter<Object> {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public long getSize(Object arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4) {
        return -1;
    }

    @Override
    public boolean isWriteable(Class<?> arg0, Type arg1, Annotation[] arg2, MediaType arg3) {
        if(!arg0.equals(String.class)) {
            return true;
        }
        return false;
    }

    @Override
    public void writeTo(Object arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4,
            MultivaluedMap<String, Object> arg5, OutputStream arg6) throws IOException, WebApplicationException {
        try {
            MAPPER.writeValue(arg6, arg0);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }        
    }

}
