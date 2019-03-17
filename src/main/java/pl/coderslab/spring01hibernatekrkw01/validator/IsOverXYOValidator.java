package pl.coderslab.spring01hibernatekrkw01.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class IsOverXYOValidator
        implements ConstraintValidator<IsOverXYO, Integer> {

    private int ageLimit;

    @Override
    public void initialize(IsOverXYO isOverXYO) {
        this.ageLimit = isOverXYO.value();
    }

    @Override
    public boolean isValid(Integer yearOfBirth, ConstraintValidatorContext constraintValidatorContext) {
        return LocalDate.now().getYear() - yearOfBirth > this.ageLimit;
    }
}
