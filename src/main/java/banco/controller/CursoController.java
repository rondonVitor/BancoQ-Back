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

import banco.domain.Curso;
import banco.service.CursoService;

@RestController
@RequestMapping("/banco/curso")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid Curso curso, BindingResult result) {
		Curso cursoSalvo = this.cursoService.salvar(curso);
		return new ResponseEntity<Curso>(cursoSalvo, HttpStatus.CREATED);
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<?> listarTodos() {
		Iterable<Curso> cursos = this.cursoService.listarTodos();
		return new ResponseEntity<Iterable<Curso>>(cursos, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-por-id/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Curso curso = this.cursoService.buscarPorId(id);
		return new ResponseEntity<Curso>(curso, HttpStatus.OK);
	}
	
}
