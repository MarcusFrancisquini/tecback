package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.service.AtorService;
import br.com.fujideia.iesp.tecback.model.Ator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atores")
@RequiredArgsConstructor
@Slf4j
public class AtorController {
    private final AtorService atorService;

    @GetMapping
    public List<Ator> listarTodos() {
        return atorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Ator buscarPorId(@PathVariable Long id) {
        return atorService.buscarPorId(id);
    }

    @PostMapping
    public Ator criarAtor(@RequestBody Ator ator) {
        return atorService.criar(ator);
    }

    @DeleteMapping("/{id}")
    public void deletarAtor(@PathVariable Long id) {
        atorService.deletar(id);
    }

    @PutMapping("/{id}")
    public Ator atualizar(@PathVariable Long id, @RequestBody Ator ator){
        return atorService.atualizar(id, ator);
    }
}
