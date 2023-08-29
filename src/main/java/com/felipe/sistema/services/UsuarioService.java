package com.felipe.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.felipe.sistema.entities.Usuario;
import com.felipe.sistema.repositories.UsuarioRepository;
import com.felipe.sistema.services.excecoes.BancoDadosExcecao;
import com.felipe.sistema.services.excecoes.RecursoNaoEncontradoExcecao;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoExcecao(id));
	}
	
	public Usuario insert(Usuario obj) {
		return usuarioRepository.save(obj);
	}
	
	public void delete(Long id){
		try {
		usuarioRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoExcecao(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new BancoDadosExcecao(e.getMessage());
		}
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
