package Figuras;

public class Cubo extends FiguraGeometrica {
    private double lado;

    public Cubo(double lado) {
        this.lado = lado;
        setVolumen(calcularVolumen());
        setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return Math.pow(lado, 3.0);
    }

    public double calcularSuperficie() {
        return 6.0 * Math.pow(lado, 2.0);
    }
}
