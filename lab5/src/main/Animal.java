package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * the class characterizes animals in zoo
 * and their basic data
 */
public class Animal {
    // required parameters
    private Type type;
    private Sex sex;

    // optional parameters
    private LocalDate dateOfBirth = LocalDate.now();
    private String name = "no name";
    private List<Vaccine> vaccines = new ArrayList<>();




    ///////////////      builder     //////////////////////
    public static class Builder{
        Animal animal;

        public Builder(Type type, Sex sex){
            animal = new Animal();
            animal.setType(type);
            animal.setSex(sex);
        }
        public Builder withDateOfBirth(LocalDate dateOfBirth){
            animal.setDateOfBirth(dateOfBirth);
            return this;
        }
        public Builder withName(String name){
            animal.setName(name);
            return this;
        }
        public Builder withVaccines(List<Vaccine> vaccines){
            animal.setVaccines(vaccines);
            return this;
        }

        public Animal build(){
            return animal;
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
    public void setVaccines(List<Vaccine> vaccines){
        this.vaccines = vaccines;
    }
    public List<Vaccine> getVaccines(){
        return vaccines;
    }
    public void setSex(Sex sex){
        this.sex = sex;
    }
    public Sex getSex(){
        return sex;
    }
    public void setType(Type type){
        this.type = type;
    }
    public Type getType(){
        return type;
    }
    public void setDateOfBirth(LocalDate dateOfBirth){
        int year;
        int minYear = 1000;

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
        sb.append("date of birth: ").append(dateOfBirth.toString()).append("\n");
        sb.append("type: ").append(type.toString()).append("\n");
        sb.append("sex: ").append(sex.toString()).append("\n");
        sb.append("name: ").append(name).append("\n");
        sb.append("vaccines:\n");
        for(Vaccine vaccine:vaccines){
            sb.append(vaccine.toString()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public int hashCode(){
        int result = type.hashCode();
        result += sex.hashCode();
        result += name.hashCode();
        result += dateOfBirth.hashCode();

        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)return true;
        if(obj == null || getClass() != obj.getClass())return false;

        Animal other = (Animal)obj;

        return name.equals(other.getName()) &&
                sex == other.getSex() &&
                type == other.getType() &&
                dateOfBirth.equals(other.getDateOfBirth());
    }
}
