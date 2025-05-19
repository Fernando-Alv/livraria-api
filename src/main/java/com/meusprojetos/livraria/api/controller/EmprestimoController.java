package com.meusprojetos.livraria.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.meusprojetos.livraria.api.entity.Emprestimo;
import com.meusprojetos.livraria.api.service.EmprestimoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/emprestimos")
public class EmprestimoController {
	
	private final EmprestimoService emprestimoService;
	
	@GetMapping
    public ResponseEntity<List<Emprestimo>> consultarTodos() {
        List<Emprestimo> emprestimos = emprestimoService.consultarEmprestimos();
        
        return ResponseEntity.ok(emprestimos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> consultarPorId(@PathVariable Long id) {
        Emprestimo emprestimo = emprestimoService.consultarEmprestimoPorId(id);
        
        return ResponseEntity.ok(emprestimo);
        
    }
	@PostMapping
	public ResponseEntity<Emprestimo> realizarEmprestimo(@RequestBody  Emprestimo emprestimo) {
		Emprestimo novoEmprestimo = emprestimoService.realizarEmprestimo(emprestimo);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(novoEmprestimo);
	}

    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> devolverLivro(@PathVariable Long id) {
        Emprestimo devolvido = emprestimoService.realizarDevolucao(id);
        return ResponseEntity.ok(devolvido);
    }
}	
