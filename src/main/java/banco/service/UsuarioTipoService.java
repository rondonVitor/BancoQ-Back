package banco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banco.domain.Tipo;
import banco.domain.Usuario;
import banco.domain.UsuarioTipo;
import banco.repositories.UsuarioTipoRepository;
import banco.ws.UsuarioTipoWs;

@Service
public class UsuarioTipoService {

	@Autowired
	private UsuarioTipoRepository usuarioTipoRepository;
	
	@Autowired
	private TipoService tipoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public UsuarioTipo salvar(UsuarioTipoWs usuarioTipoWs) {
		UsuarioTipo usuarioTipo = this.parseUsuarioTipoWsToUsuarioTipo(usuarioTipoWs);
		this.usuarioTipoRepository.save(usuarioTipo);
		return usuarioTipo;
	}
	
	public UsuarioTipo buscarPorId(Long id) {
		if (id == null) {
			return null;
		}
		Optional<UsuarioTipo> usuarioTipo = this.usuarioTipoRepository.findById(id);
		if (usuarioTipo.isPresent()) {
			return usuarioTipo.get();
		}
		return null;
	}
	
	public Iterable<UsuarioTipo> listarTodos() {
		return this.usuarioTipoRepository.findAll();
	}
	
	private Tipo obterTipo(Long idTipo) {
		Tipo tipo = this.tipoService.buscarPorId(idTipo);
		return tipo;
	}
	
	private Usuario obterUsuario(Long idUsuario) {
		Usuario usuario = this.usuarioService.buscarPorId(idUsuario);
		return usuario;
	}

	private UsuarioTipo parseUsuarioTipoWsToUsuarioTipo(UsuarioTipoWs usuarioTipoWs) {
		Tipo tipo = this.obterTipo(usuarioTipoWs.getIdTipo());
		Usuario usuario = this.obterUsuario(usuarioTipoWs.getIdUsuario());
		UsuarioTipo usuarioTipo = new UsuarioTipo();
		usuarioTipo.setIdUsuarioTipo(usuarioTipoWs.getIdUsuarioTipo());
		usuarioTipo.setUsuario(usuario);
		usuarioTipo.setTipo(tipo);
		return usuarioTipo;
	}
	
}
