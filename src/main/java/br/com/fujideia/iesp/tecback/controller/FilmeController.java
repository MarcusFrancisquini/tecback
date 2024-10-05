package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.service.FilmeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
@Slf4j
public class FilmeController {

    private final FilmeService filmeService;

    @GetMapping
    public List<Filme> listarTodos() {
        return filmeService.listarTodos();
    }

    @GetMapping("/{id}")
    public Filme buscarPorId(@PathVariable Long id) {
        return filmeService.buscarPorId(id);
    }

    @PostMapping
    public Filme criarFilme(@RequestBody Filme filme) {
        return filmeService.criar(filme);
    }

    @DeleteMapping("/{id}")
    public void deletarFilme(@PathVariable Long id) {
        filmeService.deletar(id);
    }

    @PutMapping("/{id}")
    public Filme atualizar(@PathVariable Long id, @RequestBody Filme filme){
        return filmeService.atualizar(id, filme);
    }
}
