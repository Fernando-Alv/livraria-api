package com.meusprojetos.livraria.api.service;

import com.meusprojetos.livraria.api.entity.Livro;
import com.meusprojetos.livraria.api.exception.RecursoNaoEncontradoException;
import com.meusprojetos.livraria.api.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public Livro inserirLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> consultarLivros() {
        return livroRepository.findAll();
    }

    public Livro consultarLivroPorId(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Livro não encontrado com ID: " + id));
    }

    public Livro atualizarLivro(Long id, Livro livroAtualizado) {
        Livro livroExistente = consultarLivroPorId(id);

        livroExistente.setTitulo(livroAtualizado.getTitulo());
        livroExistente.setAutor(livroAtualizado.getAutor());
        livroExistente.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
        livroExistente.setIsbn(livroAtualizado.getIsbn());
        livroExistente.setDisponivel(livroAtualizado.isDisponivel());

        return livroRepository.save(livroExistente);
    }

    public void deletarLivro(Long id) {
        Livro livroExistente = consultarLivroPorId(id);

        livroRepository.delete(livroExistente);
    }
}
