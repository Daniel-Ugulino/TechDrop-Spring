package br.edu.infnet.TechStore.model.service;


import br.edu.infnet.TechStore.model.domain.Mouse;
import br.edu.infnet.TechStore.model.repository.MouseRepository;
import br.edu.infnet.TechStore.model.repository.MouseRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Collection;

@Service
public class MouseService{
    @Autowired
    private MouseRepository2 mouseRepository;

    S3fileService s3fileService;

    public Mouse incluir(Mouse mouse, MultipartFile multipartFile){
        File file = s3fileService.convertMultiPartFileToFile(multipartFile);
        String s3FileUrl = s3fileService.uploadFile("techdrop_mouse/",file);
        mouse.setImgUrl(s3FileUrl);
        return mouseRepository.save(mouse);
    }
    public void excluir(Integer key){
        mouseRepository.deleteById(key);
    }

    public Collection<Mouse> obterLista(){
        return mouseRepository.findAll();
    }
}
