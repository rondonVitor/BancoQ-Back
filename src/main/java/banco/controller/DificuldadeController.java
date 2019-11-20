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

import banco.domain.Dificuldade;
import banco.service.DificuldadeService;

@RestController
@RequestMapping("/banco/dificuldade")
public class DificuldadeController {

	@Autowired
	private DificuldadeService dificuldadeService;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid Dificuldade dificuldade, BindingResult result) {
		Dificuldade dificuldadeSalvo = this.dificuldadeService.salvar(dificuldade);
		return new ResponseEntity<Dificuldade>(dificuldadeSalvo, HttpStatus.CREATED);
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<?> listarTodos() {
		Iterable<Dificuldade> dificuldades = this.dificuldadeService.listarTodos();
		return new ResponseEntity<Iterable<Dificuldade>>(dificuldades, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-por-id/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Dificuldade dificuldade = this.dificuldadeService.buscarPorId(id);
		return new ResponseEntity<Dificuldade>(dificuldade, HttpStatus.OK);
	}
}
