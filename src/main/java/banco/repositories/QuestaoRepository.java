package banco.repositories;

import org.springframework.data.repository.CrudRepository;

import banco.domain.Questao;

public interface QuestaoRepository extends CrudRepository<Questao, Long> {

}
