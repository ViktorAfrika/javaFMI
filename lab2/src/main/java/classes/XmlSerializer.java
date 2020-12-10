package classes;

import interfaces.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class XmlSerializer implements Serializer {
    private Exception exception;

    @Override
    public void writeObject(CanSerialize object, String fileName) {
        try{
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller m = context.createMarshaller();
            m.marshal(object,new File(fileName));
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }

    @Override
    public CanSerialize readObject(CanSerialize object, String fileName) throws Exception {
        try{
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Unmarshaller un = context.createUnmarshaller();
            return (CanSerialize) un.unmarshal(new File(fileName));

        }catch (JAXBException e){
            e.printStackTrace();
        }
        throw  exception;
    }
}
