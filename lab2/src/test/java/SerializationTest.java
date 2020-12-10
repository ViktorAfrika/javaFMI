import classes.*;
import enums.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SerializationTest {
    @DataProvider
    public Object[][] animalProvider(){
        // creating vaccine for animal1
        List<Vaccine> vaccines = new ArrayList<>();
        vaccines.add((Vaccine)vaccineProvider()[0][0]);
        vaccines.add((Vaccine)vaccineProvider()[0][0]);

        // creating animal1
        Animal animal1 = new Animal.Builder(Type.BIRDS, Sex.MALE)
                .withName("bird")
                .withDateOfBirth(LocalDate.now())
                .withVaccines(vaccines)
                .build();

        // creating animal2
        Animal animal2 = new Animal.Builder(Type.PISCES, Sex.FEMALE).build();

        return new Object[][]{{animal1,animal2}};
    }

    @DataProvider
    public Object[][] vaccineProvider(){
        // creating vaccine1
        Vaccine vaccine1 = new Vaccine.Builder(VaccineType.B, Disease.BANAMIOSIS)
                .withName("AB45")
                .build();

        // creating vaccine2
        Vaccine vaccine2 = new Vaccine.Builder(VaccineType.A, Disease.SAP).build();
        return new Object[][]{{vaccine1,vaccine2}};
    }

    @Test (dataProvider = "animalProvider")
    public void testTxt(Animal animal1,Animal animal2) throws Exception {
        // writing object
        TxtSerializer txtSerializer = new TxtSerializer();
        String txtFileName = "txtFile.txt";
        txtSerializer.writeObject(animal1,txtFileName);

        // reading and checking object
        animal2 = (Animal)txtSerializer.readObject(animal2,txtFileName);
        assertTrue(animal2.equals(animal1));
    }

    @Test (dataProvider = "vaccineProvider")
    public void testXml(Vaccine vaccine1,Vaccine vaccine2) throws Exception {
        // writing object
        XmlSerializer xmlSerializer = new XmlSerializer();
        String xmlFileName = "xmlFile.xml";
        xmlSerializer.writeObject(vaccine1,xmlFileName);

        // reading and checking object
        vaccine2 = (Vaccine)xmlSerializer.readObject(vaccine2,xmlFileName);
        assertTrue(vaccine2.equals(vaccine1));
    }

    @Test (dataProvider = "animalProvider")
    public void testJson(Animal animal1,Animal animal2) throws Exception {
        // writing object
        JsonSerializer jsonSerializer = new JsonSerializer();
        String jsonFileName = "jsonFile.json";
        jsonSerializer.writeObject(animal1,jsonFileName);

        // reading and checking object
        animal2 = (Animal)jsonSerializer.readObject(animal2,jsonFileName);
        assertTrue(animal2.equals(animal1));
    }

}
