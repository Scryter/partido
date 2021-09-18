package com.compasso.partido.dto;

import com.compasso.partido.categorias.CargoPolitico;
import com.compasso.partido.categorias.Sexo;
import lombok.Data;

import java.util.Date;
@Data
public class AssociadoDTO {

    private Long id;

    private String nome;

    private CargoPolitico cargoPolitico;//private Enum<CargoPolitico> cargoPolitico;

    private Sexo sexo;

    private Date data_nascimento;
}
