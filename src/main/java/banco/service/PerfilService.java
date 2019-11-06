package banco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banco.domain.Perfil;
import banco.repositories.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;
	
	public Perfil salvar(Perfil perfil) {
		this.perfilRepository.save(perfil);
		return perfil;
	}
	
	public Perfil buscarPorId(Long id) {
		if (id == null) {
			return null;
		}
		Optional<Perfil> perfil = this.perfilRepository.findById(id);
		if (perfil.isPresent()) {
			return perfil.get();
		}
		return null;
	}
	
	public Iterable<Perfil> listarTodos() {
		return this.perfilRepository.findAll();
	}
	
}
