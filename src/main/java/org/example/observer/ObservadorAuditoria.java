package org.example.observer;

import org.example.objeto.Pedido;

public class ObservadorAuditoria implements ObservadorPedido {
    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("️[Auditoria] Registrando log da transação do " + pedido.getId() + " no sistema.");
    }
}