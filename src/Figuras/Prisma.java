package Figuras;

/**
 * Prisma rectangular con largo, ancho y altura.
 */
public class Prisma extends FiguraGeometrica {
    private double largo;
    private double ancho;
    private double altura;

    public Prisma(double largo, double ancho, double altura) {
        this.largo = largo;
        this.ancho = ancho;
        this.altura = altura;
        setVolumen(calcularVolumen());
        setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return largo * ancho * altura;
    }

    public double calcularSuperficie() {
        return 2.0 * (largo * ancho + largo * altura + ancho * altura);
    }
}
