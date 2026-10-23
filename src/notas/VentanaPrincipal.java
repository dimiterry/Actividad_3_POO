package notas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame
        implements ActionListener {

    private Container contenedor;

    private JLabel[] etiquetasNotas;
    private JTextField[] camposNotas;

    private JLabel promedio;
    private JLabel desviacion;
    private JLabel mayor;
    private JLabel menor;

    private JButton calcular;
    private JButton limpiar;

    // Constructor de la ventana
    public VentanaPrincipal() {
        inicio();

        setTitle("Notas");
        setSize(330, 390);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    // Crea los componentes gráficos
    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        etiquetasNotas = new JLabel[5];
        camposNotas = new JTextField[5];

        // Crea las etiquetas y los campos de las cinco notas
        for (int i = 0; i < 5; i++) {
            etiquetasNotas[i] = new JLabel("Nota " + (i + 1) + ":");
            etiquetasNotas[i].setBounds(20, 20 + i * 30, 80, 23);

            camposNotas[i] = new JTextField();
            camposNotas[i].setBounds(105, 20 + i * 30, 180, 23);

            contenedor.add(etiquetasNotas[i]);
            contenedor.add(camposNotas[i]);
        }

        // Botón Calcular
        calcular = new JButton("Calcular");
        calcular.setBounds(20, 175, 120, 28);
        calcular.addActionListener(this);
        contenedor.add(calcular);

        // Botón Limpiar
        limpiar = new JButton("Limpiar");
        limpiar.setBounds(155, 175, 120, 28);
        limpiar.addActionListener(this);
        contenedor.add(limpiar);

        // Etiquetas para mostrar los resultados
        promedio = new JLabel("Promedio = ");
        promedio.setBounds(20, 220, 280, 23);
        contenedor.add(promedio);

        desviacion = new JLabel("Desviación estándar = ");
        desviacion.setBounds(20, 250, 280, 23);
        contenedor.add(desviacion);

        mayor = new JLabel("Nota mayor = ");
        mayor.setBounds(20, 280, 280, 23);
        contenedor.add(mayor);

        menor = new JLabel("Nota menor = ");
        menor.setBounds(20, 310, 280, 23);
        contenedor.add(menor);
    }

    // Gestiona los eventos de los botones
    @Override
    public void actionPerformed(ActionEvent evento) {

        // Si se pulsa el botón Calcular
        if (evento.getSource() == calcular) {

            Notas notas = new Notas();

            try {
                // Valida y guarda las cinco notas
                for (int i = 0; i < camposNotas.length; i++) {

                    String texto = camposNotas[i].getText().trim();

                    // Comprueba si la nota está vacía
                    if (texto.isEmpty()) {
                        JOptionPane.showMessageDialog(
                                this,
                                "Debes ingresar la nota " + (i + 1) + ".",
                                "Nota faltante",
                                JOptionPane.WARNING_MESSAGE
                        );

                        camposNotas[i].requestFocus();
                        return;
                    }

                    // Convierte el texto a un número
                    double valor = Double.parseDouble(texto);

                    // Comprueba que el valor sea un número válido
                    if (!Double.isFinite(valor)) {
                        JOptionPane.showMessageDialog(
                                this,
                                "La nota " + (i + 1)
                                        + " debe ser un número válido.",
                                "Dato inválido",
                                JOptionPane.WARNING_MESSAGE
                        );

                        camposNotas[i].requestFocus();
                        return;
                    }

                    notas.setNota(i, valor);
                }

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(
                        this,
                        "Todas las notas deben ser numéricas.",
                        "Error de entrada",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // Muestra el promedio
            promedio.setText(
                    String.format(
                            java.util.Locale.US,
                            "Promedio = %.2f",
                            notas.calcularPromedio()
                    )
            );

            // Muestra la desviación estándar
            desviacion.setText(
                    String.format(
                            java.util.Locale.US,
                            "Desviación estándar = %.2f",
                            notas.calcularDesviacion()
                    )
            );

            // Muestra la nota mayor
            mayor.setText(
                    String.format(
                            java.util.Locale.US,
                            "Nota mayor = %.2f",
                            notas.calcularMayor()
                    )
            );

            // Muestra la nota menor
            menor.setText(
                    String.format(
                            java.util.Locale.US,
                            "Nota menor = %.2f",
                            notas.calcularMenor()
                    )
            );
        }

        // Si se pulsa el botón Limpiar
        if (evento.getSource() == limpiar) {

            // Borra los campos de las cinco notas
            for (JTextField campo : camposNotas) {
                campo.setText("");
            }

            // Restablece las etiquetas de resultados
            promedio.setText("Promedio = ");
            desviacion.setText("Desviación estándar = ");
            mayor.setText("Nota mayor = ");
            menor.setText("Nota menor = ");

            camposNotas[0].requestFocus();
        }
    }
}