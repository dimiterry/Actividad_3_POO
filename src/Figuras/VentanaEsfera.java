package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaEsfera extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio, volumen, superficie;
    private JTextField campoRadio;
    private JButton calcular;

    public VentanaEsfera() {
        inicio();
        setTitle("Esfera");
        setSize(420, 200);
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

        calcular = new JButton("Calcular");
        calcular.setBounds(120, 55, 120, 25);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm³):");
        volumen.setBounds(20, 100, 240, 23);
        superficie = new JLabel("Superficie (cm²):");
        superficie.setBounds(20, 130, 240, 23);

        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
        agregarImagen("esfera.png", 275, 25, 110, 110);
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
            if (r <= 0) throw new NumberFormatException();

            Esfera figura = new Esfera(r);
            volumen.setText("Volumen (cm³): " + String.format("%.2f", figura.calcularVolumen()));
            superficie.setText("Superficie (cm²): " + String.format("%.2f", figura.calcularSuperficie()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingresa un radio válido mayor que cero.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
