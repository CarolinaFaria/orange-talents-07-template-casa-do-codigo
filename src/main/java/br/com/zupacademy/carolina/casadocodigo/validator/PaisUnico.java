package br.com.zupacademy.carolina.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {PaisUnicoValidator.class})
public @interface PaisUnico {

    String message() default "Valor já existe no banco de dados";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
