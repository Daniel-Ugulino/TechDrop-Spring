package br.edu.infnet.TechStore.model.repository;

import br.edu.infnet.TechStore.model.domain.Mouse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Collection;
@Repository
public interface MouseRepository extends CrudRepository<Mouse,Integer> {
    @Query("from Mouse ORDER BY id ASC")
    Collection<Mouse> findAll();
    @Query("from Headset h where h.usuario.id= :id ORDER BY 'id' ASC ")
    Collection<Mouse> findAll(Integer id);
    @Query(value="select * from Mouse ORDER BY id ASC offset :page * 5 limit 5 ", nativeQuery = true)
    Collection<Mouse> findPaginated(Integer page);

}
