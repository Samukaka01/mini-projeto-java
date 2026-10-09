package org.example.observer;

import org.example.objeto.Pedido;

public class ObservadorEstoque implements ObservadorPedido {
    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("[Estoque] Separando itens para o " + pedido.getId() + " (se aplicável).");
    }
}