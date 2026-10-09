package org.example.objeto;

public class Pedido {
    private final String id;
    private final double valorBase;
    private double valorFinal;

    public Pedido(String id, double valorBase) {
        this.id = id;
        this.valorBase = valorBase;
    }

    public String getId() {
        return id;
    }

    public double getValorBase() {
        return valorBase;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        if (valorFinal < 0) {
            throw new IllegalArgumentException("O valor final não pode ser negativo.");
        }
        this.valorFinal = valorFinal;
    }

    @Override
    public String toString() {
        return "Pedido{id='" + id + "', valorFinal=" + valorFinal + "}";
    }
}