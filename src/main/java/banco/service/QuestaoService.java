package banco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banco.domain.Questao;
import banco.domain.UnidadeCurricular;
import banco.domain.Usuario;
import banco.repositories.QuestaoRepository;
import banco.ws.QuestaoWs;

@Service
public class QuestaoService {

	@Autowired
	private QuestaoRepository questaoRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UnidadeCurricularService ucService;
	
	public Questao salvar(QuestaoWs questaoWs) {
		Questao questao = this.parseQuestaoWsToQuestao(questaoWs);
		this.questaoRepository.save(questao);
		return questao;
	}
	
	public Questao buscarPorId(Long id) {
		if (id == null) {
			return null;
		}
		Optional<Questao> questao = this.questaoRepository.findById(id);
		if (questao.isPresent()) {
			return questao.get();
		}
		return null;
	}
	
	public Iterable<Questao> listarTodos() {
		return this.questaoRepository.findAll();
	}
	
	private Usuario obterUsuario(Long idUsuario) {
		Usuario usuario = this.usuarioService.buscarPorId(idUsuario);
		return usuario;
	}
	
	private UnidadeCurricular obterUc(Long idUc) {
		UnidadeCurricular uc = this.ucService.buscarPorId(idUc);
		return uc;
	}
	
	private Questao parseQuestaoWsToQuestao(QuestaoWs questaoWs) {
		Usuario usuario = this.obterUsuario(questaoWs.getIdUsuario());
		UnidadeCurricular uc = this.obterUc(questaoWs.getIdUc());
		Questao questao = new Questao();
		questao.setIdQuestao(questaoWs.getIdQuestao());
		questao.setEnunciado(questaoWs.getEnunciado());
		questao.setComando(questaoWs.getComando());
		questao.setSuporte(questaoWs.getSuporte());
		questao.setAtivo(questaoWs.getAtivo());
		questao.setUsuario(usuario);
		questao.setUnidadeCurricular(uc);
		return questao;
	}
	
}
