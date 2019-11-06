package banco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banco.domain.UnidadeCurricular;
import banco.repositories.UnidadeCurricularRepository;

@Service
public class UnidadeCurricularService {

	@Autowired
	private UnidadeCurricularRepository ucRepository;
	
	public UnidadeCurricular salvar(UnidadeCurricular uc) {
		this.ucRepository.save(uc);
		return uc;
	}
	
	public UnidadeCurricular buscarPorId(Long id) {
		if (id == null) {
			return null;
		}
		Optional<UnidadeCurricular> uc = this.ucRepository.findById(id);
		if (uc.isPresent()) {
			return uc.get();
		}
		return null;
	}
	
	public Iterable<UnidadeCurricular> listarTodos() {
		return this.ucRepository.findAll();
	}
	
}
