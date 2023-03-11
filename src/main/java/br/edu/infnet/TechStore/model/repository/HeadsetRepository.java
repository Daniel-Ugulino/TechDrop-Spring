package br.edu.infnet.TechStore.model.repository;

import br.edu.infnet.TechStore.model.domain.Headset;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class HeadsetRepository {
    private static Integer id = 1;

    private static Map<Integer, Headset> headsetMap =  new HashMap<Integer,Headset>();

    public boolean incluir(Headset headset){
        headset.setId(id++);

        try {
            headsetMap.put(id,headset);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public Headset excluir(Integer id){
        return headsetMap.remove(id);
    }

    public Collection<Headset> obterLista(){
        return headsetMap.values();
    }


}
