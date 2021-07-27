package br.com.zupacademy.carolina.casadocodigo.Autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository <AutorModel, Long>{

}
