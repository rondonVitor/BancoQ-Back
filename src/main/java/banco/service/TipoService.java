package banco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banco.domain.Tipo;
import banco.repositories.TipoRepository;

@Service
public class TipoService {

	@Autowired
	private TipoRepository tipoRepository;
	
	public Tipo salvar(Tipo tipo) {
		this.tipoRepository.save(tipo);
		return tipo;
	}
	
	public Tipo buscarPorId(Long id) {
		if (id == null) {
			return null;
		}
		Optional<Tipo> tipo = this.tipoRepository.findById(id);
		if (tipo.isPresent()) {
			return tipo.get();
		}
		return null;
	}
	
	public Iterable<Tipo> listarTodos() {
		return this.tipoRepository.findAll();
	}
}
