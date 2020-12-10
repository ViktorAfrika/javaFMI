package interfaces;

public interface Serializer {
    void writeObject(CanSerialize object, String fileName);
    CanSerialize readObject(CanSerialize object,String fileName)throws Exception;
}
