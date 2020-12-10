import Classes.*;
import Enums.*;

import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;


public class TestClass {

    @Test
    public void testVaccineValidation(){
        //////////////   Right objects  ////////////////
        try {
            Vaccine vaccine = new Vaccine.Builder(VaccineType.A, Disease.HERODOVIROS)
                    .withName("vaccine 1")
                    .build();
            assertTrue(true);
        }
        catch (Exception ex){
            fail();
        }

        try {
            Vaccine vaccine = new Vaccine.Builder(VaccineType.B, Disease.SAP)
                    .withName("vaccine 32")
                    .build();
            assertTrue(true);
        }
        catch (Exception ex){
            fail();
        }

        try {
            Vaccine vaccine = new Vaccine.Builder(VaccineType.C, Disease.BLUTANG)
                    .withName("vaccine 234")
                    .build();
            assertTrue(true);
        }
        catch (Exception ex){
            fail();
        }

        ////////////  Wrong objects   /////////////////
        try {
            Vaccine vaccine = new Vaccine.Builder(VaccineType.C, Disease.BLUTANG)
                    .withName("vaccine 234##")
                    .build();
            fail();
        }
        catch (Exception ex){
            assertTrue(true);
        }
        try {
            Vaccine vaccine = new Vaccine.Builder(VaccineType.C, Disease.BLUTANG)
                    .withName("vaccine 234fggggggggggggggggggggggggggggggggggggggggg")
                    .build();
            fail();
        }
        catch (Exception ex){
            assertTrue(true);
        }
        try {
            Vaccine vaccine = new Vaccine.Builder(VaccineType.C, null)
                    .withName("eef")
                    .build();
            fail();
        }
        catch (Exception ex){
            assertTrue(true);
        }
        try {
            Vaccine vaccine = new Vaccine.Builder(null, Disease.BLUTANG)
                    .withName("eef")
                    .build();
            fail();
        }
        catch (Exception ex){
            assertTrue(true);
        }
    }

    @Test
    public void testEmployeeValidation(){
        //////////////   Right objects  ////////////////
        try {
            Employee employee = new Employee.Builder(Sex.MALE)
                    .withDateOfBirth(LocalDate.of(2012,3,4))
                    .withName("Mark tyty")
                    .withSurname("Jackson gb")
                    .build();
            assertTrue(true);
        }
        catch (Exception ex){
            fail();
        }

        try {
            Employee employee = new Employee.Builder(Sex.MALE)
                    .withDateOfBirth(LocalDate.of(2002,2,13))
                    .withName("Sam-ygh")
                    .withSurname("Gray")
                    .build();
            assertTrue(true);
        }
        catch (Exception ex){
            fail();
        }

        try {
            Employee employee = new Employee.Builder(Sex.MALE)
                    .withDateOfBirth(LocalDate.of(1992,10,3))
                    .withName("Artur")
                    .withSurname("Zey")
                    .build();
            assertTrue(true);
        }
        catch (Exception ex){
            fail();
        }

        ////////////  Wrong objects   /////////////////
        try {
            Employee employee = new Employee.Builder(Sex.MALE)
                    .withDateOfBirth(LocalDate.of(1992,10,3))
                    .withName("Artur3435")
                    .withSurname("Zey#")
                    .build();
            fail();
        }
        catch (Exception ex){
            assertTrue(true);
        }

        try {
            Employee employee = new Employee.Builder(Sex.MALE)
                    .withDateOfBirth(LocalDate.of(1992,10,3))
                    .withName("---Artur")
                    .withSurname("Zeytttttttttttttttttttttttttttttttttttttt")
                    .build();
            fail();
        }
        catch (Exception ex){
            assertTrue(true);
        }
    }

    @Test
    public void testAviaryValidation(){
        //////////////   Right objects  ////////////////
        try {
            Aviary aviary = new Aviary.Builder(Type.AMPHIBIANS)
                .withCapacity(23)
                .build();
            assertTrue(true);
        }
        catch (Exception ex){
          fail();
        }


        try {
         Aviary aviary = new Aviary.Builder(Type.BIRDS)
                 .withCapacity(203)
                 .build();
         assertTrue(true);
        }
        catch (Exception ex){
            fail();
        }

        ////////////  Wrong objects   /////////////////
         try {
            Aviary aviary = new Aviary.Builder(null)
                .withCapacity(203)
                .build();
            fail();
        }
        catch (Exception ex){
            assertTrue(true);
      }

    }


    @Test
    public void testAnimalValidation(){
        //////////////   Right objects  ////////////////
        try {
            Animal animal = new Animal.Builder(Type.AMPHIBIANS, Sex.MALE)
                    .withName("Peter")
                    .withDateOfBirth(LocalDate.of(2010,3,3))
                    .build();
            assertTrue(true);
        }
        catch (Exception ex){
            fail();
        }

        try {
            Animal animal = new Animal.Builder(Type.PISCES, Sex.MALE)
                    .withName("Tom")
                    .withDateOfBirth(LocalDate.of(2010,3,4))
                    .build();
            assertTrue(true);
        }
        catch (Exception ex){
            fail();
        }

        try {
            Animal animal = new Animal.Builder(Type.BIRDS, Sex.MALE)
                    .withName("Bob")
                    .withDateOfBirth(LocalDate.of(2001,3,4))
                    .build();
            assertTrue(true);
        }
        catch (Exception ex){
            fail();
        }

        ////////////  Wrong objects   /////////////////
        try {
            Animal animal = new Animal.Builder(Type.AMPHIBIANS, Sex.MALE)
                    .withName("Peter@!")
                    .withDateOfBirth(LocalDate.of(2010,3,3))
                    .build();
            fail();
        }
        catch (Exception ex){
            assertTrue(true);
        }

        try {
            Animal animal = new Animal.Builder(Type.PISCES, Sex.MALE)
                    .withName("Tom33333333333333333333333333333")
                    .withDateOfBirth(LocalDate.of(2010,3,4))
                    .build();
            fail();
        }
        catch (Exception ex){
            assertTrue(true);
        }

        try {
            Animal animal = new Animal.Builder(Type.ARACHNIDS, Sex.MALE)
                    .withName("Bob")
                    .withDateOfBirth(LocalDate.of(2001,3,4))
                    .build();
            fail();
        }
        catch (Exception ex){
            assertTrue(true);
        }
    }
}
