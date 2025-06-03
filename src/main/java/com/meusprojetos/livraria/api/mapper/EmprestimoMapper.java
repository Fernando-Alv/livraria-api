package com.meusprojetos.livraria.api.mapper;

import com.meusprojetos.livraria.api.dto.EmprestimoResponseDTO;
import com.meusprojetos.livraria.api.dto.EmprestimoResumoDTO;
import com.meusprojetos.livraria.api.entity.Emprestimo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmprestimoMapper {

    @Mapping(source = "livro.id", target = "idLivro")
    @Mapping(source = "livro.titulo", target = "tituloLivro")
    EmprestimoResumoDTO paraEmprestimoResumoDTO(Emprestimo emprestimo);

    @Mapping(source = "livro.id", target = "idLivro")
    @Mapping(source = "livro.titulo", target = "tituloLivro")
    @Mapping(source = "usuario.id", target = "idUsuario")
    @Mapping(source = "usuario.nome", target = "nomeUsuario")
    EmprestimoResponseDTO paraEmprestimoResponseDTO(Emprestimo emprestimo);

    List<EmprestimoResponseDTO> paraListaEmprestimosResponseDTO(List<Emprestimo> emprestimos);
}
