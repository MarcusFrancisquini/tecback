package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.service.GeneroService;
import br.com.fujideia.iesp.tecback.model.Genero;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
@RequiredArgsConstructor
@Slf4j
public class GeneroController {
    private final GeneroService generoService;

    @GetMapping
    public List<Genero> listarTodos() {
        return generoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Genero buscarPorId(@PathVariable Long id) {
        return generoService.buscarPorId(id);
    }

    @PostMapping
    public Genero criarGenero(@RequestBody Genero genero) {
        return generoService.criar(genero);
    }

    @DeleteMapping("/{id}")
    public void deletarGenero(@PathVariable Long id) {
        generoService.deletar(id);
    }

    @PutMapping("/{id}")
    public Genero atualizar(@PathVariable Long id, @RequestBody Genero genero){
        return generoService.atualizar(id, genero);
    }
}
