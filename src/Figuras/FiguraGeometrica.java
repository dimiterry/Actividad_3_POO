package Figuras;

/**
 * Clase padre para las figuras geométricas.
 * Guarda el volumen y la superficie de cada figura.
 */
public class FiguraGeometrica {
    private double volumen;
    private double superficie;

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public double getVolumen() {
        return this.volumen;
    }

    public double getSuperficie() {
        return this.superficie;
    }
}
