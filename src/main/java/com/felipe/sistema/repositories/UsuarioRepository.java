package com.felipe.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.sistema.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
