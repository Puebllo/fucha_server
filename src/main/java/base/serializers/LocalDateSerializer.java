package base.serializers;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class LocalDateSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException, JsonProcessingException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = arg0.format(formatter);
        arg1.writeString(formatDateTime);        
    }

}