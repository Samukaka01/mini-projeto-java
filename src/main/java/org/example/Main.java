package org.example;

import org.example.objeto.Pedido;
import org.example.observer.ObservadorAuditoria;
import org.example.observer.ObservadorEmail;
import org.example.observer.ObservadorEstoque;
import org.example.observer.ObservadorPedido;
import org.example.strategy.DescontoComum;
import org.example.strategy.DescontoVip;
import org.example.template.ProcessadorPedido;
import org.example.template.ProcessadorPedidoDigital;
import org.example.template.ProcessadorPedidoFisico;

public class Main {
    public static void main(String[] args) {
        ObservadorPedido observadorEmail = new ObservadorEmail();
        ObservadorPedido observadorEstoque = new ObservadorEstoque();
        ObservadorPedido observadorAuditoria = new ObservadorAuditoria();

        Pedido pedidoFisico = new Pedido("PED-FISICO-001", 100.0);
        ProcessadorPedido processadorFisico = new ProcessadorPedidoFisico(new DescontoComum());

        processadorFisico.adicionarObservador(observadorEmail);
        processadorFisico.adicionarObservador(observadorEstoque);
        processadorFisico.adicionarObservador(observadorAuditoria);

        processadorFisico.processar(pedidoFisico);

        Pedido pedidoDigital = new Pedido("PED-DIGITAL-999", 100.0);
        ProcessadorPedido processadorDigital = new ProcessadorPedidoDigital(new DescontoVip());

        processadorDigital.adicionarObservador(observadorEmail);
        processadorDigital.adicionarObservador(observadorAuditoria);

        processadorDigital.processar(pedidoDigital);
    }
}