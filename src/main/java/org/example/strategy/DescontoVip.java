package org.example.strategy;

public class DescontoVip implements CalculadoraDesconto {
    private static final double TAXA_DESCONTO = 0.80; // 20% de desconto

    @Override
    public double calcular(double valorBase) {
        System.out.println("Aplicando desconto VIP (20%)");
        return valorBase * TAXA_DESCONTO;
    }
}