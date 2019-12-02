package banco.ws;

import javax.validation.constraints.NotNull;

public class UsuarioTipoWs {

	@NotNull(message = "É obrigatório informar o id!")
	private Long idUsuarioTipo;
	
	@NotNull(message = "É obrigatório informar o usuario!")
	private Long idUsuario;
	
	@NotNull(message = "É obrigatório informar o tipo!")
	private Long idTipo;

	public Long getIdUsuarioTipo() {
		return idUsuarioTipo;
	}

	public void setIdUsuarioTipo(Long idUsuarioTipo) {
		this.idUsuarioTipo = idUsuarioTipo;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}
	
}
