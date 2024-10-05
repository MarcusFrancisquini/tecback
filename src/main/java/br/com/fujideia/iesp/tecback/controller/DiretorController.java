package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Diretor;
import br.com.fujideia.iesp.tecback.service.DiretorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretores")
@RequiredArgsConstructor
@Slf4j
public class DiretorController {
    private final DiretorService diretorService;

    @GetMapping
    public List<Diretor> listarTodos() {
        return diretorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Diretor buscarPorId(@PathVariable Long id) {
        return diretorService.buscarPorId(id);
    }

    @PostMapping
    public Diretor criarDiretor(@RequestBody Diretor diretor) {
        return diretorService.criar(diretor);
    }

    @DeleteMapping("/{id}")
    public void deletarDiretor(@PathVariable Long id) {
        diretorService.deletar(id);
    }

    @PutMapping("/{id}")
    public Diretor atualizar(@PathVariable Long id, @RequestBody Diretor diretor){
        return diretorService.atualizar(id, diretor);
    }
}
