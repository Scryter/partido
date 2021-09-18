package com.compasso.partido.services;

import com.compasso.partido.dto.PartidoDTO;
import com.compasso.partido.entities.Partido;
import com.compasso.partido.form.PartidoForm;
import com.compasso.partido.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class PartidoServiceImpl implements PartidoService{

    @Autowired
    private PartidoRepository repository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PartidoDTO save(PartidoForm partidoForm)
    {
        Partido partido = this.repository.save(modelMapper.map(partidoForm, Partido.class));
        return modelMapper.map(partido, PartidoDTO.class);
    }

    @Override
    public Page<PartidoDTO> listPartido(Pageable pagina) {
        return null;
    }

    @Override
    public void deletePartido(Long id)
    {
        Optional<Partido> partido = this.repository.findById(id);
        this.repository.delete(partido.get());
    }


}
