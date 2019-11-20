package banco.domain;

import java.util.List;

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
@Table(name = "questao")
public class Questao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idquestao")
	private Long idQuestao;
	
	@Column(name = "enunciado", length = 150, nullable = false)
	private String enunciado;
	
	@Column(name = "comando", length = 150, nullable = false)
	private String comando;
	
	@Column(name = "suporte", length = 150, nullable = false)
	private String suporte;
	
	@Column(name = "ativo", length = 2, nullable = false)
	private int ativo;

	@ManyToOne(optional = true)
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "iduc")
	private UnidadeCurricular unidadeCurricular;
	
	@OneToMany(mappedBy = "questao", targetEntity = Alternativa.class)
	@JsonIgnore
	private List<Alternativa> alternativas;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UnidadeCurricular getUnidadeCurricular() {
		return unidadeCurricular;
	}

	public void setUnidadeCurricular(UnidadeCurricular unidadeCurricular) {
		this.unidadeCurricular = unidadeCurricular;
	}

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}
	
}
