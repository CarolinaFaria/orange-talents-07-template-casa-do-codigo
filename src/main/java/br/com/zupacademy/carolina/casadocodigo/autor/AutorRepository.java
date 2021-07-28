package br.com.zupacademy.carolina.casadocodigo.autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository <AutorModel, Long>{


    Optional<AutorModel> findByEmail(String value);

}
