package com.felipe.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.sistema.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
