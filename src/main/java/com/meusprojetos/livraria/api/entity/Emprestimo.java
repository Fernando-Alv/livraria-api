package com.meusprojetos.livraria.api.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_emprestimos")
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	
	@ManyToOne
	@JoinColumn(name = "livro_id")
	private Livro livro;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	

}
