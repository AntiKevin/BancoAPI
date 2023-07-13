package br.com.banco.controllers;

import br.com.banco.entitys.Transferencia;
import br.com.banco.repositorys.TransferenciaRepository;
import br.com.banco.services.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/transferencia")
public class TransferenciaController {

    private TransferenciaService transferenciaService;

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @GetMapping()
    public List<Transferencia> list(@RequestParam(value = "nome_operador", required = false) String nomeOperador) {
        if (nomeOperador != null) {
            return transferenciaRepository.findByNomeOperadorContaining(nomeOperador);
        } else {
            return transferenciaService.list();
        }
    }

    @GetMapping("{id}")
    List<Transferencia> listById(@PathVariable("id") Long id){return transferenciaService.listById(id);}

    @PostMapping
    List<Transferencia> create(@RequestBody @Valid Transferencia transferencia){
        return transferenciaService.create(transferencia);
    }

    @PutMapping("{id}")
    List<Transferencia> update(@PathVariable Long id, @RequestBody Transferencia transferencia){
        return transferenciaService.update(id, transferencia);
    }

    @DeleteMapping("{id}")
    List<Transferencia> delete(@PathVariable("id") Long id){
        return transferenciaService.delete(id);
    }

}
