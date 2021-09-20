package com.compasso.partido.form;
import com.compasso.partido.categorias.Ideologia;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class UpdatePartidoForm
{
    @Id
    private  long id;
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String sigla;
    //@NotNull
    private Ideologia ideologia;
    @JsonFormat(pattern="yyyy-MM-dd")//@NotNull
    private Date data_fundacao;
}
