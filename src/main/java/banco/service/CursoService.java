package banco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banco.domain.Curso;
import banco.repositories.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	public Curso salvar(Curso curso) {
		this.cursoRepository.save(curso);
		return curso;
	}
	
	public Curso buscarPorId(Long id) {
		if (id == null) {
			return null;
		}
		Optional<Curso> curso = this.cursoRepository.findById(id);
		if (curso.isPresent()) {
			return curso.get();
		}
		return null;
	}
	
	public Iterable<Curso> listarTodos() {
		return this.cursoRepository.findAll();
	}
	
}
