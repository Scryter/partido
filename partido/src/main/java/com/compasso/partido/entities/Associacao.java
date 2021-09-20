package com.compasso.partido.entities;

public class Associacao {
    private Long id;

    private Associado associado;

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    private Partido partido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
