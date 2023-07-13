package br.com.banco.controllers;

import br.com.banco.entitys.Conta;
import br.com.banco.services.ContaService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContaController {
    private ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping
    List<Conta> list(){return contaService.list();}

    @GetMapping("{id}")
    List<Conta> listById(@PathVariable("id") Long id){return contaService.listById(id);}

    @PostMapping
    List<Conta> create(@RequestBody @Valid Conta conta){
        return contaService.create(conta);
    }

    @PutMapping("{id}")
    List<Conta> update(@PathVariable Long id, @RequestBody Conta conta){
        return contaService.update(id, conta);
    }

    @DeleteMapping("{id}")
    List<Conta> delete(@PathVariable("id") Long id){
        return contaService.delete(id);
    }
}
