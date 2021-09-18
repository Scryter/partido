package com.compasso.partido.controllers;


import com.compasso.partido.dto.PartidoDTO;
import com.compasso.partido.form.PartidoForm;
import com.compasso.partido.services.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController@RequestMapping("/partido")
public class PartidoController
{
    @Autowired
    private PartidoService service;

    @PostMapping
    public ResponseEntity<PartidoDTO> save(@RequestBody PartidoForm partidoForm)
    {
        PartidoDTO partido = this.service.save(partidoForm);
        return ResponseEntity.status(201).body(partido);
    }
}
