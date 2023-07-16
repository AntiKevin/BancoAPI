package br.com.banco.controllers;

import br.com.banco.entities.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.services.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.OffsetDateTime;
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
    public List<Transferencia> list(
            @RequestParam(value = "nomeOperador", required = false) String nomeOperador,
            @RequestParam(value = "dataInicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime dataInicio,
            @RequestParam(value = "dataFim", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime dataFim) {
        if (nomeOperador != null) {
            return transferenciaRepository.findByNomeOperadorContaining(nomeOperador);
        } else if (dataInicio != null && dataFim != null) {
            return transferenciaRepository.findByDataTransferenciaBetween(dataInicio, dataFim);
        } else {
            return transferenciaRepository.findAll();
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
