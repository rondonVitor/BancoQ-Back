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

import banco.domain.Tipo;
import banco.service.TipoService;

@RestController
@RequestMapping("/banco/tipo")
public class TipoController {

	@Autowired
	private TipoService tipoService;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid Tipo tipo, BindingResult result) {
		Tipo tipoSalvo = this.tipoService.salvar(tipo);
		return new ResponseEntity<Tipo>(tipoSalvo, HttpStatus.CREATED);
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<?> listarTodos() {
		Iterable<Tipo> tipos = this.tipoService.listarTodos();
		return new ResponseEntity<Iterable<Tipo>>(tipos, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-por-id/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Tipo tipo = this.tipoService.buscarPorId(id);
		return new ResponseEntity<Tipo>(tipo, HttpStatus.OK);
	}
}
