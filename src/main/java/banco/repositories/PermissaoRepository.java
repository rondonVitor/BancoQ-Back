package banco.repositories;

import org.springframework.data.repository.CrudRepository;

import banco.domain.Permissao;

public interface PermissaoRepository extends CrudRepository<Permissao, Long> {

}
