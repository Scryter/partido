package com.compasso.partido.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PartidoDTO
{
    private long ID;

    private String sigla;

    private String Ideologia;

    private Date data_fundacao;
}
