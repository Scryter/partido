package com.compasso.partido.entities;

import com.compasso.partido.categorias.Ideologia;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
/*@Table(name = "partido")/*/@Entity
public class Partido
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String nome;

    private String sigla;
    @Enumerated(EnumType.STRING)
    private Ideologia ideologia;

    private Date data_fundacao;

}
