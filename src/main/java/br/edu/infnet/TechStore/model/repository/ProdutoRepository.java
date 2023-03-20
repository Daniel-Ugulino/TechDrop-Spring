package br.edu.infnet.TechStore.model.repository;

import br.edu.infnet.TechStore.model.domain.Headset;
import br.edu.infnet.TechStore.model.domain.Mouse;
import br.edu.infnet.TechStore.model.domain.Produto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface ProdutoRepository extends CrudRepository<Produto,Integer> {

    @Query("from Produto ORDER BY id ASC")
    Collection<Produto> findAll();
    @Query("from Produto h where h.usuario.id= :id ORDER BY 'id' ASC ")
    Collection<Produto> findAll(Integer id);
    @Query(value="select * from Mouse ORDER BY id ASC offset :page * 5 limit 5 ", nativeQuery = true)
    Collection<Produto> findPaginated(Integer page);
}
