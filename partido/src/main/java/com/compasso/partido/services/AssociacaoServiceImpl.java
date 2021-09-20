package com.compasso.partido.services;

import com.compasso.partido.entities.Associacao;
import com.compasso.partido.entities.Associado;
import com.compasso.partido.entities.Partido;
import com.compasso.partido.form.UpdateAssociadoForm;
import com.compasso.partido.repository.AssociadoRepository;
import com.compasso.partido.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AssociacaoServiceImpl implements AssociacaoService {

    @Autowired
    AssociadoRepository associadoRepository;
    @Autowired
    PartidoRepository partidoRepository;

    @Autowired
    Associacao associacao;


    @Override
    public void tornarAfiliado(Long Id, Long partidoId) {

        Optional<Associado> findAssociado = associadoRepository.findById(Id);
        Optional<Partido> findPartido = partidoRepository.findById(partidoId);

        if(findAssociado.isPresent() && findPartido.isPresent()){
            Associado associado = findAssociado.get();
            Partido partido = findPartido.get();

            associacao.setAssociado(associado);
            associacao.setPartido(partido);
        }
    }

    @Override
    public void removerAfiliado(Associado associado) {
        associacao.setId(null);
    }
}
