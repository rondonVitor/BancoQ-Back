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

import banco.domain.Reclamacao;
import banco.service.ReclamacaoService;
import banco.ws.ReclamacaoWs;

@RestController
@RequestMapping("/banco/reclamacao")
public class ReclamacaoController {

	@Autowired
	private ReclamacaoService reclamacaoService;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid ReclamacaoWs reclamacaoWs, BindingResult result) {
		Reclamacao reclamacaoSalva = this.reclamacaoService.salvar(reclamacaoWs);
		return new ResponseEntity<Reclamacao>(reclamacaoSalva, HttpStatus.CREATED);
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<?> listarTodos() {
		Iterable<Reclamacao> reclamacao = this.reclamacaoService.listarTodos();
		return new ResponseEntity<Iterable<Reclamacao>>(reclamacao, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-por-id/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Reclamacao reclamacao = this.reclamacaoService.buscarPorId(id);
		return new ResponseEntity<Reclamacao>(reclamacao, HttpStatus.OK);
	}
	
	
}
