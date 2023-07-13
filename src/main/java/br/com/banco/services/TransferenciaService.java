package br.com.banco.services;

import br.com.banco.Exceptions.BadRequestException;
import br.com.banco.entitys.Transferencia;
import br.com.banco.repositorys.TransferenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaService {
    private TransferenciaRepository transferenciaRepository;

    public TransferenciaService(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }
    public List<Transferencia> list() {

        return transferenciaRepository.findAll();
    }

    public List<Transferencia> listById(Long id) {
        Optional<Transferencia> transferenciaOptional = transferenciaRepository.findById(id);

        if (transferenciaOptional.isPresent()) {
            return List.of(transferenciaOptional.get());
        } else {
            throw new BadRequestException("transferencia com o id inserido não existe!");
        }
    }

    public List<Transferencia> create(Transferencia transferencia){
        transferenciaRepository.save(transferencia);
        return list();
    }

    public List<Transferencia> update(Long id, Transferencia transferencia){
        transferenciaRepository.findById(id).ifPresentOrElse((existingTransferencia) -> {
            transferencia.setId(id);
            transferenciaRepository.save(transferencia);
        }, () -> {
            throw new BadRequestException("transferencia com o id inserido não existe!");
        });
        return list();

    }

    public List<Transferencia> delete(Long id){

        transferenciaRepository.findById(id).ifPresentOrElse((existingTransferencia) -> {
            transferenciaRepository.deleteById(id);
        }, () -> {
            throw new BadRequestException("transferencia com o id inserido não existe!");
        });
        return list();
    }

}
