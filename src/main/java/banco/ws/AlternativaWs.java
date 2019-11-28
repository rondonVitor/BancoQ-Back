package banco.ws;

import javax.validation.constraints.NotNull;

public class AlternativaWs {
	
	private Long idAlternativa;
	
	@NotNull(message = "É obrigatório informar a alternativa correta!")
	private int correta;
	
	@NotNull(message = "É obrigatório informar a alternativa!")
	private String alternativa;
	
	@NotNull(message = "É obrigatório informar a questão!")
	private Long idQuestao;

	public Long getIdAlternativa() {
		return idAlternativa;
	}

	public void setIdAlternativa(Long idAlternativa) {
		this.idAlternativa = idAlternativa;
	}

	public int getCorreta() {
		return correta;
	}

	public void setCorreta(int correta) {
		this.correta = correta;
	}

	public Long getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(Long idQuestao) {
		this.idQuestao = idQuestao;
	}

	public String getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(String alternativa) {
		this.alternativa = alternativa;
	}

}
