package com.compasso.partido.services;

import com.compasso.partido.dto.AssociadoDTO;
import com.compasso.partido.entities.Associado;
import com.compasso.partido.form.AssociadoForm;
import com.compasso.partido.repository.AssociadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssociadoServiceImpl implements AssociadoService{

    @Autowired
    private AssociadoRepository repository;


    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AssociadoDTO save(AssociadoForm associadoForm)
    {
        Associado associado = this.repository.save(modelMapper.map(associadoForm, Associado.class));
        return modelMapper.map(associado, AssociadoDTO.class);
    }
    @Override
    public Page<AssociadoDTO> listAssociado(Pageable pagina)
    {
        return null;
    }

    @Override
    public void deleteAssociado(Long id)
    {
        Optional<Associado> associado = this.repository.findById(id);
        this.repository.delete(associado.get());
    }

}
