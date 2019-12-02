package banco.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import banco.domain.UsuarioTipo;
import banco.service.UsuarioTipoService;
import banco.ws.UsuarioTipoWs;

@RestController
@RequestMapping("/banco/usuario-tipo")
public class UsuarioTipoController {

	@Autowired
	private UsuarioTipoService usuarioTipoService;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid UsuarioTipoWs usuarioTipoWs, BindingResult result) {
		UsuarioTipo usuarioTipoSalvo = this.usuarioTipoService.salvar(usuarioTipoWs);
		return new ResponseEntity<UsuarioTipo>(usuarioTipoSalvo, HttpStatus.CREATED);
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<?> listarTodos() {
		Iterable<UsuarioTipo> usuarioTipo = this.usuarioTipoService.listarTodos();
		return new ResponseEntity<Iterable<UsuarioTipo>>(usuarioTipo, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-por-id/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		UsuarioTipo usuarioTipo = this.usuarioTipoService.buscarPorId(id);
		return new ResponseEntity<UsuarioTipo>(usuarioTipo, HttpStatus.OK);
	}
}
