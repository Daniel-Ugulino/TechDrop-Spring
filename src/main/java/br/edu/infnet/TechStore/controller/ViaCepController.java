package br.edu.infnet.TechStore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;

@RestController
public class ViaCepController {
    @GetMapping(value = "/getCep/{id}")
    public Object getCep(@PathVariable String id){
        final String uri = "https://viacep.com.br/ws/"+id+"/json/";
        Object result = null;
        try{
            RestTemplate restTemplate = new RestTemplate();
            result = restTemplate.getForObject(uri, Object.class);
        }catch (Exception e){
            System.out.println(e);
        }

        return result;
    }

}
