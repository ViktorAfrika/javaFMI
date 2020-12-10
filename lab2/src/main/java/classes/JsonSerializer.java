package classes;

import interfaces.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;

// docks
public class JsonSerializer implements Serializer {
    private Exception exception;
    ObjectMapper mapper;

    public JsonSerializer(){
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Override
    public void writeObject(CanSerialize object, String fileName) {
        try{
            mapper.writeValue(new File(fileName),object);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public CanSerialize readObject(CanSerialize object, String fileName) throws Exception{
        try{
            return mapper.readValue(new File(fileName),object.getClass());
        }catch (Exception e){
            e.printStackTrace();
        }
        throw exception;
    }

}
