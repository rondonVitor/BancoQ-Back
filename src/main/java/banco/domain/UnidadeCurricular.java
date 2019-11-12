package banco.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
}
