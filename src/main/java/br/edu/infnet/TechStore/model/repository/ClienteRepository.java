package br.edu.infnet.TechStore.model.repository;

import br.edu.infnet.TechStore.model.domain.Cliente;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ClienteRepository extends CrudRepository<Cliente,Integer> {
    @Query("from Cliente ORDER BY id ASC")
    Collection<Cliente> findAll();

    @Query(value="select * from Cliente ORDER BY id ASC offset :page * 5 limit 5 ", nativeQuery = true)
    Collection<Cliente> findPaginated(Integer page);
}
