package Classes;

import java.util.ArrayList;
import java.util.List;
import Enums.*;

/**
 * the class characterizes the aviary which contains
 * workers,animals and has the certain properties
 */
public class Aviary implements Comparable<Aviary> {
    // required parameters
    private Type type;

    // optional parameters
    private int capacity = 1;
    private List<Animal> animals = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();


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
        public Builder withEmployees(List<Employee> employers){
            aviary.setEmployees(employers);
            return this;
        }

        public Aviary build(){
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
    public void setEmployees(List<Employee> employers){
        this.employees = employers;
    }
    public List<Employee> getEmployees(){
        return employees;
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
        for(Employee employee:employees){
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


    @Override
    public int compareTo(Aviary o){
        return type.name().compareTo(o.getType().name());
    }
}
