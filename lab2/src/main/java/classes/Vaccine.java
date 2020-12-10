package classes;

import interfaces.*;
import enums.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * the class characterizes vaccine that
 * vaccinate animals in the zoo
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Vaccine implements Serializable, CanSerialize {
    // required parameters
    @XmlAttribute(name = "enums.VaccineType")
    private VaccineType vaccineType;
    @XmlAttribute(name = "enums.Disease")
    private Disease disease;

    // optional parameters
    @XmlAttribute(name = "Name")
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

        public Vaccine build(){
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
                name.equals(other.getName()) &&
                disease == other.getDisease();
    }

    //////////////////////  overrides methods from interfaces.CanSerialize  ////////////////////
    @Override
    public List<Object> fieldsToList() {
        List<Object> list = new ArrayList<>();
        list.add(vaccineType);
        list.add(disease);
        list.add(name);
        return list;
    }

    @Override
    public void listToFields(List<Object> list) {
        vaccineType = VaccineType.valueOf((String)list.get(0));
        disease = Disease.valueOf((String)list.get(1));
        name = (String)list.get(2);
    }
}
