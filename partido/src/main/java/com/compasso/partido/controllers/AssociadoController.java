package com.compasso.partido.controllers;

import com.compasso.partido.categorias.CargoPolitico;
import com.compasso.partido.dto.AssociadoDTO;
import com.compasso.partido.entities.Associado;
import com.compasso.partido.form.AssociadoForm;
import com.compasso.partido.form.UpdateAssociadoForm;
import com.compasso.partido.repository.AssociadoRepository;
import com.compasso.partido.services.AssociacaoService;
import com.compasso.partido.services.AssociadoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController@RequestMapping("/associado")
public class AssociadoController
{
    @Autowired
    private AssociadoService service;

    @Autowired
    private AssociadoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    //@Autowired
    private AssociacaoService associacaoService;

    @PostMapping
    public ResponseEntity<AssociadoDTO> save (@RequestBody AssociadoForm associadoForm)
    {
        AssociadoDTO associado = this.service.save(associadoForm);
        return ResponseEntity.status(201).body(associado);
    }



    @GetMapping
    public ResponseEntity<Page<AssociadoDTO>> list (@PageableDefault(size = 5, page = 0, direction = Sort.Direction.ASC, sort= "nome") Pageable pagina,
                                                    @RequestParam(value = "id", required = false) Long id,
                                                    @RequestParam(value = "cargoPolitico", required = false)CargoPolitico cargoPolitico){
        return ResponseEntity.ok(this.service.listAssociado(pagina));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable Long id){
        Optional<Associado> associado = repository.findById(id);
        if (associado.isPresent()) {
            return ResponseEntity.ok(service.toAssociadoDTO(associado.get(), modelMapper));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AssociadoDTO> delete(@PathVariable Long id)
    {
        this.service.deleteAssociado(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/partidos") @Transactional
    public ResponseEntity<?> removerAfiliado(@PathVariable Long id){
        Optional<Associado> associado = repository.findById(id);
        if(associado.isPresent()){
            associacaoService.removerAfiliado(associado.get());
            return ResponseEntity.ok().build();
        }
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar (@PathVariable Long id, @RequestBody @Valid AssociadoService associadoService){
        Optional<Associado> associado = repository.findById(id);
        if(associado.isPresent()){
            associadoService.atualizar(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
