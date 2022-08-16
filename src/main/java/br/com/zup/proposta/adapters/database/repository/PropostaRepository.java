package br.com.zup.proposta.adapters.database.repository;

import br.com.zup.proposta.adapters.database.entities.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {

    @Query("SELECT d FROM Proposta d WHERE d.documento =:documentoParam")
    public Optional<Proposta> findByDocumento(@Param("documentoParam") String documento);
}
