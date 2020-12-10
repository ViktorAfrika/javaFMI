package Classes;

import Enums.*;
import Validators.ClassValidator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * the class characterizes vaccine that
 * vaccinate animals in the zoo
 */

public class Vaccine {
    private final String NAME_PATTERN = "([a-zA-Z]|[0-9]|-| )+";

    // required parameters
    @NotNull(message = "Vaccine type cannot be null")
    private VaccineType vaccineType;
    @NotNull(message = "Disease cannot be null")
    private Disease disease;

    // optional parameters
    @NotNull(message = "Name cannot be null")
    @Size(min = 2,max = 25,message = "Name length must be between 2 and 25")
    @Pattern(regexp = NAME_PATTERN, message = "Name must match the template: " + NAME_PATTERN)
    private String name = "no name";


    ///////////////        builder       /////////////////
    public static class Builder{
        Vaccine vaccine;

        public Builder(VaccineType vaccineType, Disease disease){
            vaccine = new Vaccine();
            vaccine.setDisease(disease);
            vaccine.setVaccineType(vaccineType);
        }
        public Builder withName(String name){
            vaccine.setName(name);
            return this;
        }

        public Vaccine build() throws Exception {
            ClassValidator.<Vaccine>validate(vaccine);
            return vaccine;
        }
    }

    ///////////////     getters and setters    ///////////////////////
    public void setVaccineType(VaccineType vaccineType){
        this.vaccineType = vaccineType;
    }
    public VaccineType getVaccineType(){
        return vaccineType;
    }
    public void setName(String name){
        if(name.equals(""))this.name = "no name";
        else this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setDisease(Disease disease){
        this.disease = disease;
    }
    public Disease getDisease(){
        return disease;
    }

    //////////////////////  overrides methods   ////////////////////
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("vaccine type: ").append(vaccineType.toString()).append("\n");
        sb.append("name: ").append(name).append("\n");
        sb.append("against:").append(disease.toString());
        return sb.toString();
    }

    @Override
    public int hashCode(){
        int result = disease.hashCode();
        result += vaccineType.hashCode();
        result += name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)return true;
        if(obj == null || getClass() != obj.getClass())return false;

        Vaccine other = (Vaccine)obj;

        return vaccineType == other.getVaccineType() &&
                name == other.getName() &&
                disease == other.getDisease();
    }

}
