/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ejer5t9.Bd;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class Ventana extends JFrame implements ActionListener {

    JPanel contenedor;
    JButton[] boton = new JButton[5];
    Bd bd;

    public Ventana(Bd bd) {
        this.bd = bd;
        this.setTitle("Menú Principal");
        this.setLocation(500, 500);
        this.setVisible(true);
        this.setSize(200,200);
        initComponents();
    }

    void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contenedor = (JPanel) this.getContentPane();
        contenedor.setLayout(new GridLayout(5, 1));
        for (int x = 0; x < boton.length; x++) {
            boton[x] = new JButton();
            boton[x].setEnabled(true);
            boton[x].setSize(50,50);
            boton[x].addActionListener(this);
            contenedor.add(boton[x]);
        }
        boton[0].setText("Alta Alumno");
        boton[0].setActionCommand("alta");
        boton[1].setText("Baja Alumno");
        boton[1].setActionCommand("baja");
        boton[2].setText("Listado");
        boton[2].setActionCommand("listado");
        boton[3].setText("Poner Notas");
        boton[3].setActionCommand("notas");
        boton[4].setText("Fin");
        boton[4].setActionCommand("fin");
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String a = e.getActionCommand();
        switch (a) {
            case ("alta"):
                Alta v = new Alta(bd);
                this.dispose();
                break;
            case ("baja"):
                Baja b = new Baja(bd);
                this.dispose();
                break;
            case ("listado"):
                Listado l = new Listado(bd);
                this.dispose();
                break;
            case ("notas"):
                Notas n = new Notas(bd);
                this.dispose();
                break;
            default:
                this.dispose();
                bd.cerrarConexion();
                break;

        }
    }

}
