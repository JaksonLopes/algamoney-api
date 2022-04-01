package com.algaworks.algamoneyapi.resouce;

import com.algaworks.algamoneyapi.model.CategoriaEntity;
import com.algaworks.algamoneyapi.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/categorias")
@RestController
@AllArgsConstructor
public class CategoriaResouce {

    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<CategoriaEntity> listar(){
        List<CategoriaEntity> categorias = categoriaRepository.findAll();
        return categorias;
    }
}
