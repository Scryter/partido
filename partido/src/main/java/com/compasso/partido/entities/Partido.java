package com.compasso.partido.entities;

import com.compasso.partido.categorias.Ideologia;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
public class Partido
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String sigla;
    @NotNull
    private Ideologia ideologia;
    @NotNull
    private Date data_fundacao;

}
