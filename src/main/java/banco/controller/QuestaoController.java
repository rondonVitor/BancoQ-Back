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

import banco.domain.Questao;
import banco.service.QuestaoService;
import banco.ws.QuestaoWs;

@RestController
@RequestMapping("/banco/questao")
public class QuestaoController {

	@Autowired
	private QuestaoService questaoService;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid QuestaoWs questaoWs, BindingResult result) {
		Questao questaoSalva = this.questaoService.salvar(questaoWs);
		return new ResponseEntity<Questao>(questaoSalva, HttpStatus.CREATED);
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<?> listarTodos() {
		Iterable<Questao> questao = this.questaoService.listarTodos();
		return new ResponseEntity<Iterable<Questao>>(questao, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-por-id/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Questao questao = this.questaoService.buscarPorId(id);
		return new ResponseEntity<Questao>(questao, HttpStatus.OK);
	}
	
}
