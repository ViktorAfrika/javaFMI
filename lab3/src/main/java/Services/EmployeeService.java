package Services;

import Classes.Animal;
import Classes.Employee;

import java.util.Comparator;

public class EmployeeService {

    /////////////////////////////////          Comparators       ////////////////////////////////

    public static class BirthDateComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
        }
    }

    public static class NameLengthComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee o1,Employee o2){
            return Integer.compare(o1.getName().length(),o2.getName().length());
        }
    }

    public static class SurnameLengthComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee o1,Employee o2){
            return Integer.compare(o1.getSurname().length(),o2.getSurname().length());
        }
    }

    public static class SurnameComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee o1,Employee o2){
            return o1.getSurname().compareTo(o2.getSurname());
        }
    }


}
