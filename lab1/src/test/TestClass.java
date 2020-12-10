package test;

import main.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestClass {


    ////////////////    test Animal    ////////////////////
    @DataProvider
    public Object[][] animalProvider(){
        // creating equal objects
        Animal animal1 = new Animal.Builder(Type.AMPHIBIANS, Sex.MALE)
                .build();
        Animal animal2 = new Animal.Builder(Type.AMPHIBIANS, Sex.MALE)
                .build();

        // creating vaccine for animal3
        List<Vaccine> vaccines = new ArrayList<>();
        vaccines.add((Vaccine)vaccineProvider()[0][0]);

        // creating object not equal to animal1 and animal2
        Animal animal3 = new Animal.Builder(Type.BIRDS, Sex.MALE)
                .withName("bird")
                .withDateOfBirth(LocalDate.now())
                .withVaccines(vaccines)
                .build();

        return new Object[][]{{animal1,animal2,animal3}};
    }
    @Test(dataProvider = "animalProvider")
    public void animalTest(Animal animal1,Animal animal2,Animal animal3){
        System.out.println("//////////   show hashCode()   /////////////////\n");
        showHashCode(animalProvider()[0]);

        System.out.println("\n//////////   test equals()   /////////////////\n");
        assertEquals(animal1.equals(animal2),true);
        System.out.println("animal1 == animal2");
        assertEquals(animal1.equals(animal3),false);
        System.out.println("animal2 != animal3");

        System.out.println("\n//////////   show toString()   /////////////////\n");
        showToString(animalProvider()[0]);
    }


    ////////////////    test Vaccine    ////////////////////
    @DataProvider
    public Object[][] vaccineProvider(){
        // creating equal objects
        Vaccine vaccine1 = new Vaccine.Builder(VaccineType.B,Disease.BANAMIOSIS)
                .build();
        Vaccine vaccine2 = new Vaccine.Builder(VaccineType.B,Disease.BANAMIOSIS)
                .build();

        // creating object not equal to vaccine1 and vaccine2
        Vaccine vaccine3 = new Vaccine.Builder(VaccineType.B,Disease.BANAMIOSIS)
                .withName("vaccine 3")
                .build();

        return new Object[][]{{vaccine1,vaccine2,vaccine3}};
    }
    @Test(dataProvider = "vaccineProvider")
    public void vaccineTest(Vaccine vaccine1,Vaccine vaccine2,Vaccine vaccine3){
        System.out.println("//////////   show hashCode()   /////////////////\n");
        showHashCode(vaccineProvider()[0]);

        System.out.println("\n//////////   test equals()   /////////////////\n");
        assertEquals(vaccine1.equals(vaccine2),true);
        System.out.println("vaccine1 == vaccine2");
        assertEquals(vaccine2.equals(vaccine3),false);
        System.out.println("vaccine2 != vaccine3");

        System.out.println("\n//////////   show toString()   /////////////////\n");
        showToString(vaccineProvider()[0]);
    }


    ////////////////    test Aviary    ////////////////////
    @DataProvider
    public Object[][] aviaryProvider(){
        // creating equal objects
        Aviary aviary1 = new Aviary.Builder(Type.AMPHIBIANS)
                .withCapacity(2)
                .build();

        // creating list of animals for aviary2 and aviary3
        List<Animal> animals = new ArrayList<>();
        animals.add((Animal)animalProvider()[0][0]);
        animals.add((Animal)animalProvider()[0][1]);

        Aviary aviary2 = new Aviary.Builder(Type.AMPHIBIANS)
                .withCapacity(2)
                .withAnimals(animals)
                .build();

        // creating list of employees for aviary3
        List<Employee> employees= new ArrayList<>();
        employees.add((Employee)employeeProvider()[0][0]);
        employees.add((Employee)employeeProvider()[0][1]);

        // creating object not equal to aviary1 and aviary2
        Aviary aviary3 = new Aviary.Builder(Type.REPTILES)
                .withCapacity(2)
                .withAnimals(animals)
                .withEmployers(employees)
                .build();

        return new Object[][]{{aviary1,aviary2,aviary3}};
    }
    @Test(dataProvider = "aviaryProvider")
    public void aviaryTest(Aviary aviary1, Aviary aviary2,Aviary aviary3){
        System.out.println("//////////   show hashCode()   /////////////////\n");
        showHashCode(aviaryProvider()[0]);

        System.out.println("\n//////////   test equals()   /////////////////\n");
        assertEquals(aviary1.equals(aviary2),true);
        System.out.println("aviary1 == aviary2");
        assertEquals(aviary2.equals(aviary3),false);
        System.out.println("aviary2 != aviary3");

        System.out.println("\n//////////   show toString()   /////////////////\n");
        showToString(aviaryProvider()[0]);
    }


    ////////////////    test Employee    ////////////////////
    @DataProvider
    public Object[][] employeeProvider(){
        // creating equal objects
        Employee employee1 = new Employee.Builder(Sex.MALE)
                .withName("Bob")
                .build();
        Employee employee2 = new Employee.Builder(Sex.MALE)
                .withName("Bob")
                .build();

        // creating object not equal to employee1 and employee2
        Employee employee3 = new Employee.Builder(Sex.FEMALE)
                .withDateOfBirth(LocalDate.of(2000,2,12))
                .withName("Katy")
                .withSurname("Kat")
                .build();

        return new Object[][]{{employee1,employee2,employee3}};
    }
    @Test(dataProvider = "employeeProvider")
    public void employeeTest(Employee employee1,Employee employee2,Employee employee3){
        System.out.println("//////////   show hashCode()   /////////////////\n");
        showHashCode(employeeProvider()[0]);

        System.out.println("\n//////////   test equals()   /////////////////\n");
        assertEquals(employee1.equals(employee2),true);
        System.out.println("employee1 == employee2");
        assertEquals(employee2.equals(employee3),false);
        System.out.println("employee2 != employee3");

        System.out.println("\n//////////   show toString()   /////////////////\n");
        showToString(employeeProvider()[0]);
    }


    ///////////////////////   auxiliary functions   ////////////////////////
    public void showHashCode(Object[] objects){
        int i = 1;
        for(Object object : objects){
            if(object.getClass() == Animal.class)
                System.out.print("animal" + i++ + " hashCode = ");
            else if(object.getClass() == Vaccine.class)
                System.out.print("vaccine" + i++ + " hashCode = ");
            else if(object.getClass() == Employee.class)
                System.out.print("employee" + i++ + " hashCode = ");
            else if(object.getClass() == Aviary.class)
                System.out.print("aviary" + i++ + " hashCode = ");

            System.out.println(object.hashCode());
        }
    }
    public void showToString(Object[] objects){
        int i = 1;
        for(Object object : objects){
            if(object.getClass() == Animal.class)
                System.out.println("animal" + i++ + ":");
            else if(object.getClass() == Vaccine.class)
                System.out.println("vaccine" + i++ + ":");
            else if(object.getClass() == Employee.class)
                System.out.println("employee" + i++ + ":");
            else if(object.getClass() == Aviary.class)
                System.out.println("aviary" + i++ + ":");

            System.out.println(object);
        }
    }

}
