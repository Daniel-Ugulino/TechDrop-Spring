package br.edu.infnet.TechStore.model.repository;

import br.edu.infnet.TechStore.model.domain.Mouse;
import br.edu.infnet.TechStore.model.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface MouseRepository2 extends CrudRepository<Mouse,Integer> {
    @Query("from Mouse ORDER BY id ASC")
    Collection<Mouse> findAll();
}
