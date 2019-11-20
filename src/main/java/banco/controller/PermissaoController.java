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

import banco.domain.Permissao;
import banco.service.PermissaoService;

@RestController
@RequestMapping("/banco/permissao")
public class PermissaoController {

	@Autowired
	private PermissaoService permissaoService;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid Permissao permissao, BindingResult result) {
		Permissao permissaoSalva = this.permissaoService.salvar(permissao);
		return new ResponseEntity<Permissao>(permissaoSalva, HttpStatus.CREATED);
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<?> listarTodos() {
		Iterable<Permissao> permissao = this.permissaoService.listarTodos();
		return new ResponseEntity<Iterable<Permissao>>(permissao, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-por-id/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Permissao permissao = this.permissaoService.buscarPorId(id);
		return new ResponseEntity<Permissao>(permissao, HttpStatus.OK);
	}
	
}
