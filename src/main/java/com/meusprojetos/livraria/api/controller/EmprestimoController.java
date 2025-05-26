package com.meusprojetos.livraria.api.controller;

import java.util.List;

import com.meusprojetos.livraria.api.dto.EmprestimoDTO;
import com.meusprojetos.livraria.api.dto.EmprestimoResponseDTO;
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
    public ResponseEntity<List<EmprestimoResponseDTO>> consultarTodos() {
        List<EmprestimoResponseDTO> emprestimos = emprestimoService.consultarEmprestimos();
        
        return ResponseEntity.ok(emprestimos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoResponseDTO> consultarPorId(@PathVariable Long id) {
        EmprestimoResponseDTO emprestimo = emprestimoService.consultarEmprestimoPorId(id);
        
        return ResponseEntity.ok(emprestimo);
        
    }
    @PostMapping
    public ResponseEntity<EmprestimoResponseDTO> realizarEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO) {
        EmprestimoResponseDTO response = emprestimoService.realizarEmprestimo(emprestimoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<EmprestimoResponseDTO> devolverLivro(@PathVariable Long id) {
        EmprestimoResponseDTO devolvido = emprestimoService.realizarDevolucao(id);
        return ResponseEntity.ok(devolvido);
    }
}	
