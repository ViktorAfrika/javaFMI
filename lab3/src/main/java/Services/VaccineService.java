package Services;

import Classes.Vaccine;

import java.util.Comparator;

public class VaccineService {



    /////////////////////////////////          Comparators       ////////////////////////////////

    public static class TypeNameComparator implements Comparator<Vaccine>{
        @Override
        public int compare(Vaccine o1, Vaccine o2) {
            return o1.getVaccineType().name().compareTo(o2.getVaccineType().name());
        }
    }

    public static class TypeNameLengthComparator implements Comparator<Vaccine>{
        @Override
        public int compare(Vaccine o1, Vaccine o2) {
            return Integer.compare(o1.getVaccineType().name().length(),o2.getVaccineType().name().length());
        }
    }

    public static class NameLengthComparator implements Comparator<Vaccine>{
        @Override
        public int compare(Vaccine o1,Vaccine o2){
            return Integer.compare(o1.getName().length(),o2.getName().length());
        }
    }

    public static class DiseaseNameComparator implements Comparator<Vaccine>{
        @Override
        public int compare(Vaccine o1, Vaccine o2) {
            return o1.getDisease().name().compareTo(o2.getDisease().name());
        }
    }

    public static class DiseaseNameLengthComparator implements Comparator<Vaccine>{
        @Override
        public int compare(Vaccine o1, Vaccine o2) {
            return Integer.compare(o1.getDisease().name().length(),o2.getDisease().name().length());
        }
    }
}
