package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Ator;
import br.com.fujideia.iesp.tecback.repository.AtorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AtorService {
    private final AtorRepository atorRepository;

    public List<Ator> listarTodos() {
        return atorRepository.findAll();
    }

    public Ator buscarPorId(Long id) {
        return atorRepository.findById(id).orElse(null);
    }

    public Ator criar(Ator ator) {
        return atorRepository.save(ator);
    }

    public void deletar(Long id) {
        atorRepository.deleteById(id);
    }

    public Ator atualizar(Long id, Ator atorAtualizado){
        Optional<Ator> atorExistente = atorRepository.findById(id);
        if (atorExistente.isPresent()){
            Ator ator = atorExistente.get();
            ator.setNome(atorAtualizado.getNome());
            return atorRepository.save(ator);
        } else {
            return null;
        }
    }
}
