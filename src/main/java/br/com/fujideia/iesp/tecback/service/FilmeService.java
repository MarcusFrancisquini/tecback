package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.repository.FilmeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public List<Filme> listarTodos() {
        return filmeRepository.findAll();
    }

    public Filme buscarPorId(Long id) {
        return filmeRepository.findById(id).orElse(null);
    }

    public Filme criar(Filme filme) {
        return filmeRepository.save(filme);
    }

    public void deletar(Long id) {
        filmeRepository.deleteById(id);
    }

    public Filme atualizar(Long id, Filme filmeAtualizado){
        Optional<Filme> filmeExistente = filmeRepository.findById(id);
        if (filmeExistente.isPresent()){
            Filme filme = filmeExistente.get();
            filme.setTitulo(filmeAtualizado.getTitulo());
            filme.setAnoLancamento(filmeAtualizado.getAnoLancamento());
            return filmeRepository.save(filme);
        } else {
            return null;
        }
    }
}
