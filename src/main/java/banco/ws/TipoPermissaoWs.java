package banco.ws;

import javax.validation.constraints.NotNull;

public class TipoPermissaoWs {

	@NotNull(message = "É obrigatório informar o tipo!")
	private Long idTipoPermissao;
	
	@NotNull(message = "É obrigatório informar o tipo!")
	private Long idTipo;
	
	@NotNull(message = "É obrigatório informar a permissao!")
	private Long idPermissao;

	public Long getIdTipoPermissao() {
		return idTipoPermissao;
	}

	public void setIdTipoPermissao(Long idTipoPermissao) {
		this.idTipoPermissao = idTipoPermissao;
	}

	public Long getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}

	public Long getIdPermissao() {
		return idPermissao;
	}

	public void setIdPermissao(Long idPermissao) {
		this.idPermissao = idPermissao;
	}
}
