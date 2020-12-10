package Validators;

import Enums.AnimalGroup;
import Enums.Type;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AnimalTypeValidator implements ConstraintValidator<AnimalType,Type> {
    private AnimalGroup[] allowedGroups;

    @Override
    public void initialize(AnimalType constraint) {
        allowedGroups = constraint.value();
    }

    @Override
    public boolean isValid(Type type, ConstraintValidatorContext constraintValidatorContext) {
        if(type == null) return false;

        for(AnimalGroup group : allowedGroups){
            switch (group){
                case VERTEBRATES:
                    if(isVertebrates(type))return true; break;
                case INVERTEBRATES:
                    if(isInvertebrates(type))return true;
            }
        }

        return false;
    }

    private boolean isVertebrates(Type type){
        return type.equals(Type.AMPHIBIANS) ||
                type.equals(Type.BIRDS) ||
                type.equals(Type.MAMMALS) ||
                type.equals(Type.PISCES) ||
                type.equals(Type.REPTILES);
    }

    private boolean isInvertebrates(Type type){
        return type.equals(Type.ARACHNIDS) ||
                type.equals(Type.CLAMS) ||
                type.equals(Type.INSECTS) ||
                type.equals(Type.SHELLFISH);
    }

}
