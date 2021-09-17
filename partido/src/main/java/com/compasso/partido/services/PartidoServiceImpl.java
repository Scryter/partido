package com.compasso.partido.services;

import com.compasso.partido.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
@Service
public class PartidoServiceImpl {

    @Autowired
    private PartidoRepository repository;

    @Autowired
    private ModelMapper modelMapper;
}
