package br.com.banco.repositorys;

import br.com.banco.entitys.Transferencia;
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

    @Query("SELECT t FROM Transferencia t WHERE t.data_transferencia >= :dataInicio AND t.data_transferencia <= :dataFim")
    List<Transferencia> findByDataTransferenciaBetween(@Param("dataInicio") OffsetDateTime dataInicio, @Param("dataFim") OffsetDateTime dataFim);


}