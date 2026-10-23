package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaCilindro extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio, altura, volumen, superficie;
    private JTextField campoRadio, campoAltura;
    private JButton calcular;

    public VentanaCilindro() {
        inicio();
        setTitle("Cilindro");
        setSize(420, 210);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        radio = new JLabel("Radio (cm):");
        radio.setBounds(20, 20, 100, 23);
        campoRadio = new JTextField();
        campoRadio.setBounds(120, 20, 120, 23);

        altura = new JLabel("Altura (cm):");
        altura.setBounds(20, 50, 100, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(120, 50, 120, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(120, 80, 120, 25);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm³):");
        volumen.setBounds(20, 115, 240, 23);
        superficie = new JLabel("Superficie (cm²):");
        superficie.setBounds(20, 145, 240, 23);

        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
        agregarImagen("cilindro.png", 275, 25, 110, 110);
    }

    private void agregarImagen(String archivo, int x, int y, int ancho, int alto) {
        java.net.URL recurso = getClass().getResource("/Figuras/imagenes/" + archivo);
        if (recurso != null) {
            ImageIcon icono = new ImageIcon(recurso);
            Image imagen = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            contenedor.add(new JLabel(new ImageIcon(imagen))).setBounds(x, y, ancho, alto);
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try {
            double r = Double.parseDouble(campoRadio.getText().trim());
            double h = Double.parseDouble(campoAltura.getText().trim());
            if (r <= 0 || h <= 0) throw new NumberFormatException();

            Cilindro figura = new Cilindro(r, h);
            volumen.setText("Volumen (cm³): " + String.format("%.2f", figura.calcularVolumen()));
            superficie.setText("Superficie (cm²): " + String.format("%.2f", figura.calcularSuperficie()));
        } catch (NumberFormatException e) {
            mostrarError();
        }
    }

    private void mostrarError() {
        JOptionPane.showMessageDialog(this, "Ingresa números válidos mayores que cero.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}
