package com.algaworks.algamoneyapi.resouce;

import com.algaworks.algamoneyapi.event.RecursoCriadoEvent;
import com.algaworks.algamoneyapi.model.CategoriaEntity;
import com.algaworks.algamoneyapi.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
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

    private ApplicationEventPublisher Publisher;

    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<CategoriaEntity> listar(){
        return categoriaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CategoriaEntity> criar (@Valid @RequestBody CategoriaEntity categoria, HttpServletResponse response){
        CategoriaEntity categoriaSalva = categoriaRepository.save(categoria);
        Publisher.publishEvent(new RecursoCriadoEvent(this,response,categoriaSalva.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaEntity> BuscarPeloCodigo(@PathVariable Long id){
        return this.categoriaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
