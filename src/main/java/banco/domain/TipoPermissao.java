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
@Table(name = "tipo_permissao")
public class TipoPermissao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtipopermissao")
	private Long idTipoPermissao;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "idtipo")
	private Tipo tipo;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "idpermissao")
	private Permissao permissao;

	public Long getIdTipoPermissao() {
		return idTipoPermissao;
	}

	public void setIdTipoPermissao(Long idTipoPermissao) {
		this.idTipoPermissao = idTipoPermissao;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}	
	
}
