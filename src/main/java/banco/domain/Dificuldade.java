package banco.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "dificuldade")
public class Dificuldade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddificuldade")
	private Long idDificuldade;
	
	@Column(name = "dificuldade", length = 40, nullable = false)
	private String dificuldade;
	
	@OneToMany(mappedBy = "dificuldade", targetEntity = Questao.class)
	@JsonIgnore
	private List<Questao> questoes;

	public Long getIdDificuldade() {
		return idDificuldade;
	}

	public void setIdDificuldade(Long idDificuldade) {
		this.idDificuldade = idDificuldade;
	}

	public String getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(String dificuldade) {
		this.dificuldade = dificuldade;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}
	
}
