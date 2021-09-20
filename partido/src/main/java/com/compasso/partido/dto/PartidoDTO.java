package com.compasso.partido.dto;

import com.compasso.partido.entities.Partido;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PartidoDTO
{
    private long ID;

    private String sigla;

    private String Ideologia;

    private Date data_fundacao;

}
