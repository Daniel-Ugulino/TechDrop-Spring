package br.edu.infnet.TechStore.model.repository;

import br.edu.infnet.TechStore.model.domain.Teclado;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TecladoRepository {

    private static Integer id = 1;

    private static Map<Integer, Teclado> mapaTeclado = new HashMap<Integer, Teclado>();

    public boolean incluir(Teclado teclado) {

        teclado.setId(id++);

        try {
            mapaTeclado.put(teclado.getId(), teclado);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Teclado excluir(Integer key) {
        return mapaTeclado.remove(key);
    }

    public Collection<Teclado> obterLista(){
        return mapaTeclado.values();
    }
}
