package br.com.banco.services;

import br.com.banco.Exceptions.BadRequestException;
import br.com.banco.entitys.Conta;
import br.com.banco.repositorys.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ContaService {
    private ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public List<Conta> list() {

        return contaRepository.findAll();
    }

    public List<Conta> listById(Long id) {
        Optional<Conta> contaOptional = contaRepository.findById(id);

        if (contaOptional.isPresent()) {
            return List.of(contaOptional.get());
        } else {
            throw new BadRequestException("Conta com o id inserido não existe!");
        }
    }

    public List<Conta> create(Conta conta){
        contaRepository.save(conta);
        return list();
    }

    public List<Conta> update(Long id, Conta conta){
        contaRepository.findById(id).ifPresentOrElse((existingConta) -> {
            conta.setId_conta(id);
            contaRepository.save(conta);
        }, () -> {
            throw new BadRequestException("Conta com o id inserido não existe!");
        });
        return list();

    }

    public List<Conta> delete(Long id){
        contaRepository.deleteById(id);
        return list();

    }

}
