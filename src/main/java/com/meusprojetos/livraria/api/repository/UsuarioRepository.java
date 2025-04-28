package com.meusprojetos.livraria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meusprojetos.livraria.api.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
