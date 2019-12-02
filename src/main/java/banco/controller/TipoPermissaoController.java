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

import banco.domain.TipoPermissao;
import banco.service.TipoPermissaoService;
import banco.ws.TipoPermissaoWs;

@RestController
@RequestMapping("/banco/tipo-permissao")
public class TipoPermissaoController {

	@Autowired
	private TipoPermissaoService tipoPermissaoService;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid TipoPermissaoWs tipoPermissaoWs, BindingResult result) {
		TipoPermissao TipoPermissaoSalvo = this.tipoPermissaoService.salvar(tipoPermissaoWs);
		return new ResponseEntity<TipoPermissao>(TipoPermissaoSalvo, HttpStatus.CREATED);
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<?> listarTodos() {
		Iterable<TipoPermissao> TipoPermissao = this.tipoPermissaoService.listarTodos();
		return new ResponseEntity<Iterable<TipoPermissao>>(TipoPermissao, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-por-id/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		TipoPermissao TipoPermissao = this.tipoPermissaoService.buscarPorId(id);
		return new ResponseEntity<TipoPermissao>(TipoPermissao, HttpStatus.OK);
	}
	
}
