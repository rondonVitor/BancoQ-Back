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

import banco.domain.Perfil;
import banco.service.PerfilService;

@RestController
@RequestMapping("/banco/perfil")
public class PerfilController {

	@Autowired
	private PerfilService perfilService;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid Perfil perfil, BindingResult result) {
		Perfil perfilSalvo = this.perfilService.salvar(perfil);
		return new ResponseEntity<Perfil>(perfilSalvo, HttpStatus.CREATED);
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<?> listarTodos() {
		Iterable<Perfil> perfil = this.perfilService.listarTodos();
		return new ResponseEntity<Iterable<Perfil>>(perfil, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-por-id/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Perfil perfil = this.perfilService.buscarPorId(id);
		return new ResponseEntity<Perfil>(perfil, HttpStatus.OK);
	}
}
