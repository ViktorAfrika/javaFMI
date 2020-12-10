package Validators;


import Enums.AnimalGroup;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Validates the type of animal according to the group of animal
 */
@Documented
@Constraint(validatedBy = AnimalTypeValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnimalType {
    String message() default "It is incorrect type";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    AnimalGroup[] value() default {};
}
