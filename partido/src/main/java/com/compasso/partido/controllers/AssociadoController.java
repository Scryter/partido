package com.compasso.partido.controllers;

import com.compasso.partido.dto.AssociadoDTO;
import com.compasso.partido.form.AssociadoForm;
import com.compasso.partido.services.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController@RequestMapping("/associado")
public class AssociadoController
{
    @Autowired
    private AssociadoService service;

    @PostMapping
    public ResponseEntity<AssociadoDTO> save (@RequestBody AssociadoForm associadoForm)
    {
        AssociadoDTO associado = this.service.save(associadoForm);
        return ResponseEntity.status(201).body(associado);
    }

}
