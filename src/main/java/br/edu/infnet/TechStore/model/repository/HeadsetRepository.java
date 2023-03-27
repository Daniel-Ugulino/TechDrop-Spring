package br.edu.infnet.TechStore.model.repository;
import br.edu.infnet.TechStore.model.domain.Headset;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Collection;

@Repository
public interface HeadsetRepository extends CrudRepository<Headset,Integer> {

    @Query("from Headset h where h.status = true ORDER BY h.id ASC")
    Collection<Headset> findAll();

    @Query("from Headset h where h.usuario.id= :id and h.status = true ORDER BY h.id ASC ")
    Collection<Headset> findAll(Integer id);
    @Query(value="select * from Headset where h.status = true ORDER BY h.id ASC offset :page * 5 limit 5 ", nativeQuery = true)
    Collection<Headset> findPaginated(Integer page);

}
