package banco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banco.domain.Permissao;
import banco.domain.Tipo;
import banco.domain.TipoPermissao;
import banco.repositories.TipoPermissaoRepository;
import banco.ws.TipoPermissaoWs;

@Service
public class TipoPermissaoService {

	@Autowired
	private TipoPermissaoRepository tipoPermissaoRepository;
	
	@Autowired
	private TipoService tipoService;
	
	@Autowired
	private PermissaoService permissaoService;
	
	public TipoPermissao salvar(TipoPermissaoWs tipoPermissaoWs) {
		TipoPermissao tipoPermissao = this.parseTipoPermissaoWsToTipoPermissao(tipoPermissaoWs);
		this.tipoPermissaoRepository.save(tipoPermissao);
		return tipoPermissao;
	}
	
	public TipoPermissao buscarPorId(Long id) {
		if (id == null) {
			return null;
		}
		Optional<TipoPermissao> tipoPermissao = this.tipoPermissaoRepository.findById(id);
		if (tipoPermissao.isPresent()) {
			return tipoPermissao.get();
		}
		return null;
	}
	
	public Iterable<TipoPermissao> listarTodos() {
		return this.tipoPermissaoRepository.findAll();
	}
	
	private Tipo obterTipo(Long idTipo) {
		Tipo tipo = this.tipoService.buscarPorId(idTipo);
		return tipo;
	}
	
	private Permissao obterPermissao(Long idPermissao) {
		Permissao permissao = this.permissaoService.buscarPorId(idPermissao);
		return permissao;
	}

	private TipoPermissao parseTipoPermissaoWsToTipoPermissao(TipoPermissaoWs tipoPermisaooWs) {
		Tipo tipo = this.obterTipo(tipoPermisaooWs.getIdTipo());
		Permissao permissao = this.obterPermissao(tipoPermisaooWs.getIdPermissao());
		TipoPermissao tipoPermissao = new TipoPermissao();
		tipoPermissao.setIdTipoPermissao(tipoPermisaooWs.getIdTipoPermissao());
		tipoPermissao.setPermissao(permissao);
		tipoPermissao.setTipo(tipo);
		return tipoPermissao;
	}
	
	
}
