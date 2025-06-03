package com.meusprojetos.livraria.api.service;

import java.time.LocalDate;
import java.util.List;

import com.meusprojetos.livraria.api.dto.EmprestimoDTO;
import com.meusprojetos.livraria.api.dto.EmprestimoResponseDTO;
import com.meusprojetos.livraria.api.entity.Usuario;
import com.meusprojetos.livraria.api.exception.LivroIndisponivelException;
import com.meusprojetos.livraria.api.exception.LivroJaDevolvidoException;
import com.meusprojetos.livraria.api.mapper.EmprestimoMapper;
import com.meusprojetos.livraria.api.repository.UsuarioRepository;
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

	private final UsuarioRepository usuarioRepository;

	private final EmprestimoMapper emprestimoMapper;

	public EmprestimoResponseDTO realizarEmprestimo(EmprestimoDTO dto) {
		Livro livro = livroRepository.findById(dto.idLivro())
				.orElseThrow(() -> new RecursoNaoEncontradoException("Livro não encontrado com ID: " + dto.idLivro()));

		if (!livro.isDisponivel()) {
			throw new LivroIndisponivelException("Livro indisponível para empréstimo");
		}

		Usuario usuario = usuarioRepository.findById(dto.idUsuario())
				.orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com ID: " + dto.idUsuario()));

		livro.setDisponivel(false);
		livroRepository.save(livro);

		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setLivro(livro);
		emprestimo.setUsuario(usuario);
		emprestimo.setDataEmprestimo(LocalDate.now());

		Emprestimo salvo = emprestimoRepository.save(emprestimo);

		return emprestimoMapper.paraEmprestimoResponseDTO(emprestimo);
	}

	public List<EmprestimoResponseDTO> consultarEmprestimos() {
		List<Emprestimo> emprestimos = emprestimoRepository.findAll();

		return emprestimoMapper.paraListaEmprestimosResponseDTO(emprestimos);
	}
	
	public EmprestimoResponseDTO consultarEmprestimoPorId(Long id) {

		Emprestimo emprestimo = emprestimoRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Empréstimo não encontrado com ID: " + id));

		return emprestimoMapper.paraEmprestimoResponseDTO(emprestimo);
	}
	
	public EmprestimoResponseDTO realizarDevolucao(Long id) {
		Emprestimo emprestimo = emprestimoRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Empréstimo não encontrado com ID: " + id));

		if(!emprestimo.getLivro().isDisponivel()) {
			emprestimo.setDataDevolucao(LocalDate.now());
			emprestimo.getLivro().setDisponivel(true);
			livroRepository.save(emprestimo.getLivro());
			emprestimoRepository.save(emprestimo);

			return emprestimoMapper.paraEmprestimoResponseDTO(emprestimo);
		}
		throw new LivroJaDevolvidoException("Esse livro já foi devolvido.");
	}
}
