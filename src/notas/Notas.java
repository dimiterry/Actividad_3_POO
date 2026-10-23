package notas;

public class Notas {

    private double[] listaNotas;

    public Notas() {
        listaNotas = new double[5];
    }

    public void setNota(int posicion, double nota) {
        listaNotas[posicion] = nota;
    }

    public double calcularPromedio() {
        double suma = 0;

        for (int i = 0; i < listaNotas.length; i++) {
            suma += listaNotas[i];
        }

        return suma / listaNotas.length;
    }

    public double calcularDesviacion() {
        double promedio = calcularPromedio();
        double suma = 0;

        for (int i = 0; i < listaNotas.length; i++) {
            suma += Math.pow(listaNotas[i] - promedio, 2);
        }

        return Math.sqrt(suma / listaNotas.length);
    }

    public double calcularMenor() {
        double menor = listaNotas[0];

        for (int i = 1; i < listaNotas.length; i++) {
            if (listaNotas[i] < menor) {
                menor = listaNotas[i];
            }
        }

        return menor;
    }

    public double calcularMayor() {
        double mayor = listaNotas[0];

        for (int i = 1; i < listaNotas.length; i++) {
            if (listaNotas[i] > mayor) {
                mayor = listaNotas[i];
            }
        }

        return mayor;
    }
}