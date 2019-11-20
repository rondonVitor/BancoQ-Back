package banco.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "perfil")
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idperfil")
	private Long idPerfil;
	
	@Column(name = "nome", length = 150, nullable = false)
	private String nome;
	
	@Column(name = "matricula", length = 60)
	private String matricula;
	
	@Column(name = "afiliacao", length = 150)
	private String afiliacao;
	
	@Column(name = "cargo", length = 150, nullable = false)
	private String cargo;

	@OneToOne(mappedBy = "perfil")
	@JsonIgnore
	private Usuario usuario;
	
	public Long getId() {
		return idPerfil;
	}

	public void setId(Long id) {
		this.idPerfil = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getAfiliacao() {
		return afiliacao;
	}

	public void setAfiliacao(String afiliacao) {
		this.afiliacao = afiliacao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
