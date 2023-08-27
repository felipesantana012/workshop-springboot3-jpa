package com.felipe.sistema.entities.enums;

public enum StatusPedido {
	
	ESPERANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int cod;
	
	private StatusPedido(int cod) {
		this.cod = cod;
	}
	
	public int getCod() {
		return cod;
	}
	
	public static StatusPedido valueOf(int cod) {
		for(StatusPedido value : StatusPedido.values()) {
			if(value.getCod() == cod) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo status pedido Invalido");
	}
	
}
