package br.edu.infnet.TechStore.model.repository;

import br.edu.infnet.TechStore.model.domain.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ProdutoRepository extends CrudRepository<Produto,Integer> {

    @Query("from Produto ORDER BY id ASC")
    Collection<Produto> findAll();

    @Query("from Produto p where p.type = :type and p.quantidade > 0 ORDER BY p.id ASC")
    Collection<Produto> findAllByType(String type);
    @Query("from Produto p where p.usuario.id = :id and p.status = true ORDER BY p.id ASC")
    Collection<Produto> findAll(Integer id);
    @Query(value="select * from Produto where p.usuario.id = :id and p.status = true ORDER BY id ASC offset :page * 5 limit 5 ", nativeQuery = true)
    Collection<Produto> findPaginated(Integer page);
}
