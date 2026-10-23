package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrisma extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel largo, ancho, altura, volumen, superficie;
    private JTextField campoLargo, campoAncho, campoAltura;
    private JButton calcular;

    public VentanaPrisma() {
        inicio();
        setTitle("Prisma rectangular");
        setSize(440, 270);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        largo = new JLabel("Largo (cm):");
        largo.setBounds(20, 20, 100, 23);
        campoLargo = new JTextField();
        campoLargo.setBounds(120, 20, 120, 23);

        ancho = new JLabel("Ancho (cm):");
        ancho.setBounds(20, 50, 100, 23);
        campoAncho = new JTextField();
        campoAncho.setBounds(120, 50, 120, 23);

        altura = new JLabel("Altura (cm):");
        altura.setBounds(20, 80, 100, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(120, 80, 120, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(120, 115, 120, 25);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm³):");
        volumen.setBounds(20, 155, 250, 23);
        superficie = new JLabel("Superficie (cm²):");
        superficie.setBounds(20, 185, 250, 23);

        contenedor.add(largo);
        contenedor.add(campoLargo);
        contenedor.add(ancho);
        contenedor.add(campoAncho);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
        agregarImagen("prisma.png", 280, 35, 120, 120);
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
            double l = Double.parseDouble(campoLargo.getText().trim());
            double a = Double.parseDouble(campoAncho.getText().trim());
            double h = Double.parseDouble(campoAltura.getText().trim());
            if (l <= 0 || a <= 0 || h <= 0) throw new NumberFormatException();

            Prisma figura = new Prisma(l, a, h);
            volumen.setText("Volumen (cm³): " + String.format("%.2f", figura.calcularVolumen()));
            superficie.setText("Superficie (cm²): " + String.format("%.2f", figura.calcularSuperficie()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingresa números válidos mayores que cero.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
