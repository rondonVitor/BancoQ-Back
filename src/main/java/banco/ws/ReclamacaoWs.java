package banco.ws;

import javax.validation.constraints.NotNull;

public class ReclamacaoWs {

	private Long idReclamacao;

	private String reclamacao;
	
	private int ativo;

	@NotNull(message = "É obrigatório informar o usuario!")
	private Long idUsuario;
	
	@NotNull(message = "É obrigatório informar a questao!")
	private Long idQuestao;

	public Long getIdReclamacao() {
		return idReclamacao;
	}

	public void setIdReclamacao(Long idReclamacao) {
		this.idReclamacao = idReclamacao;
	}

	public String getReclamacao() {
		return reclamacao;
	}

	public void setReclamacao(String reclamacao) {
		this.reclamacao = reclamacao;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(Long idQuestao) {
		this.idQuestao = idQuestao;
	}
	
}
