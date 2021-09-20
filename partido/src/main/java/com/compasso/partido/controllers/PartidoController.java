package com.compasso.partido.controllers;


import com.compasso.partido.categorias.Ideologia;
import com.compasso.partido.dto.AssociadoDTO;
import com.compasso.partido.dto.PartidoDTO;
import com.compasso.partido.entities.Associado;
import com.compasso.partido.entities.Partido;
import com.compasso.partido.form.PartidoForm;
import com.compasso.partido.repository.PartidoRepository;
import com.compasso.partido.services.AssociadoService;
import com.compasso.partido.services.PartidoService;
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

@RestController@RequestMapping("/partido")
public class PartidoController
{
    @Autowired
    private PartidoService service;

    @Autowired
    private PartidoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<PartidoDTO> save(@RequestBody PartidoForm partidoForm)
    {
        PartidoDTO partido = this.service.save(partidoForm);
        return ResponseEntity.status(201).body(partido);
    }
    @GetMapping
    public ResponseEntity<Page<PartidoDTO>> list (@PageableDefault(size = 5, page = 0, direction = Sort.Direction.ASC, sort= "nome")Pageable pagina,
                                                  @RequestParam(value = "id", required = false) Long id,
                                                  @RequestParam(value = "ideologia", required = false) Ideologia ideologia){
        return ResponseEntity.ok(this.service.listPartido(pagina));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable Long id){
        Optional<Partido> partido = repository.findById(id);
        if (partido.isPresent()) {
            return ResponseEntity.ok(service.toPartidoDTO(partido.get(), modelMapper));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AssociadoDTO> delete(@PathVariable Long id)
    {
        this.service.deletePartido(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar (@PathVariable Long id, @RequestBody @Valid PartidoService partidoService){
        Optional<Partido> partido = repository.findById(id);
        if(partido.isPresent()){
            partidoService.atualizar(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
