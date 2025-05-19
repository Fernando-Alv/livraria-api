package com.meusprojetos.livraria.api.controller;

import com.meusprojetos.livraria.api.entity.Livro;
import com.meusprojetos.livraria.api.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> inserirLivro(@RequestBody Livro livro) {
        Livro novoLivro = livroService.inserirLivro(livro);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> consultarLivros() {
        List<Livro> livros = livroService.consultarLivros();

        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> consultarLivroPorId(@PathVariable Long id) {
        Livro livro = livroService.consultarLivroPorId(id);

        return ResponseEntity.ok(livro);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        Livro livro = livroService.atualizarLivro(id, livroAtualizado);

        return ResponseEntity.ok(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);

        return ResponseEntity.noContent().build();
    }
}
