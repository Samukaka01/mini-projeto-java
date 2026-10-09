package org.example.observer;

import org.example.objeto.Pedido;

public class ObservadorEmail implements ObservadorPedido {
    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("[Email] Enviando recibo do " + pedido.getId() + " para o cliente.");
    }
}