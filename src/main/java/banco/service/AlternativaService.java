package banco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banco.domain.Alternativa;
import banco.domain.Questao;
import banco.repositories.AlternativaRepository;
import banco.ws.AlternativaWs;

@Service
public class AlternativaService {
	
	@Autowired
	private AlternativaRepository alternativaRepository;
	
	@Autowired
	private QuestaoService questaoService;
	
	public Alternativa salvar(AlternativaWs alternativaWs) {
		Alternativa alternativa = this.parseAlternativaWsToAlternativa(alternativaWs);
		this.alternativaRepository.save(alternativa);
		return alternativa;
	}
	
	public Alternativa buscarPorId(Long id) {
		if (id == null) {
			return null;
		}
		Optional<Alternativa> alternativa = this.alternativaRepository.findById(id);
		if (alternativa.isPresent()) {
			return alternativa.get();
		}
		return null;
	}
	
	public Iterable<Alternativa> listarTodos() {
		return this.alternativaRepository.findAll();
	}
	
	private Questao obterQuestao(Long idQuestao) {
		Questao questao = this.questaoService.buscarPorId(idQuestao);
		return questao;
	}
	
	private Alternativa parseAlternativaWsToAlternativa(AlternativaWs alternativaWs) {
		Questao questao = this.obterQuestao(alternativaWs.getIdQuestao());
		Alternativa alternativa = new Alternativa();
		alternativa.setIdAlternativa(alternativaWs.getIdAlternativa());
		alternativa.setCorreta(alternativaWs.getCorreta());
		alternativa.setAlternativa(alternativaWs.getAlternativa());
		alternativa.setQuestao(questao);
		return alternativa;
	}

}
