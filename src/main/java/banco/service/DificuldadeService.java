package banco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banco.domain.Dificuldade;
import banco.repositories.DificuldadeRepository;

@Service
public class DificuldadeService {

	@Autowired
	private DificuldadeRepository dificuldadeRepository;
	
	public Dificuldade salvar(Dificuldade dificuldade) {
		this.dificuldadeRepository.save(dificuldade);
		return dificuldade;
	}
	
	public Dificuldade buscarPorId(Long id) {
		if (id == null) {
			return null;
		}
		Optional<Dificuldade> dificuldade = this.dificuldadeRepository.findById(id);
		if (dificuldade.isPresent()) {
			return dificuldade.get();
		}
		return null;
	}
	
	public Iterable<Dificuldade> listarTodos() {
		return this.dificuldadeRepository.findAll();
	}
	
}
