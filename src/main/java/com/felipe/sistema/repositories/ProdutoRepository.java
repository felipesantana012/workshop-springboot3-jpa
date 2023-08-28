package com.felipe.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.sistema.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
