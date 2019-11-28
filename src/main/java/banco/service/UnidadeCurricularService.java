package banco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banco.domain.Curso;
import banco.domain.UnidadeCurricular;
import banco.repositories.UnidadeCurricularRepository;
import banco.ws.UnidadeCurricularWs;

@Service
public class UnidadeCurricularService {

	@Autowired
	private UnidadeCurricularRepository ucRepository;

	@Autowired
	private CursoService cursoService;
	
	public UnidadeCurricular salvar(UnidadeCurricularWs ucWs) {
		UnidadeCurricular uc = this.parseUcWsToUc(ucWs);
		this.ucRepository.save(uc);
		return uc;
	}
	
	public UnidadeCurricular buscarPorId(Long id) {
		if (id == null) {
			return null;
		}
		Optional<UnidadeCurricular> uc = this.ucRepository.findById(id);
		if (uc.isPresent()) {
			return uc.get();
		}
		return null;
	}
	
	public Iterable<UnidadeCurricular> listarTodos() {
		return this.ucRepository.findAll();
	}
	
	private Curso obterCurso(Long idCurso) {
		Curso curso = this.cursoService.buscarPorId(idCurso);
		return curso;
	}
	
	private UnidadeCurricular parseUcWsToUc(UnidadeCurricularWs ucWs) {
		Curso curso = this.obterCurso(ucWs.getIdCurso());
		UnidadeCurricular uc = new UnidadeCurricular();
		uc.setIdUc(ucWs.getIdUc());
		uc.setNome(ucWs.getNome());
		uc.setNumero(ucWs.getNumero());
		uc.setCurso(curso);
		return uc;
	}
	
}
