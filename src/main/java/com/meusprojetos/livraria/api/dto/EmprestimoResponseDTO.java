package com.meusprojetos.livraria.api.dto;

import java.time.LocalDate;

public record EmprestimoResponseDTO(
        Long id,
        LocalDate dataEmprestimo,
        LocalDate dataDevolucao,
        Long idLivro,
        String tituloLivro,
        Long idUsuario,
        String nomeUsuario
) {}

