package com.meusprojetos.livraria.api.mapper;

import com.meusprojetos.livraria.api.dto.UsuarioEmprestimoResponseDTO;
import com.meusprojetos.livraria.api.dto.UsuarioResponseDTO;
import com.meusprojetos.livraria.api.entity.Usuario;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = EmprestimoMapper.class)
public interface UsuarioMapper {

    UsuarioEmprestimoResponseDTO paraUsuarioEmprestimoResponseDTO(Usuario usuario);

    List<UsuarioResponseDTO> paraUsuarioResponseDTO(List<Usuario> usuarios);
}
