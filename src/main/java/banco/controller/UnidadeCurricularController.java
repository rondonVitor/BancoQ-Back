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

import banco.domain.UnidadeCurricular;
import banco.service.UnidadeCurricularService;

@RestController
@RequestMapping("/banco/uc")
public class UnidadeCurricularController {

	@Autowired
	private UnidadeCurricularService ucService;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid UnidadeCurricular uc, BindingResult result) {
		UnidadeCurricular ucSalvo = this.ucService.salvar(uc);
		return new ResponseEntity<UnidadeCurricular>(ucSalvo, HttpStatus.CREATED);
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<?> listarTodos() {
		Iterable<UnidadeCurricular> uc = this.ucService.listarTodos();
		return new ResponseEntity<Iterable<UnidadeCurricular>>(uc, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-por-id/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		UnidadeCurricular uc = this.ucService.buscarPorId(id);
		return new ResponseEntity<UnidadeCurricular>(uc, HttpStatus.OK);
	}
	
}
