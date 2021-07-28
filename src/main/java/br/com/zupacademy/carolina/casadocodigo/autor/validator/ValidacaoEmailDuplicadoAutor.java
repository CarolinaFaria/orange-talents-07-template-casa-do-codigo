package br.com.zupacademy.carolina.casadocodigo.autor.validator;


import br.com.zupacademy.carolina.casadocodigo.autor.AutorModel;
import br.com.zupacademy.carolina.casadocodigo.autor.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ValidacaoEmailDuplicadoAutor implements ConstraintValidator<EmailUnico, String> {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void initialize(EmailUnico constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<AutorModel> autor = autorRepository.findByEmail(value);

        if (autor.isPresent()) {
            return false;
        }
        return true;
    }
}