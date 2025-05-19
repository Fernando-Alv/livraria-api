package com.meusprojetos.livraria.api.service;

import java.time.LocalDate;
import java.util.List;

import com.meusprojetos.livraria.api.exception.LivroIndisponivelException;
import com.meusprojetos.livraria.api.exception.LivroJaDevolvidoException;
import org.springframework.stereotype.Service;

import com.meusprojetos.livraria.api.entity.Emprestimo;
import com.meusprojetos.livraria.api.entity.Livro;
import com.meusprojetos.livraria.api.exception.RecursoNaoEncontradoException;
import com.meusprojetos.livraria.api.repository.EmprestimoRepository;
import com.meusprojetos.livraria.api.repository.LivroRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmprestimoService {

	private final EmprestimoRepository emprestimoRepository;
	
	private final LivroRepository livroRepository;
	
	public Emprestimo realizarEmprestimo(Emprestimo emprestimo) {
		Livro livro = emprestimo.getLivro();
		
		if(!livro.isDisponivel()) {
			throw new LivroIndisponivelException("Livro indisponível para empréstimo");
		}
		livro.setDisponivel(false);
		livroRepository.save(livro);
		
		return emprestimoRepository.save(emprestimo);
	}
	
	public List<Emprestimo> consultarEmprestimos() {
		return emprestimoRepository.findAll();
	}
	
	public Emprestimo consultarEmprestimoPorId(Long id) {
		return emprestimoRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Empréstimo não encontrado com ID: " + id));
	}
	
	public Emprestimo realizarDevolucao(Long id) {
		Emprestimo emprestimo = consultarEmprestimoPorId(id);

		if(!emprestimo.getLivro().isDisponivel()) {
			emprestimo.setDataDevolucao(LocalDate.now());
			emprestimo.getLivro().setDisponivel(true);
			livroRepository.save(emprestimo.getLivro());
			return emprestimoRepository.save(emprestimo);
		}
		throw new LivroJaDevolvidoException("Esse livro já foi devolvido.");
	}
}
