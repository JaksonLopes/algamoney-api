package com.algaworks.algamoneyapi.resouce;

import com.algaworks.algamoneyapi.model.CategoriaEntity;
import com.algaworks.algamoneyapi.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RequestMapping("/categorias")
@RestController
@AllArgsConstructor
public class CategoriaResouce {

    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<CategoriaEntity> listar(){
        return categoriaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CategoriaEntity> criar (@Valid @RequestBody CategoriaEntity categoria, HttpServletResponse response){
        CategoriaEntity categoriaSalva = categoriaRepository.save(categoria);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(categoriaSalva.getCodigo()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(categoria);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<CategoriaEntity> BuscarPeloCodigo(@PathVariable Long codigo){
        return this.categoriaRepository.findById(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
