package banco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banco.domain.Permissao;
import banco.repositories.PermissaoRepository;

@Service
public class PermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	public Permissao salvar(Permissao permissao) {
		this.permissaoRepository.save(permissao);
		return permissao;
	}
	
	public Permissao buscarPorId(Long id) {
		if (id == null) {
			return null;
		}
		Optional<Permissao> permissao = this.permissaoRepository.findById(id);
		if (permissao.isPresent()) {
			return permissao.get();
		}
		return null;
	}
	
	public Iterable<Permissao> listarTodos() {
		return this.permissaoRepository.findAll();
	}
}
