package com.meusprojetos.livraria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meusprojetos.livraria.api.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
