package com.felipe.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.sistema.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
