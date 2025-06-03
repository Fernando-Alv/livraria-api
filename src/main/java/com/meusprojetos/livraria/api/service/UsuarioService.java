package com.meusprojetos.livraria.api.service;

import java.util.List;

import com.meusprojetos.livraria.api.dto.UsuarioEmprestimoResponseDTO;
import com.meusprojetos.livraria.api.dto.UsuarioResponseDTO;
import com.meusprojetos.livraria.api.mapper.UsuarioMapper;
import org.springframework.stereotype.Service;
import com.meusprojetos.livraria.api.entity.Usuario;
import com.meusprojetos.livraria.api.exception.RecursoNaoEncontradoException;
import com.meusprojetos.livraria.api.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	private final UsuarioMapper usuarioMapper;
	
	public Usuario inserirUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public List<UsuarioResponseDTO> consultarUsuarios() {
		List<Usuario> usuarios = usuarioRepository.findAll();

		return usuarioMapper.paraUsuarioResponseDTO(usuarios);
	}
	
	public UsuarioEmprestimoResponseDTO consultarUsuarioPorId(Long id) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com ID: " + id));

		return usuarioMapper.paraUsuarioEmprestimoResponseDTO(usuario);
	}
	
	public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
		
		Usuario usuarioExistente = usuarioRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com ID: " + id));
		
		usuarioExistente.setNome(usuarioAtualizado.getNome());
		usuarioExistente.setEmail(usuarioAtualizado.getEmail());
		usuarioExistente.setCpf(usuarioAtualizado.getCpf());
		
		return usuarioRepository.save(usuarioExistente);		
	}
	
	public void deletarUsuario(Long id) {
		
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com ID: " + id));
		
		usuarioRepository.delete(usuario);    
	}
}
