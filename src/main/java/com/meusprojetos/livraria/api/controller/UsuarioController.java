package com.meusprojetos.livraria.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meusprojetos.livraria.api.entity.Usuario;
import com.meusprojetos.livraria.api.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	@GetMapping
    public ResponseEntity<List<Usuario>> consultarTodos() {
        List<Usuario> usuarios = usuarioService.consultarUsuarios();
        
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> consultarPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.consultarUsuarioPorId(id);
        
        return ResponseEntity.ok(usuario);
        
    }
	@PostMapping
	public ResponseEntity<Usuario> inserirUsuario(@RequestBody  Usuario usuario) {
		Usuario novoUsuario = usuarioService.inserirUsuario(usuario);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
	    Usuario usuario = usuarioService.atualizarUsuario(id, usuarioAtualizado);
	    
	    return ResponseEntity.ok(usuario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
		usuarioService.deletarUsuario(id);
		
		return ResponseEntity.noContent().build();
	}
}
