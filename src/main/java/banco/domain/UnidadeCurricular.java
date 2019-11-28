package banco.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "unidade_curricular")
public class UnidadeCurricular {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iduc")
	private Long idUc;

	@Column(name = "nome", length = 150, nullable = false)
	private String nome;
	
	@Column(name = "numero", length = 20, nullable = false)
	private String numero;
	
	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "idcurso")
	private Curso curso;

	@OneToMany(mappedBy = "unidadeCurricular", targetEntity = Questao.class)
	@JsonIgnore
	private List<Questao> questoes;
	
	public Long getId() {
		return idUc;
	}

	public void setId(Long id) {
		this.idUc = id;
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

	public Long getIdUc() {
		return idUc;
	}

	public void setIdUc(Long idUc) {
		this.idUc = idUc;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	
}
