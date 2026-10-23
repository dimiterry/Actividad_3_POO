package Figuras;

/**
 * Pirámide de base cuadrada. "base" representa el lado de la base.
 */
public class Piramide extends FiguraGeometrica {
    private double base;
    private double altura;
    private double apotema;

    public Piramide(double base, double altura, double apotema) {
        this.base = base;
        this.altura = altura;
        this.apotema = apotema;
        setVolumen(calcularVolumen());
        setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return (Math.pow(base, 2.0) * altura) / 3.0;
    }

    public double calcularSuperficie() {
        double areaBase = Math.pow(base, 2.0);
        double areaLateral = 2.0 * base * apotema;
        return areaBase + areaLateral;
    }
}
