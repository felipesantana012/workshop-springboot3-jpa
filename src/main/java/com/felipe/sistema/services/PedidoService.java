package com.felipe.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.sistema.entities.Pedido;
import com.felipe.sistema.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> findAll(){
		return pedidoRepository.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.get();
	}
}
