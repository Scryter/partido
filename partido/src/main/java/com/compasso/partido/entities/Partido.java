package com.compasso.partido.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity //@Table(name = "partido")
public class Partido
{
    /*
     • Nome do Partido
     • Sigla
     • Ideologia
     • Data de Fundação
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nome;

    private String sigla;

    private String Ideologia;

    private Date data_fundacao;

}
