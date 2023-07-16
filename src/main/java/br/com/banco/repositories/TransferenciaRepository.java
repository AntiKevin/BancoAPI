package br.com.banco.repositories;

import br.com.banco.entities.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    @Query("SELECT t FROM Transferencia t WHERE t.nome_operador_transacao LIKE %:nome_operador_transacao%")
    List<Transferencia> findByNomeOperadorContaining(@Param("nome_operador_transacao") String nomeOperadorTransacao);

    @Query("SELECT t FROM Transferencia t WHERE (:dataInicio IS NULL OR t.data_transferencia >= :dataInicio) AND (:dataFim IS NULL OR t.data_transferencia <= :dataFim)")
    List<Transferencia> findByDataTransferenciaBetween(@Param("dataInicio") OffsetDateTime dataInicio, @Param("dataFim") OffsetDateTime dataFim);

    @Query("SELECT t FROM Transferencia t WHERE t.nome_operador_transacao LIKE %:nomeOperador% AND (:dataInicio IS NULL OR t.data_transferencia >= :dataInicio) AND (:dataFim IS NULL OR t.data_transferencia <= :dataFim)")
    List<Transferencia> findByNomeOperadorAndDataTransferenciaBetween(@Param("nomeOperador") String nomeOperador, @Param("dataInicio") OffsetDateTime dataInicio, @Param("dataFim") OffsetDateTime dataFim);


}