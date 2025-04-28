package com.meusprojetos.livraria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meusprojetos.livraria.api.entity.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{

}
