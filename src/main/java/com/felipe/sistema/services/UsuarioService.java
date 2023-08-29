package com.felipe.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.sistema.entities.Usuario;
import com.felipe.sistema.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.get();
	}
	
	public Usuario insert(Usuario obj) {
		return usuarioRepository.save(obj);
	}
	
	public void delete(Long id){
		usuarioRepository.deleteById(id);
	}
	
	public Usuario Update(Long id, Usuario obj) {
		Usuario entidade = usuarioRepository.getReferenceById(id);
		atualizarDados(entidade, obj);
		return usuarioRepository.save(entidade);
	}

	private void atualizarDados(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setFone(obj.getFone());	
	}
}
