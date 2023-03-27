package br.edu.infnet.TechStore.model.repository;

import br.edu.infnet.TechStore.model.domain.Teclado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface TecladoRepository extends CrudRepository<Teclado, Integer> {
    @Query("from Teclado t where t.status = true ORDER BY t.id ASC")
    Collection<Teclado> findAll();

    @Query("from Teclado t where t.usuario.id= :id and t.status = true ORDER BY t.id ASC ")
    Collection<Teclado> findAll(Integer id);

    @Query(value="select * from Teclado where t.status = true ORDER BY id ASC offset :page * 5 limit 5 ", nativeQuery = true)
    Collection<Teclado> findPaginated(Integer page);
}
