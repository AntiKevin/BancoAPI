package br.com.banco.repositorys;

import br.com.banco.entitys.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
