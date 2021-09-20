package com.compasso.partido.services;

import com.compasso.partido.dto.AssociadoDTO;
import com.compasso.partido.dto.PartidoDTO;
import com.compasso.partido.entities.Associado;
import com.compasso.partido.entities.Partido;
import com.compasso.partido.form.PartidoForm;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PartidoService {

    PartidoDTO save(PartidoForm partidoForm);

    Page<PartidoDTO> listPartido(Pageable pagina);
    void deletePartido(Long id);
    AssociadoDTO toAssociadoDTO(Associado associado, ModelMapper modelMapper);

    Object toPartidoDTO(Partido partido, ModelMapper modelMapper);

    PartidoDTO atualizar(Long id);
}
