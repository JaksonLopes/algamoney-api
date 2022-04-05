package com.algaworks.algamoneyapi.resouce;

import com.algaworks.algamoneyapi.event.RecursoCriadoEvent;
import com.algaworks.algamoneyapi.model.PessoaEntity;
import com.algaworks.algamoneyapi.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@AllArgsConstructor
public class PessoaResoucer {

    private PessoaRepository pessoaRepository;
    private ApplicationEventPublisher Publisher;

    @PostMapping
    public ResponseEntity<PessoaEntity> salvarNoavaPesoa(@RequestBody @Valid PessoaEntity pessoa, HttpServletResponse response){
        PessoaEntity pessoaSalva = pessoaRepository.save(pessoa);
        Publisher.publishEvent(new RecursoCriadoEvent(this,response, pessoaSalva.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
    }

    @GetMapping
    public List<PessoaEntity> listaPessoa(){
        return pessoaRepository.findAll();
    }
}
