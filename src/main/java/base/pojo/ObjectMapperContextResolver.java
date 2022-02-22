package base.pojo;
import java.time.LocalDateTime;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;

import base.serializers.ByteArraySerializer;
import base.serializers.LocalDateSerializer;

@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {  
    private ObjectMapper mapper;

    public ObjectMapperContextResolver() {
        mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("MyModule", new Version(1, 0, 0, null));
        
        module.addSerializer(LocalDateTime.class, new LocalDateSerializer());
        module.addSerializer(byte[].class, new ByteArraySerializer());

        mapper.registerModule(module);
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }  
}