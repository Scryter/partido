package com.compasso.partido.entities;

import com.compasso.partido.categorias.Ideologia;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Partido
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String nome;

    private String sigla;

    private Ideologia ideologia;

    private Date data_fundacao;

}
