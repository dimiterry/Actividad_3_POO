package Figuras;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JButton cilindro, esfera, piramide, cubo, prisma;

    public VentanaPrincipal() {
        inicio();
        setTitle("Figuras geométricas");
        setSize(390, 210);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        cilindro = new JButton("Cilindro");
        cilindro.setBounds(20, 30, 150, 30);
        cilindro.addActionListener(this);

        esfera = new JButton("Esfera");
        esfera.setBounds(200, 30, 150, 30);
        esfera.addActionListener(this);

        piramide = new JButton("Pirámide");
        piramide.setBounds(20, 80, 150, 30);
        piramide.addActionListener(this);

        cubo = new JButton("Cubo");
        cubo.setBounds(200, 80, 150, 30);
        cubo.addActionListener(this);

        prisma = new JButton("Prisma rectangular");
        prisma.setBounds(110, 130, 150, 30);
        prisma.addActionListener(this);

        contenedor.add(cilindro);
        contenedor.add(esfera);
        contenedor.add(piramide);
        contenedor.add(cubo);
        contenedor.add(prisma);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == cilindro) {
            new VentanaCilindro().setVisible(true);
        } else if (evento.getSource() == esfera) {
            new VentanaEsfera().setVisible(true);
        } else if (evento.getSource() == piramide) {
            new VentanaPiramide().setVisible(true);
        } else if (evento.getSource() == cubo) {
            new VentanaCubo().setVisible(true);
        } else if (evento.getSource() == prisma) {
            new VentanaPrisma().setVisible(true);
        }
    }
}
