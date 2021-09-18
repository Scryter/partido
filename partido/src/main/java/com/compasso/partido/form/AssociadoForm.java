package com.compasso.partido.form;

import com.compasso.partido.categorias.CargoPolitico;
import com.compasso.partido.categorias.Sexo;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AssociadoForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @NotNull
    private Long id;
    @NotNull @NotEmpty
    private String nome;
    @NotNull
    private CargoPolitico cargoPolitico;
    @NotNull
    private Sexo sexo;
    @NotNull
    private Date data_nascimento;
}
