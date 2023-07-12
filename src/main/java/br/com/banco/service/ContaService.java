package br.com.banco.service;

import br.com.banco.entity.Conta;
import br.com.banco.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContaService {
    private ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public List<Conta> list() {

        return contaRepository.findAll();
    }

    public List<Conta> create(Conta conta){
        contaRepository.save(conta);
        return list();
    }

    public List<Conta> update(Conta conta){
        contaRepository.save(conta);
        return list();

    }

    public List<Conta> delete(Long id){
        contaRepository.deleteById(id);
        return list();

    }

}
