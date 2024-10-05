package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Diretor;
import br.com.fujideia.iesp.tecback.repository.DiretorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiretorService {
    private final DiretorRepository diretorRepository;

    public List<Diretor> listarTodos() {
        return diretorRepository.findAll();
    }

    public Diretor buscarPorId(Long id) {
        return diretorRepository.findById(id).orElse(null);
    }

    public Diretor criar(Diretor diretor) {
        return diretorRepository.save(diretor);
    }

    public void deletar(Long id) {
        diretorRepository.deleteById(id);
    }

    public Diretor atualizar(Long id, Diretor diretorAtualizado){
        Optional<Diretor> diretorExistente = diretorRepository.findById(id);
        if (diretorExistente.isPresent()){
            Diretor diretor = diretorExistente.get();
            diretor.setNome(diretorAtualizado.getNome());
            return diretorRepository.save(diretor);
        } else {
            return null;
        }
    }
}
