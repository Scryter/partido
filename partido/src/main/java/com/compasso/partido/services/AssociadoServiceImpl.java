package com.compasso.partido.services;

import com.compasso.partido.dto.AssociadoDTO;
import com.compasso.partido.entities.Associado;
import com.compasso.partido.form.AssociadoForm;
import com.compasso.partido.form.UpdateAssociadoForm;
import com.compasso.partido.repository.AssociadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssociadoServiceImpl implements AssociadoService{

    @Autowired
    private AssociadoRepository repository;


    @Autowired
    private ModelMapper modelMapper;
   // @Autowired
    private UpdateAssociadoForm UpdateAssociadoForm;

    @Override
    public AssociadoDTO save(AssociadoForm associadoForm)
    {
        Associado associado = this.repository.save(modelMapper.map(associadoForm, Associado.class));
        return modelMapper.map(associado, AssociadoDTO.class);
    }
    @Override
    public Page<AssociadoDTO> listAssociado(Pageable pagina)
    {
        Page<Associado> pageable = this.repository.findAll(pagina);
        List<AssociadoDTO> associados = pageable.getContent()
                .stream()
                .map(associado -> modelMapper.map(associado, AssociadoDTO.class))
                .collect(Collectors.toList());
        return new PageImpl<>(associados, pagina, pageable.getTotalElements());
    }

    @Override
    public void deleteAssociado(Long id)
    {
        Optional<Associado> associado = this.repository.findById(id);
        this.repository.delete(associado.get());
    }

    @Override
    public Object toAssociadoDTO(Associado associado, ModelMapper modelMapper) {
        return null;
    }
    @Override
    public AssociadoDTO atualizar(Long id)
    {
        Optional<Associado> associado = this.repository.findById(id);
        this.repository.delete(associado.get());
        Associado associadoNovo = this.repository.save(modelMapper.map(UpdateAssociadoForm, Associado.class));
        return modelMapper.map(associado, AssociadoDTO.class);
    }

}
