package banco.ws;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class UnidadeCurricularWs {

	private Long idUc;

	@NotNull(message = "É obrigatório informar o nome!")
	@Column(name = "nome", length = 150, nullable = false)
	private String nome;
	
	@NotNull(message = "É obrigatório informar o numero!")
	@Column(name = "numero", length = 20, nullable = false)
	private String numero;
	
	@NotNull(message = "É obrigatório informar o idCurso!")
	private Long idCurso;

	public Long getIdUc() {
		return idUc;
	}

	public void setIdUc(Long idUc) {
		this.idUc = idUc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}
	
}
