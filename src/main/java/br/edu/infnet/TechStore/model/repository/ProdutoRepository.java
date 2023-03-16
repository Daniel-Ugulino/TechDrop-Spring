package br.edu.infnet.TechStore.model.repository;

import br.edu.infnet.TechStore.model.domain.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto,Integer> {


}
