package com.meusprojetos.livraria.api.dto;

import java.util.List;

public record UsuarioEmprestimoResponseDTO(
    Long id,
    String nome,
    String email,
    List<EmprestimoResumoDTO> emprestimos
) {}
