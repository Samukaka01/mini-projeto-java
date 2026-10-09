package org.example.template;

import org.example.objeto.Pedido;
import org.example.strategy.CalculadoraDesconto;

public class ProcessadorPedidoDigital extends ProcessadorPedido {
    private static final double TAXA_DRM = 2.50;

    public ProcessadorPedidoDigital(CalculadoraDesconto estrategiaDesconto) {
        super(estrategiaDesconto);
    }

    @Override
    protected void validar(Pedido pedido) {
        System.out.println("Validando Pedido Digital: Checando validade do e-mail e infraestrutura de download.");
        if (pedido.getValorBase() <= 0) {
            throw new IllegalArgumentException("Valor base do pedido digital inválido.");
        }
    }

    @Override
    protected void calcularTotal(Pedido pedido) {
        double valorComDesconto = getEstrategiaDesconto().calcular(pedido.getValorBase());
        pedido.setValorFinal(valorComDesconto + TAXA_DRM);
        System.out.println("Cálculo Final (com taxa DRM de R$" + TAXA_DRM + "): " + pedido.getValorFinal());
    }
}