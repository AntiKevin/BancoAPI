package br.com.banco.controller;

import br.com.banco.entity.Conta;
import br.com.banco.service.ContaService;
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

    @PostMapping
    List<Conta> create(@RequestBody @Valid Conta conta){
        return contaService.create(conta);
    }

    @GetMapping
    List<Conta> list(){
        return contaService.list();
    }
    @PutMapping
    List<Conta> update(@RequestBody Conta conta){
        return contaService.update(conta);
    }

    @DeleteMapping("{id}")
    List<Conta> delete(@PathVariable("id") Long id){
        return contaService.delete(id);
    }
}
