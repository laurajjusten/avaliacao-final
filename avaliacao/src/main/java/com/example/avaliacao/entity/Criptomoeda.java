package com.example.avaliacao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Criptomoeda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 255 caracteres.")
    private String nome;

    @Pattern(regexp = "[A-Z]{3}", message = "A sigla deve conter 3 letras maiúsculas")
    private String sigla;

    @DecimalMin(value = "0.01", message = "O preço deve ser no mínimo R$0,01.")
    private Double precoAtual;

    @PositiveOrZero
    private Double volumeNegociado;

    @PastOrPresent(message = "A data informada ultrapassa a data atual.")
    private LocalDate dataCadastro;

    private Boolean ativo;

    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres.")
    private String descricao;

    @Size(min = 2, max = 60, message = "O nome deve ter entre 3 e 255 caracteres.")
    private String pais;

    private String siteOficial;

}
