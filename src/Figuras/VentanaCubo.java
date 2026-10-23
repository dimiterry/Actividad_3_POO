package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaCubo extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel lado, volumen, superficie;
    private JTextField campoLado;
    private JButton calcular;

    public VentanaCubo() {
        inicio();
        setTitle("Cubo");
        setSize(420, 220);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        lado = new JLabel("Lado (cm):");
        lado.setBounds(20, 20, 100, 23);
        campoLado = new JTextField();
        campoLado.setBounds(120, 20, 120, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(120, 55, 120, 25);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm³):");
        volumen.setBounds(20, 100, 240, 23);
        superficie = new JLabel("Superficie (cm²):");
        superficie.setBounds(20, 130, 240, 23);

        contenedor.add(lado);
        contenedor.add(campoLado);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
        agregarImagen("cubo.png", 275, 25, 110, 110);
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
            double l = Double.parseDouble(campoLado.getText().trim());
            if (l <= 0) throw new NumberFormatException();

            Cubo figura = new Cubo(l);
            volumen.setText("Volumen (cm³): " + String.format("%.2f", figura.calcularVolumen()));
            superficie.setText("Superficie (cm²): " + String.format("%.2f", figura.calcularSuperficie()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingresa un lado válido mayor que cero.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
