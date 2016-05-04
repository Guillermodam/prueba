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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Daniel
 */
public class Notas extends JFrame implements ActionListener {

    JPanel contenedor;
    JButton b, bb, bbb, bbbb;
    JTextField nombre, nota;
    Bd bd;

    public Notas(Bd bd) {
        this.bd = bd;
        this.setTitle("Notas");
        this.setLocation(1, 1);
        this.setVisible(true);
        initComponents();
    }

    void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contenedor = (JPanel) this.getContentPane();
        contenedor.setLayout(new GridLayout(5, 1));

        nombre = new JTextField();
        nombre.setEditable(true);
        nombre.setText("nombre");
        contenedor.add(nombre);

        nota = new JTextField();
        nota.setEditable(true);
        nota.setText("nota");
        contenedor.add(nota);

        b = new JButton();
        b.setText("1T");
        b.setEnabled(true);
        b.setActionCommand("1T");
        b.addActionListener(this);
        contenedor.add(b);

        bb = new JButton();
        bb.setText("2T");
        bb.setEnabled(true);
        bb.setActionCommand("2T");
        bb.addActionListener(this);
        contenedor.add(bb);

        bbb = new JButton();
        bbb.setText("3T");
        bbb.setEnabled(true);
        bbb.setActionCommand("3T");
        bbb.addActionListener(this);
        contenedor.add(bbb);

        bbbb = new JButton();
        bbbb.setText("Volver al menu principal");
        bbbb.setEnabled(true);
        bbbb.setActionCommand("menu");
        bbbb.addActionListener(this);
        contenedor.add(bbbb);

        this.pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String a = e.getActionCommand();
        switch (a) {
            case "1T":
                try {
                    int n = bd.ejecutaUpdate("update alumnos2 set nota1 = " + Integer.parseInt(nota.getText()) + " where nombre = '" + nombre.getText() + "';");
                    if (n==0){
                        JOptionPane.showMessageDialog(this,"No exist el alumno","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(this,"La nota ha sido actualizada","Nota",JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this,"La nota debe ser un numero entero","Error",JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "2T":
                try {
                    int n = bd.ejecutaUpdate("update alumnos2 set nota2 = " + Integer.parseInt(nota.getText()) + " where nombre = '" + nombre.getText() + "';");
                    if (n==0){
                        JOptionPane.showMessageDialog(this,"No exist el alumno","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(this,"La nota ha sido actualizada","Nota",JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this,"La nota debe ser un numero entero","Error",JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "3T":
                try {
                    int n = bd.ejecutaUpdate("update alumnos2 set nota3 = " + Integer.parseInt(nota.getText()) + " where nombre = '" + nombre.getText() + "';");
                    if (n==0){
                        JOptionPane.showMessageDialog(this,"No exist el alumno","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(this,"La nota ha sido actualizada","Nota",JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this,"La nota debe ser un numero entero","Error",JOptionPane.ERROR_MESSAGE);
                }
                break;
            default:
                this.dispose();
                Ventana v = new Ventana(bd);
                break;

        }
    }

}
