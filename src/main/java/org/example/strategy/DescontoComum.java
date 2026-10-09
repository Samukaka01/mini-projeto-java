package org.example.strategy;

public class DescontoComum implements CalculadoraDesconto {
    private static final double TAXA_DESCONTO = 0.95; // 5% de desconto

    @Override
    public double calcular(double valorBase) {
        System.out.println("Aplicando desconto Comum (5%)");
        return valorBase * TAXA_DESCONTO;
    }
}