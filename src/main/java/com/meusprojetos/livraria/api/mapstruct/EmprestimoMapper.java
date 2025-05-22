package com.meusprojetos.livraria.api.mapstruct;

import com.meusprojetos.livraria.api.dto.EmprestimoResumoDTO;
import com.meusprojetos.livraria.api.entity.Emprestimo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmprestimoMapper {

    @Mapping(source = "livro.id", target = "idLivro")
    @Mapping(source = "livro.titulo", target = "tituloLivro")
    EmprestimoResumoDTO paraEmprestimoResumoDTO(Emprestimo emprestimo);
}
