package br.com.zupacademy.carolina.casadocodigo.categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

    Optional<CategoriaModel> findByNome(String value);
}
