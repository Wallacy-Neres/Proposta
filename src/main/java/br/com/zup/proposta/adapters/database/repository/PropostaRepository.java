package br.com.zup.proposta.adapters.database.repository;

import br.com.zup.proposta.adapters.database.entities.Proposta;
import br.com.zup.proposta.enums.StatusProposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {

    @Query("SELECT d FROM Proposta d WHERE d.documento =:documentoParam")
    public Optional<Proposta> findByDocumento(@Param("documentoParam") String documento);

    @Modifying
    @Transactional
    @Query("UPDATE Proposta p SET p.statusProposta =:statusParam WHERE p.documento =:documentoParam")
    public void atualizaStatusProposta(@Param("statusParam") StatusProposta status, @Param("documentoParam") String documento);


}
