package com.compasso.partido.services;

import com.compasso.partido.dto.AssociadoDTO;
import com.compasso.partido.entities.Associado;
import com.compasso.partido.form.AssociadoForm;
import com.compasso.partido.form.UpdateAssociadoForm;
import com.compasso.partido.repository.AssociadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface AssociadoService {
    AssociadoDTO save(AssociadoForm associadoForm);

    Page<AssociadoDTO> listAssociado(Pageable pagina);

    void deleteAssociado(Long id);

    Object toAssociadoDTO(Associado associado, ModelMapper modelMapper);

    AssociadoDTO atualizar(Long id);
}
