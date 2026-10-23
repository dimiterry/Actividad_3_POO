package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPiramide extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel base, altura, apotema, volumen, superficie;
    private JTextField campoBase, campoAltura, campoApotema;
    private JButton calcular;

    public VentanaPiramide() {
        inicio();
        setTitle("Pirámide");
        setSize(430, 260);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        base = new JLabel("Base (cm):");
        base.setBounds(20, 20, 100, 23);
        campoBase = new JTextField();
        campoBase.setBounds(120, 20, 120, 23);

        altura = new JLabel("Altura (cm):");
        altura.setBounds(20, 50, 100, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(120, 50, 120, 23);

        apotema = new JLabel("Apotema (cm):");
        apotema.setBounds(20, 80, 100, 23);
        campoApotema = new JTextField();
        campoApotema.setBounds(120, 80, 120, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(120, 115, 120, 25);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm³):");
        volumen.setBounds(20, 155, 250, 23);
        superficie = new JLabel("Superficie (cm²):");
        superficie.setBounds(20, 185, 250, 23);

        contenedor.add(base);
        contenedor.add(campoBase);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(apotema);
        contenedor.add(campoApotema);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
        agregarImagen("piramide.png", 275, 35, 115, 115);
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
            double b = Double.parseDouble(campoBase.getText().trim());
            double h = Double.parseDouble(campoAltura.getText().trim());
            double a = Double.parseDouble(campoApotema.getText().trim());
            if (b <= 0 || h <= 0 || a <= 0) throw new NumberFormatException();

            Piramide figura = new Piramide(b, h, a);
            volumen.setText("Volumen (cm³): " + String.format("%.2f", figura.calcularVolumen()));
            superficie.setText("Superficie (cm²): " + String.format("%.2f", figura.calcularSuperficie()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingresa números válidos mayores que cero.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
