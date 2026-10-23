package Figuras;

public class Cilindro extends FiguraGeometrica {
    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
        setVolumen(calcularVolumen());
        setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return Math.PI * Math.pow(radio, 2.0) * altura;
    }

    public double calcularSuperficie() {
        double areaLateral = 2.0 * Math.PI * radio * altura;
        double areaBases = 2.0 * Math.PI * Math.pow(radio, 2.0);
        return areaLateral + areaBases;
    }
}
