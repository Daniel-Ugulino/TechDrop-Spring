package br.edu.infnet.TechStore.model.repository;

import br.edu.infnet.TechStore.model.domain.Mouse;
import br.edu.infnet.TechStore.model.domain.Teclado;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MouseRepository {
    private static Integer id = 1;

    private static Map<Integer, Mouse> mapaMouse = new HashMap<Integer, Mouse>();

    public boolean incluir(Mouse mouse) {

        mouse.setId(id++);

        try {
            mapaMouse.put(mouse.getId(), mouse);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Mouse excluir(Integer key) {
        return mapaMouse.remove(key);
    }

    public Collection<Mouse> obterLista(){
        return mapaMouse.values();
    }
}
