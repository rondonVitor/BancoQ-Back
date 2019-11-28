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
@Table(name = "curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcurso")
	private Long idCurso;

	@Column(name = "nome", length = 150, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "curso", targetEntity = UnidadeCurricular.class)
	@JsonIgnore
	private List<UnidadeCurricular> unidadesCurriculares;

	public Long getId() {
		return idCurso;
	}

	public void setId(Long id) {
		this.idCurso = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public List<UnidadeCurricular> getUnidadesCurriculares() {
		return unidadesCurriculares;
	}

	public void setUnidadesCurriculares(List<UnidadeCurricular> unidadesCurriculares) {
		this.unidadesCurriculares = unidadesCurriculares;
	}
	
}
