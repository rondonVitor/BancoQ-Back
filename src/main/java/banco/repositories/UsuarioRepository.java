package banco.repositories;

import org.springframework.data.repository.CrudRepository;

import banco.domain.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
