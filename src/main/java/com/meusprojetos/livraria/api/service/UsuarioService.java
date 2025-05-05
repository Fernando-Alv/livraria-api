package com.meusprojetos.livraria.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meusprojetos.livraria.api.entity.Usuario;
import com.meusprojetos.livraria.api.exception.UsuarioNaoEncontradoException;
import com.meusprojetos.livraria.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario inserirUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public List<Usuario> consultarUsuarios() {
		return usuarioRepository.findAll();
	}
	
	public Usuario consultarUsuarioPorId(Long id) {
		
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado com ID: " + id));
	}
	
	public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
		
		Usuario usuarioExistente = usuarioRepository.findById(id)
				.orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado com ID: " + id));
		
		usuarioExistente.setNome(usuarioAtualizado.getNome());
		usuarioExistente.setEmail(usuarioAtualizado.getEmail());
		usuarioExistente.setCpf(usuarioAtualizado.getCpf());
		
		return usuarioRepository.save(usuarioExistente);
		
	}
	
	public Usuario deletarUsuario(Long id) {
		
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado com ID: " + id));
		
		usuarioRepository.delete(usuario);
	    return usuario;
	}
}
