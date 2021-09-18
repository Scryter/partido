package com.compasso.partido.services;

import com.compasso.partido.dto.PartidoDTO;
import com.compasso.partido.form.PartidoForm;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface PartidoService {

    PartidoDTO save(PartidoForm partidoForm);

    Page<PartidoDTO> listPartido(Pageable pagina);

    void deletePartido(Long id);
}
