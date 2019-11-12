package banco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banco.domain.Usuario;
import banco.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario salvar(Usuario usuario) {
		this.usuarioRepository.save(usuario);
		return usuario;
	}
	
	public Usuario buscarPorId(Long id) {
		if (id == null) {
			return null;
		}
		Optional<Usuario> usuario = this.usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return usuario.get();
		}
		return null;
	}
	
	public Iterable<Usuario> listarTodos() {
		return this.usuarioRepository.findAll();
	}
	
}
