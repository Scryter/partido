package com.compasso.partido.form;

import com.compasso.partido.categorias.Ideologia;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class PartidoForm
{
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String sigla;
    @NotNull
    private Ideologia Ideologia;
    @NotNull
    private Date data_fundacao;
}
