package com.meusprojetos.livraria.api.dto;

import java.time.LocalDate;

public record EmprestimoResumoDTO(
        Long id,
        LocalDate dataEmprestimo,
        LocalDate dataDevolucao,
        Long idLivro,
        String tituloLivro
) {}
