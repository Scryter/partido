package com.compasso.partido.services;

import com.compasso.partido.dto.AssociadoDTO;
import com.compasso.partido.form.AssociadoForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface AssociadoService {
    AssociadoDTO save(AssociadoForm associadoForm);

    Page<AssociadoDTO> listAssociado(Pageable pagina);

    void deleteAssociado(Long id);
}
