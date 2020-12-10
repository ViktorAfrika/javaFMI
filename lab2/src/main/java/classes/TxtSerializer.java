package classes;

import interfaces.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// gradle
// connect read or write with serializer
// write comments and docks
public class TxtSerializer implements Serializer {
    private Exception exception;

    // identifiers of the beginning and end of the object and the list
    private final String START_OBJECT = "~START_OBJECT~";
    private final String END_OBJECT = "~END_OBJECT~";
    private final String START_LIST = "~START_LIST~";
    private final String END_LIST = "~END_LIST~";

    @Override
    public void writeObject(CanSerialize object, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(objectToText(object));
            writer.flush();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public CanSerialize readObject(CanSerialize object, String fileName) throws Exception {
        try {
            FileReader reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);
            object.listToFields(objectFromText(scanner));
            return object;

        } catch (IOException e) {
            e.printStackTrace();
        }
        throw exception;
    }

    /**
     * converts text form file into list
     * text is in the bounds from START_LIST to END_LIST
     * @param scanner which points to the text in the file
     * @return list
     */
    private List<Object> listFromText(Scanner scanner){
        String line;
        List<Object> tempList = new ArrayList<>();
        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            if(line.equals(END_LIST))break;
            if(line.equals(START_OBJECT))
                tempList.add(objectFromText(scanner));
            else
                tempList.add(line);
        }
        return tempList;
    }

    /**
     * converts text form file into object
     * text is in the bounds from START_OBJECT to END_OBJECT
     * @param scanner which points to the text in the file
     * @return list which includes fields of object
     */
    private List<Object> objectFromText(Scanner scanner){
        String line;
        List<Object> list = new ArrayList<>();

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.equals(START_OBJECT)){}
            else if (line.equals(END_OBJECT)) break;
            else if (line.equals(START_LIST)) list.add(listFromText(scanner));
            else list.add(line);
        }

        return list;
    }

    /**
     * converts an list to text for writing to a file
     * text is in the bounds from START_LIST to END_LIST
     * @param list for recording
     * @return text for writing to a file
     */
    private String listToText(List<Object> list){
        StringBuilder sb = new StringBuilder(START_LIST).append("\n");

        // if the list element is an object then we convert as an object
        // else convert we convert as a primitive element
        for (Object o : list) {
            if (o instanceof CanSerialize)
                sb.append(objectToText((CanSerialize) o));
            else
                sb.append(o.toString()).append("\n");
        }

        sb.append(END_LIST).append("\n");
        return sb.toString();
    }

    /**
     * converts an object to text for writing to a file
     * text is in the bounds from START_OBJECT to END_OBJECT
     * @param object for recording
     * @return text for writing to a file
     */
    private String objectToText(CanSerialize object){
        // get the fields of the object
        List<Object> list = object.fieldsToList();

        StringBuilder sb = new StringBuilder(START_OBJECT).append("\n");

        for (Object o : list) {
            if (o instanceof List) {
                sb.append(listToText((List<Object>) o));
            } else {
                sb.append(o.toString()).append("\n");
            }
        }
        sb.append(END_OBJECT).append("\n");

        return sb.toString();
    }
}
