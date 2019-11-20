package banco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banco.domain.Questao;
import banco.domain.Reclamacao;
import banco.domain.Usuario;
import banco.repositories.ReclamacaoRepository;
import banco.ws.ReclamacaoWs;

@Service
public class ReclamacaoService {

	@Autowired
	private ReclamacaoRepository reclamacaoRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private QuestaoService questaoService;
	
	public Reclamacao salvar(ReclamacaoWs reclamacaoWs) {
		Reclamacao reclamacao = this.parseReclamacaoWsToReclamacao(reclamacaoWs);
		this.reclamacaoRepository.save(reclamacao);
		return reclamacao;
	}
	
	public Reclamacao buscarPorId(Long id) {
		if (id == null) {
			return null;
		}
		Optional<Reclamacao> reclamacao = this.reclamacaoRepository.findById(id);
		if (reclamacao.isPresent()) {
			return reclamacao.get();
		}
		return null;
	}
	
	public Iterable<Reclamacao> listarTodos() {
		return this.reclamacaoRepository.findAll();
	}
	
	private Usuario obterUsuario(Long idUsuario) {
		Usuario usuario = this.usuarioService.buscarPorId(idUsuario);
		return usuario;
	}
	
	private Questao obterQuestao(Long idQuestao) {
		Questao questao = this.questaoService.buscarPorId(idQuestao);
		return questao;
	}
	
	private Reclamacao parseReclamacaoWsToReclamacao(ReclamacaoWs reclamacaoWs) {
		Usuario usuario = this.obterUsuario(reclamacaoWs.getIdUsuario());
		Questao questao = this.obterQuestao(reclamacaoWs.getIdQuestao());
		Reclamacao reclamacao = new Reclamacao();
		reclamacao.setIdReclamacao(reclamacaoWs.getIdReclamacao());
		reclamacao.setReclamacao(reclamacaoWs.getReclamacao());
		reclamacao.setAtivo(reclamacaoWs.getAtivo());
		reclamacao.setUsuario(usuario);
		reclamacao.setQuestao(questao);
		return reclamacao;
	}
	
}
