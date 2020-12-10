package Validators;

import Classes.Animal;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


public class ClassValidator{

    /**
     * Validate object from class <T>
     * @param object for validation
     * @param <T> type of object
     * @throws Exception if input data is incorrect,
     * include messages about problems which happened during validation
     */
    public static<T> void validate(T object) throws Exception {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(object);

        if(violations.size() > 0){
            StringBuilder messages = new StringBuilder("\nIn ").append(object.getClass().getName()).append(":\n");
            for(ConstraintViolation<T> violation : violations){
                messages.append(violation.getMessage()).append("\n");
            }
            throw new Exception(messages.toString());
        }
    }
}
