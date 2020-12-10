package Classes;

import java.time.LocalDate;
import Enums.*;
import Validators.ClassValidator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * the class characterizes the zoo employee
 * and his basic data
 */
public class Employee {
    private final String NAME_PATTERN = "[a-zA-Z]{2,}(-|( ))?[a-zA-Z]+";

    // required parameters
    @NotNull(message = "Sex cannot be null")
    private Sex sex;

    // optional parameters
    @NotNull(message = "Name cannot be null")
    @Size(min = 2,max = 15,message = "Name length must be between 2 and 15")
    @Pattern(regexp = NAME_PATTERN, message = "Name must match the template: " + NAME_PATTERN)
    private String name = "no name";

    @NotNull(message = "Name cannot be null")
    @Size(min = 2,max = 20,message = "Name length must be between 2 and 20")
    @Pattern(regexp = NAME_PATTERN, message = "Surname must match the template: " + NAME_PATTERN)
    private String surname = "no surname";

    @NotNull(message = "Date of birth cannot be null")
    @PastOrPresent(message = "Date of birth cannot be in future")
    private LocalDate dateOfBirth = LocalDate.now();

    ///////////////      builder     ///////////////////
    public static class Builder{
        Employee employee;

        public Builder(Sex sex){
            employee = new Employee();
            employee.setSex(sex);
        }
        public Builder withName(String name){
            employee.setName(name);
            return this;
        }
        public Builder withSurname(String surname){
            employee.setSurname(surname);
            return this;
        }
        public Builder withDateOfBirth(LocalDate dateOfBirth){
            employee.setDateOfBirth(dateOfBirth);
            return this;
        }

        public Employee build() throws Exception {
            ClassValidator.<Employee>validate(employee);
            return employee;
        }
    }

    ///////////////     getters and setters    ///////////////////////
    public void setName(String name){
        if(name.equals(""))this.name = "no name";
        else this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setSurname(String surname){
        if(surname.equals(""))this.surname = "no surname";
        else this.surname = surname;
    }
    public String getSurname(){
        return surname;
    }
    public void setSex(Sex sex){
        this.sex = sex;
    }
    public Sex getSex(){
        return sex;
    }
    public void setDateOfBirth(LocalDate dateOfBirth){
        int year;
        int minYear = 1800;

        // comparing years
        if(dateOfBirth.getYear() > LocalDate.now().getYear())year = LocalDate.now().getYear();
        else if(dateOfBirth.getYear() < minYear)year = minYear;
        else year = dateOfBirth.getYear();

        // setting values
        this.dateOfBirth = LocalDate.of(year,dateOfBirth.getMonth(),dateOfBirth.getDayOfMonth());
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }

    //////////////////////  overrides methods   ////////////////////
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("name: ").append(name).append("\n");
        sb.append("surname: ").append(surname).append("\n");
        sb.append("sex: ").append(sex.toString()).append("\n");
        sb.append("date of birth: ").append(dateOfBirth.toString());

        return sb.toString();
    }

    @Override
    public int hashCode(){
        int result = name.hashCode();
        result += surname.hashCode();
        result += sex.hashCode();
        result += dateOfBirth.hashCode();

        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)return true;
        if(obj == null || getClass() != obj.getClass())return false;

        Employee other = (Employee)obj;

        return name.equals(other.getName()) &&
                surname == other.getSurname() &&
                sex == other.getSex() &&
                dateOfBirth.equals(other.getDateOfBirth());
    }

}
