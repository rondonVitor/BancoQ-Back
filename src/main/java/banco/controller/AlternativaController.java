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

import banco.domain.Alternativa;
import banco.service.AlternativaService;
import banco.ws.AlternativaWs;

@RestController
@RequestMapping("/banco/alternativa")
public class AlternativaController {
	
	@Autowired
	private AlternativaService alternativaService;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid AlternativaWs alternativaWs, BindingResult result) {
		Alternativa alternativaSalva = this.alternativaService.salvar(alternativaWs);
		return new ResponseEntity<Alternativa>(alternativaSalva, HttpStatus.CREATED);
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<?> listarTodos() {
		Iterable<Alternativa> alternativa = this.alternativaService.listarTodos();
		return new ResponseEntity<Iterable<Alternativa>>(alternativa, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-por-id/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Alternativa alternativa = this.alternativaService.buscarPorId(id);
		return new ResponseEntity<Alternativa>(alternativa, HttpStatus.OK);
	}

}
