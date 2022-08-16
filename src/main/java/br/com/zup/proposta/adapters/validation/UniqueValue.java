package br.com.zup.proposta.adapters.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueValueValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {

    String message() default "Já existe um registe deste tipo no banco de dados";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
    String fieldName();
    Class<?> domainClass();

}
