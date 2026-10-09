package org.example.template;

import org.example.objeto.Pedido;
import org.example.observer.ObservadorPedido;
import org.example.strategy.CalculadoraDesconto;

import java.util.ArrayList;
import java.util.List;

public abstract class ProcessadorPedido {
    private final CalculadoraDesconto estrategiaDesconto;
    private final List<ObservadorPedido> observadores;
    protected ProcessadorPedido(CalculadoraDesconto estrategiaDesconto) {
        this.estrategiaDesconto = estrategiaDesconto;
        this.observadores = new ArrayList<>();
    }

    public void adicionarObservador(ObservadorPedido observador) {
        if (observador != null) {
            this.observadores.add(observador);
        }
    }

    public final void processar(Pedido pedido) {
        System.out.println("\n--- Iniciando processamento do " + pedido.getId() + " ---");
        validar(pedido);
        calcularTotal(pedido);
        notificar(pedido);
        System.out.println("--- Processamento concluído ---");
    }

    protected abstract void validar(Pedido pedido);

    protected abstract void calcularTotal(Pedido pedido);

    private void notificar(Pedido pedido) {
        System.out.println("Notificando observadores registrados...");
        for (ObservadorPedido observador : observadores) {
            observador.atualizar(pedido);
        }
    }

    protected CalculadoraDesconto getEstrategiaDesconto() {
        return estrategiaDesconto;
    }
}