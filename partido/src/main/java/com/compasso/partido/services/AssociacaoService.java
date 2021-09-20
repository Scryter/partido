package com.compasso.partido.services;

import com.compasso.partido.entities.Associado;

public interface AssociacaoService {
    void tornarAfiliado(Long associateId, Long partyId);
    void removerAfiliado(Associado associado);
}
