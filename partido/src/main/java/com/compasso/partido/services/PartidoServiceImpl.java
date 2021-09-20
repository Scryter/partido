package com.compasso.partido.services;

import com.compasso.partido.dto.AssociadoDTO;
import com.compasso.partido.dto.PartidoDTO;
import com.compasso.partido.entities.Associado;
import com.compasso.partido.entities.Partido;
import com.compasso.partido.form.PartidoForm;
import com.compasso.partido.form.UpdateAssociadoForm;
import com.compasso.partido.form.UpdatePartidoForm;
import com.compasso.partido.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartidoServiceImpl implements PartidoService{

    @Autowired
    private PartidoRepository repository;

    @Autowired
    private ModelMapper modelMapper;
    //@Autowired
    private UpdateAssociadoForm UpdatePartidoForm;


    @Override
    public PartidoDTO save(PartidoForm partidoForm)
    {
        Partido partido = this.repository.save(modelMapper.map(partidoForm, Partido.class));
        return modelMapper.map(partido, PartidoDTO.class);
    }

    @Override
    public Page<PartidoDTO> listPartido(Pageable pagina) {
        Page<Partido> pageable = this.repository.findAll(pagina);
        List<PartidoDTO> partidos = pageable.getContent()
                .stream()
                .map(partido -> modelMapper.map(partido, PartidoDTO.class))
                .collect(Collectors.toList());
        return new PageImpl<>(partidos, pagina, pageable.getTotalElements());
    }



    @Override
    public void deletePartido(Long id)
    {
        Optional<Partido> partido = this.repository.findById(id);
        this.repository.delete(partido.get());
    }

    public AssociadoDTO toAssociadoDTO(Associado associado, ModelMapper modelMapper) {
        return modelMapper.map(associado, AssociadoDTO.class);
    }

    @Override
    public Object toPartidoDTO(Partido partido, ModelMapper modelMapper) {
        return modelMapper.map(partido, PartidoDTO.class);
    }

    @Override
    public PartidoDTO atualizar(Long id) {
        Optional<Partido> partido = this.repository.findById(id);
        this.repository.delete(partido.get());
        Partido partidoNovo = this.repository.save(modelMapper.map(UpdatePartidoForm, Partido.class));
        return modelMapper.map(partido, PartidoDTO.class);
    }


}
