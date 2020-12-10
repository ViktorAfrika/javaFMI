import Classes.*;
import Services.*;
import Enums.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertTrue;


public class TestClass {

    //////////////////////    DataProviders  //////////////////////////////
    @DataProvider
    public Object[][] aviaryProvider(){
        List<Animal> animals = new ArrayList<>();
        animals.add((Animal) animalProvider()[0][0]);
        animals.add((Animal) animalProvider()[0][1]);
        animals.add((Animal) animalProvider()[0][2]);

        List<Employee> employees = new ArrayList<>();
        employees.add((Employee)employeeProvider()[0][0]);
        employees.add((Employee)employeeProvider()[0][1]);
        employees.add((Employee)employeeProvider()[0][2]);

        Aviary aviary1 = new Aviary.Builder(Type.AMPHIBIANS)
                .withCapacity(23)
                .withAnimals(animals)
                .withEmployees(employees)
                .build();
        Aviary aviary2 = new Aviary.Builder(Type.PISCES)
                .withCapacity(3)
                .withAnimals(animals)
                .withEmployees(employees)
                .build();
        Aviary aviary3 = new Aviary.Builder(Type.BIRDS)
                .withCapacity(203)
                .withAnimals(animals)
                .withEmployees(employees)
                .build();

        return new Object[][]{{aviary1,aviary2,aviary3}};
    }

    @DataProvider
    public Object[][] animalProvider(){
        List<Vaccine> vaccines = new ArrayList<>();
        vaccines.add((Vaccine) vaccineProvider()[0][0]);
        vaccines.add((Vaccine) vaccineProvider()[0][1]);
        vaccines.add((Vaccine) vaccineProvider()[0][2]);

        Animal animal1 = new Animal.Builder(Type.AMPHIBIANS, Sex.MALE)
                .withName("Peter")
                .withDateOfBirth(LocalDate.of(2010,3,3))
                .withVaccines(vaccines)
                .build();
        Animal animal2 = new Animal.Builder(Type.PISCES, Sex.MALE)
                .withName("Tom")
                .withDateOfBirth(LocalDate.of(2010,3,4))
                .withVaccines(vaccines)
                .build();
        Animal animal3 = new Animal.Builder(Type.BIRDS, Sex.MALE)
                .withName("Bob")
                .withDateOfBirth(LocalDate.of(2001,3,4))
                .withVaccines(vaccines)
                .build();

        return new Object[][]{{animal1,animal2,animal3}};
    }

    @DataProvider
    public Object[][] vaccineProvider(){
        Vaccine vaccine1 = new Vaccine.Builder(VaccineType.A, Disease.HERODOVIROS)
                .withName("vaccine 1")
                .build();
        Vaccine vaccine2 = new Vaccine.Builder(VaccineType.C, Disease.BLUTANG)
                .withName("vaccine 234")
                .build();
        Vaccine vaccine3 = new Vaccine.Builder(VaccineType.B, Disease.SAP)
                .withName("vaccine 32")
                .build();

        return new Object[][]{{vaccine1,vaccine2,vaccine3}};
    }

    @DataProvider Object[][] employeeProvider(){
        Employee employee1 = new Employee.Builder(Sex.MALE)
                .withDateOfBirth(LocalDate.of(2012,3,4))
                .withName("Mark")
                .withSurname("Jackson")
                .build();
        Employee employee2 = new Employee.Builder(Sex.MALE)
                .withDateOfBirth(LocalDate.of(2002,2,13))
                .withName("Sam")
                .withSurname("Gray")
                .build();
        Employee employee3 = new Employee.Builder(Sex.MALE)
                .withDateOfBirth(LocalDate.of(1992,10,3))
                .withName("Artur")
                .withSurname("Zey")
                .build();

        return new Object[][]{{employee1,employee2,employee3}};
    }


    ////////////////////////////////    test comparators   ////////////////////////////

    @Test(dataProvider = "animalProvider")
    public void testAnimalComparators(Animal animal1, Animal animal2,Animal animal3){
        Comparator<Animal> comparator = new AnimalService.NameLengthComparator();
        assertTrue(comparator.compare(animal1,animal1) == 0);
        assertTrue(comparator.compare(animal1,animal2) > 0);
        assertTrue(comparator.compare(animal3,animal1) < 0);

        comparator = new AnimalService.TypeNameComparator();
        assertTrue(comparator.compare(animal1,animal1) == 0);
        assertTrue(comparator.compare(animal1,animal2) < 0);
        assertTrue(comparator.compare(animal3,animal1) > 0);

        comparator = new AnimalService.TypeNameLengthComparator();
        assertTrue(comparator.compare(animal1,animal1) == 0);
        assertTrue(comparator.compare(animal1,animal2) > 0);
        assertTrue(comparator.compare(animal3,animal1) < 0);

        comparator = new AnimalService.BirthDateComparator();
        assertTrue(comparator.compare(animal1,animal1) == 0);
        assertTrue(comparator.compare(animal1,animal2) < 0);
        assertTrue(comparator.compare(animal3,animal1) < 0);

    }

    @Test(dataProvider = "employeeProvider")
    public void testEmployeeComparators(Employee employee1,Employee employee2,Employee employee3){
        Comparator<Employee> comparator = new EmployeeService.NameLengthComparator();
        assertTrue(comparator.compare(employee1,employee1) == 0);
        assertTrue(comparator.compare(employee1,employee2) > 0);
        assertTrue(comparator.compare(employee3,employee1) > 0);

        comparator = new EmployeeService.BirthDateComparator();
        assertTrue(comparator.compare(employee1,employee1) == 0);
        assertTrue(comparator.compare(employee1,employee2) > 0);
        assertTrue(comparator.compare(employee3,employee1) < 0);

        comparator = new EmployeeService.SurnameLengthComparator();
        assertTrue(comparator.compare(employee1,employee1) == 0);
        assertTrue(comparator.compare(employee1,employee2) > 0);
        assertTrue(comparator.compare(employee3,employee1) < 0);

        comparator = new EmployeeService.SurnameComparator();
        assertTrue(comparator.compare(employee1,employee1) == 0);
        assertTrue(comparator.compare(employee1,employee2) > 0);
        assertTrue(comparator.compare(employee3,employee1) > 0);
    }

    @Test(dataProvider = "vaccineProvider")
    public void testVaccineComparators(Vaccine vaccine1,Vaccine vaccine2,Vaccine vaccine3){
        Comparator<Vaccine> comparator = new VaccineService.NameLengthComparator();
        assertTrue(comparator.compare(vaccine1,vaccine1) == 0);
        assertTrue(comparator.compare(vaccine1,vaccine2) < 0);
        assertTrue(comparator.compare(vaccine3,vaccine1) > 0);

        comparator = new VaccineService.DiseaseNameLengthComparator();
        assertTrue(comparator.compare(vaccine1,vaccine1) == 0);
        assertTrue(comparator.compare(vaccine1,vaccine2) > 0);
        assertTrue(comparator.compare(vaccine3,vaccine1) < 0);

        comparator = new VaccineService.DiseaseNameComparator();
        assertTrue(comparator.compare(vaccine1,vaccine1) == 0);
        assertTrue(comparator.compare(vaccine1,vaccine2) > 0);
        assertTrue(comparator.compare(vaccine3,vaccine1) > 0);

        comparator = new VaccineService.TypeNameLengthComparator();
        assertTrue(comparator.compare(vaccine1,vaccine1) == 0);
        assertTrue(comparator.compare(vaccine1,vaccine2) == 0);
        assertTrue(comparator.compare(vaccine3,vaccine1) == 0);

        comparator = new VaccineService.TypeNameComparator();
        assertTrue(comparator.compare(vaccine1,vaccine1) == 0);
        assertTrue(comparator.compare(vaccine1,vaccine2) < 0);
        assertTrue(comparator.compare(vaccine3,vaccine1) > 0);
    }

    @Test(dataProvider = "aviaryProvider")
    public void testAviaryComparators(Aviary aviary1,Aviary aviary2,Aviary aviary3){
        Comparator<Aviary> comparator = new AviaryService.CapacityComparator();
        assertTrue(comparator.compare(aviary1,aviary1) == 0);
        assertTrue(comparator.compare(aviary1,aviary2) >  0);
        assertTrue(comparator.compare(aviary3,aviary1) > 0);

        comparator = new AviaryService.TypeNameLengthComparator();
        assertTrue(comparator.compare(aviary1,aviary1) == 0);
        assertTrue(comparator.compare(aviary1,aviary2) >  0);
        assertTrue(comparator.compare(aviary3,aviary1) < 0);
    }
}
