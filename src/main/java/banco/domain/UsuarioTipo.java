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
@Table(name = "usuario_tipo")
public class UsuarioTipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuarioTipo")
	private Long idUsuarioTipo;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "idtipo")
	private Tipo tipo;

	public Long getIdUsuarioTipo() {
		return idUsuarioTipo;
	}

	public void setIdUsuarioTipo(Long idUsuarioTipo) {
		this.idUsuarioTipo = idUsuarioTipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
}
