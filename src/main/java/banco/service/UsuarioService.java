package banco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banco.domain.Dificuldade;
import banco.domain.Perfil;
import banco.domain.Questao;
import banco.domain.UnidadeCurricular;
import banco.domain.Usuario;
import banco.repositories.UsuarioRepository;
import banco.ws.QuestaoWs;
import banco.ws.UsuarioWs;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PerfilService perfilService;
	
	public Usuario salvar(UsuarioWs usuarioWs) {
		Usuario usuario = this.parseUsuarioWsToUsuario(usuarioWs);
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
	
	private Perfil obterPerfil(Long idPerfil) {
		Perfil perfil = this.perfilService.buscarPorId(idPerfil);
		return perfil;
	}
	
	private Usuario parseUsuarioWsToUsuario(UsuarioWs usuarioWs) {
		Perfil perfil = this.obterPerfil(usuarioWs.getIdPerfil());
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(usuarioWs.getIdUsuario());
		usuario.setEmail(usuarioWs.getEmail());
		usuario.setSenha(usuarioWs.getSenha());
		usuario.setPerfil(perfil);
		return usuario;
	}
	
}
