package pl.coderslab.spring01hibernatekrkw01.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IsOverXYOValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsOverXYO {
    int value();
    String message() default "{isOverXYO.error.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
