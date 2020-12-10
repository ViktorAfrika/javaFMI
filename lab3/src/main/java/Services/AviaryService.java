package Services;

import Classes.Animal;
import Classes.Aviary;
import Classes.Employee;
import Enums.Sex;
import Enums.Type;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AviaryService {
    private Aviary aviary;

    public AviaryService(Aviary aviary) {
        this.aviary = aviary;
    }

    public Aviary getAviary() {
        return aviary;
    }

    public void setAviary(Aviary aviary) {
        this.aviary = aviary;
    }

    ////////////////////////////     methods for animals  //////////////////////////////////

    public List<Animal> animalsWithSex(Sex sex){
        return aviary.getAnimals().stream().filter(x -> x.getSex().equals(sex)).collect(Collectors.toList());
    }

    public List<Animal> animalsWithType(Type type){
        return aviary.getAnimals().stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }

    public List<Animal> animalsOlder(LocalDate localDate){
        return aviary.getAnimals().stream().filter(x -> x.getDateOfBirth().isAfter(localDate)).collect(Collectors.toList());
    }

    public List<Animal> animalsYounger(LocalDate localDate){
        return aviary.getAnimals().stream().filter(x -> x.getDateOfBirth().isBefore(localDate)).collect(Collectors.toList());
    }

    /**
     *
     * @param start date
     * @param end date
     * @return list fo animals which DateOfBirth a within from start to end
     */
    public List<Animal> animalsWithBirthDate(LocalDate start,LocalDate end){
        return aviary.getAnimals().stream().filter(x -> x.getDateOfBirth().isAfter(start))
                .filter(x -> x.getDateOfBirth().isBefore(end)).collect(Collectors.toList());
    }

    ////////////////////////////     methods for employees   //////////////////////////////////

    public List<Employee> employeesOlder(LocalDate localDate){
        return aviary.getEmployees().stream().filter(x -> x.getDateOfBirth().isAfter(localDate)).collect(Collectors.toList());
    }

    public List<Employee> employeesYounger(LocalDate localDate){
        return aviary.getEmployees().stream().filter(x -> x.getDateOfBirth().isBefore(localDate)).collect(Collectors.toList());
    }

    public List<Employee> employeesWithSex(Sex sex){
        return aviary.getEmployees().stream().filter(x -> x.getSex().equals(sex)).collect(Collectors.toList());
    }

    /**
     *
     * @param start date
     * @param end date
     * @return list fo employees which DateOfBirth a within from start to end
     */
    public List<Employee> employeesWithBirthDate(LocalDate start,LocalDate end){
        return aviary.getEmployees().stream().filter(x -> x.getDateOfBirth().isAfter(start))
                .filter(x -> x.getDateOfBirth().isBefore(end)).collect(Collectors.toList());
    }

    ////////////////////////////////        Sort animals      /////////////////////////////////////////

    public List<Animal> sortAnimals(){
        Collections.sort(aviary.getAnimals());
        return aviary.getAnimals();
    }

    public List<Animal> sortAnimalsWithStream(){
        return aviary.getAnimals().stream().sorted().collect(Collectors.toList());
    }

    public List<Animal> sortAnimalsByNameLength(){
        aviary.getAnimals().sort(new AnimalService.NameLengthComparator());
        return aviary.getAnimals();
    }

    public List<Animal> sortAnimalsByNameLengthWithStream(){
        return aviary.getAnimals().stream().sorted(new AnimalService.NameLengthComparator()).collect(Collectors.toList());
    }

    public List<Animal> sortAnimalsByTypeName(){
        aviary.getAnimals().sort(new AnimalService.TypeNameComparator());
        return aviary.getAnimals();
    }

    public List<Animal> sortAnimalsByTypeNameWithStream(){
        return aviary.getAnimals().stream().sorted(new AnimalService.TypeNameComparator()).collect(Collectors.toList());
    }

    public List<Animal> sortAnimalsByTypeNameLength(){
        aviary.getAnimals().sort(new AnimalService.TypeNameLengthComparator());
        return aviary.getAnimals();
    }

    public List<Animal> sortAnimalsByTypeNameLengthWithStream(){
        return aviary.getAnimals().stream().sorted(new AnimalService.TypeNameLengthComparator()).collect(Collectors.toList());
    }

    public List<Animal> sortAnimalsByBirthDate(){
        aviary.getAnimals().sort(new AnimalService.BirthDateComparator());
        return aviary.getAnimals();
    }

    public List<Animal> sortAnimalsByBirthDateWithStream(){
        return aviary.getAnimals().stream().sorted(new AnimalService.BirthDateComparator()).collect(Collectors.toList());
    }

    //////////////////////////////////       Sort employees       ///////////////////////////////

    public List<Employee> sortEmployees(){
        Collections.sort(aviary.getEmployees());
        return aviary.getEmployees();
    }

    public List<Employee> sortEmployeesWithStream(){
        return aviary.getEmployees().stream().sorted().collect(Collectors.toList());
    }

    public List<Employee> sortEmployeesByNameLength(){
        aviary.getEmployees().sort(new EmployeeService.NameLengthComparator());
        return aviary.getEmployees();
    }

    public List<Employee> sortEmployeesByNameLengthWithStream(){
        return aviary.getEmployees().stream().sorted(new EmployeeService.NameLengthComparator()).collect(Collectors.toList());
    }

    public List<Employee> sortEmployeesBySurname(){
        aviary.getEmployees().sort(new EmployeeService.SurnameComparator());
        return aviary.getEmployees();
    }

    public List<Employee> sortEmployeesBySurnameWithStream(){
        return aviary.getEmployees().stream().sorted(new EmployeeService.SurnameComparator()).collect(Collectors.toList());
    }

    public List<Employee> sortEmployeesBySurnameLength(){
        aviary.getEmployees().sort(new EmployeeService.SurnameLengthComparator());
        return aviary.getEmployees();
    }

    public List<Employee> sortEmployeesBySurnameLengthWithStream(){
        return aviary.getEmployees().stream().sorted(new EmployeeService.SurnameLengthComparator()).collect(Collectors.toList());
    }

    public List<Employee> sortEmployeesByBirthDate(){
        aviary.getEmployees().sort(new EmployeeService.BirthDateComparator());
        return aviary.getEmployees();
    }

    public List<Employee> sortEmployeesByBirthDateWithStream(){
        return aviary.getEmployees().stream().sorted(new EmployeeService.BirthDateComparator()).collect(Collectors.toList());
    }

    /////////////////////////////////          Comparators       ////////////////////////////////

    public static class TypeNameLengthComparator implements Comparator<Aviary>{
        @Override
        public int compare(Aviary o1, Aviary o2) {
            return Integer.compare(o1.getType().name().length(),o2.getType().name().length());
        }
    }

    public static class CapacityComparator implements Comparator<Aviary>{
        @Override
        public int compare(Aviary o1, Aviary o2) {
            return Integer.compare(o1.getCapacity(),o2.getCapacity());
        }
    }
}
