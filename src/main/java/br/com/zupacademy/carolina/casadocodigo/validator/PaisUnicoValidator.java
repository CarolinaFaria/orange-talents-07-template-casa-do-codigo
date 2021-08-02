package br.com.zupacademy.carolina.casadocodigo.validator;

import br.com.zupacademy.carolina.casadocodigo.estado.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PaisUnicoValidator implements ConstraintValidator<PaisUnico, Object> {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public void initialize(PaisUnico constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return estadoRepository.findByPaisId(value).isEmpty();
    }
}
