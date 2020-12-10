package Services;

import Classes.Animal;
import Classes.Vaccine;
import Enums.Disease;
import Enums.VaccineType;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalService {
    private Animal animal;

    public AnimalService(Animal animal) {
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public List<Vaccine> sortVaccines(){
        Collections.sort(animal.getVaccines());
        return animal.getVaccines();
    }


    public List<Vaccine> vaccinesFromDisease(Disease disease){
        return animal.getVaccines().stream().filter(x -> x.getDisease().equals(disease)).collect(Collectors.toList());
    }

    public List<Vaccine> vaccinesWithType(VaccineType vaccineType){
        return animal.getVaccines().stream().filter(x -> x.getVaccineType().equals(vaccineType)).collect(Collectors.toList());
    }

    ///////////////////////////     sorting    /////////////////////////

    public List<Vaccine> sortVaccinesWithStream(){
        return animal.getVaccines().stream().sorted().collect(Collectors.toList());
    }

    public List<Vaccine> sortVaccinesByNameLength(){
        animal.getVaccines().sort(new VaccineService.NameLengthComparator());
        return animal.getVaccines();
    }

    public List<Vaccine> sortVaccinesByNameLengthWithStream(){
        return animal.getVaccines().stream().sorted(new VaccineService.NameLengthComparator()).collect(Collectors.toList());
    }

    public List<Vaccine> sortVaccinesByTypeName(){
        animal.getVaccines().sort(new VaccineService.TypeNameComparator());
        return animal.getVaccines();
    }

    public List<Vaccine> sortVaccinesByTypeNameWithStream(){
        return animal.getVaccines().stream().sorted(new VaccineService.TypeNameComparator()).collect(Collectors.toList());
    }

    public List<Vaccine> sortVaccinesByTypeNameLength(){
        animal.getVaccines().sort(new VaccineService.TypeNameLengthComparator());
        return animal.getVaccines();
    }

    public List<Vaccine> sortVaccinesByTypeNameLengthWithStream(){
        return animal.getVaccines().stream().sorted(new VaccineService.TypeNameLengthComparator()).collect(Collectors.toList());
    }

    public List<Vaccine> sortVaccinesByDiseaseName(){
        animal.getVaccines().sort(new VaccineService.DiseaseNameComparator());
        return animal.getVaccines();
    }

    public List<Vaccine> sortVaccinesByDiseaseNameWithStream(){
        return animal.getVaccines().stream().sorted(new VaccineService.DiseaseNameComparator()).collect(Collectors.toList());
    }

    public List<Vaccine> sortVaccinesByDiseaseNameLength(){
        animal.getVaccines().sort(new VaccineService.DiseaseNameLengthComparator());
        return animal.getVaccines();
    }

    public List<Vaccine> sortVaccinesByDiseaseNameLengthWithStream(){
        return animal.getVaccines().stream().sorted(new VaccineService.DiseaseNameLengthComparator()).collect(Collectors.toList());
    }

    /////////////////////////////////          Comparators       ////////////////////////////////

    public static class BirthDateComparator implements Comparator<Animal> {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
        }
    }

    public static class TypeNameComparator implements Comparator<Animal>{
        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.getType().name().compareTo(o2.getType().name());
        }
    }

    public static class TypeNameLengthComparator implements Comparator<Animal>{
        @Override
        public int compare(Animal o1, Animal o2) {
            return Integer.compare(o1.getType().name().length(),o2.getType().name().length());
        }
    }

    public static class NameLengthComparator implements Comparator<Animal>{
        @Override
        public int compare(Animal o1,Animal o2){
            return Integer.compare(o1.getName().length(),o2.getName().length());
        }
    }
}
