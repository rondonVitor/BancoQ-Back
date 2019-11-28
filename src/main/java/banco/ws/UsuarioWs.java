package banco.ws;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class UsuarioWs {

	private Long idUsuario;

	@NotNull(message = "É obrigatório informar o email!")
	@Column(name = "email", length = 150, nullable = false)
	private String email;
	
	@NotNull(message = "É obrigatório informar a senha!")
	@Column(name = "senha", length = 150, nullable = false)
	private String senha;
	
	@NotNull(message = "É obrigatório informar o perfil!")
	private Long idPerfil;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}
	
}
