package banco.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alternativa")
public class Alternativa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idalternativa")
	private Long idAlternativa;
	
	@Column(name = "correta", length = 1, nullable = false)
	private int correta;
	
	@Column(name = "alternativa", length = 300, nullable = false)
	private String alternativa;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "idquestao")
	private Questao questao;

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

	public String getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(String alternativa) {
		this.alternativa = alternativa;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

}
