package Classes;

import java.util.ArrayList;
import java.util.List;
import Enums.*;
import Validators.AnimalType;
import Validators.ClassValidator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * the class characterizes the aviary which contains
 * workers,animals and has the certain properties
 */
public class Aviary {
    // required parameters
    @NotNull(message = "Type cannot be null")
    private Type type;

    // optional parameters
    @NotNull(message = "Capacity cannot be null")
    @Min(value = 1, message = "Capacity should not be less than 1")
    private int capacity = 1;
    private List<Animal> animals = new ArrayList<>();
    private List<Employee> employers = new ArrayList<>();

//    write tests

    ////////////////     builder     //////////////////
    public static class Builder{
        Aviary aviary;

        public Builder(Type type){
            aviary = new Aviary();
            aviary.setType(type);
        }
        public Builder withCapacity(int capacity){
            aviary.setCapacity(capacity);
            return this;
        }
        public Builder withAnimals(List<Animal> animals){
            aviary.setAnimals(animals);
            return this;
        }
        public Builder withEmployers(List<Employee> employers){
            aviary.setEmployers(employers);
            return this;
        }

        public Aviary build() throws Exception {
            ClassValidator.<Aviary>validate(aviary);
            return aviary;
        }

    }

    ///////////////     getters and setters    ///////////////////////
    public void setCapacity(int capacity){
        if(capacity < 1)this.capacity = 1;
        else this.capacity = Math.min(capacity,100);
    }
    public int getCapacity(){
        return capacity;
    }
    public void setAnimals(List<Animal> animals){
        this.animals = animals;
    }
    public List<Animal> getAnimals(){
        return animals;
    }
    public void setEmployers(List<Employee> employers){
        this.employers = employers;
    }
    public List<Employee> getEmployers(){
        return employers;
    }
    public void setType(Type type){
        this.type = type;
    }
    public Type getType(){
        return type;
    }

    //////////////////////  overrides methods   ////////////////////
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("capacity: ").append(capacity).append("\n");
        sb.append("type: ").append(type.toString()).append("\n");

        sb.append("animals:\n");
        for(Animal animal:animals) {
            sb.append(animal.toString());
        }

        sb.append("employers:\n");
        for(Employee employee:employers){
            sb.append(employee.toString()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public int hashCode(){
        final int prime = 31;

        int result = prime*capacity;
        result += type.hashCode();

        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)return true;
        if(obj == null || getClass() != obj.getClass())return false;

        Aviary other = (Aviary)obj;

        return  capacity == other.getCapacity() &&
                type == other.getType();
    }
}
