package banco.ws;

import javax.validation.constraints.NotNull;

public class QuestaoWs {
	
	private Long idQuestao;
	
	private String enunciado;

	private String comando;

	private String suporte;

	private int ativo;

	@NotNull(message = "É obrigatório informar o usuário!")
	private Long idUsuario;

	@NotNull(message = "É obrigatório informar a unidade curricular!")
	private Long idUc;

	public Long getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(Long idQuestao) {
		this.idQuestao = idQuestao;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getComando() {
		return comando;
	}

	public void setComando(String comando) {
		this.comando = comando;
	}

	public String getSuporte() {
		return suporte;
	}

	public void setSuporte(String suporte) {
		this.suporte = suporte;
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

	public Long getIdUc() {
		return idUc;
	}

	public void setIdUc(Long idUc) {
		this.idUc = idUc;
	}
	

}
