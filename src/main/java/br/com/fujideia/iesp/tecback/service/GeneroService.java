package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Genero;
import br.com.fujideia.iesp.tecback.repository.GeneroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GeneroService {
    private final GeneroRepository generoRepository;

    public List<Genero> listarTodos() {
        return generoRepository.findAll();
    }

    public Genero buscarPorId(Long id) {
        return generoRepository.findById(id).orElse(null);
    }

    public Genero criar(Genero genero) {
        return generoRepository.save(genero);
    }

    public void deletar(Long id) {
        generoRepository.deleteById(id);
    }

    public Genero atualizar(Long id, Genero generoAtualizado){
        Optional<Genero> generoExistente = generoRepository.findById(id);
        if (generoExistente.isPresent()){
            Genero genero = generoExistente.get();
            genero.setNome(generoAtualizado.getNome());
            return generoRepository.save(genero);
        } else {
            return null;
        }
    }
}
