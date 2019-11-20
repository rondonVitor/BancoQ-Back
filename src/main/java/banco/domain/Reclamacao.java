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
@Table(name = "reclamacao")
public class Reclamacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idreclamacao")
	private Long idReclamacao;
	
	@Column(name = "reclamacao", length = 150, nullable = false, columnDefinition="text")
	private String reclamacao;
	
	@Column(name = "ativo", length = 2, nullable = false)
	private int ativo;

	@ManyToOne(optional = true)
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "idquestao")
	private Questao questao;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
	
}
