package com.compasso.partido.entities;


import com.compasso.partido.categorias.CargoPolitico;
import com.compasso.partido.categorias.Sexo;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
public class Associado
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @NotNull
    private Long id;

    private String nome;
    @Enumerated(EnumType.STRING)
    private CargoPolitico cargoPolitico;//private Enum<CargoPolitico> cargoPolitico;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private Date data_nascimento;

}
