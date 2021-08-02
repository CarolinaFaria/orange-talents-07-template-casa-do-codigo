package br.com.zupacademy.carolina.casadocodigo.pais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

    Pais getById(Long idPais);

}
