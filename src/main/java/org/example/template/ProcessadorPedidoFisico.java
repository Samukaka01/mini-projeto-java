package org.example.template;

import org.example.objeto.Pedido;
import org.example.strategy.CalculadoraDesconto;

public class ProcessadorPedidoFisico extends ProcessadorPedido {
    private static final double VALOR_FRETE = 15.00;

    public ProcessadorPedidoFisico(CalculadoraDesconto estrategiaDesconto) {
        super(estrategiaDesconto);
    }

    @Override
    protected void validar(Pedido pedido) {
        System.out.println("Validando Pedido Físico: Verificando endereço de entrega e dimensões da caixa.");
        if (pedido.getValorBase() <= 0) {
            throw new IllegalArgumentException("Valor base do pedido físico inválido.");
        }
    }

    @Override
    protected void calcularTotal(Pedido pedido) {
        double valorComDesconto = getEstrategiaDesconto().calcular(pedido.getValorBase());
        pedido.setValorFinal(valorComDesconto + VALOR_FRETE);
        System.out.println("Cálculo Final (com frete fixo de R$" + VALOR_FRETE + "): " + pedido.getValorFinal());
    }
}