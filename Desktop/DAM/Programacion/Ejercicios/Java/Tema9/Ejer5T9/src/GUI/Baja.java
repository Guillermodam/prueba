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
public class Baja extends JFrame implements ActionListener {
    
    JPanel contenedor;
    JButton b,bb;
    JTextField nombre;
    Bd bd;
    
    public Baja (Bd bd) {
        this.bd=bd;
        this.setTitle("Baja");
        this.setLocation(1,1);
        this.setVisible(true);
        initComponents();
    }
    
    void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contenedor = (JPanel) this.getContentPane();
        contenedor.setLayout(new GridLayout(3,1));
        
        nombre = new JTextField();
        nombre.setEditable(true);
        nombre.setText("");
        contenedor.add(nombre);
        this.pack();
        
        b = new JButton();
        b.setText("Dar de baja");
        b.setEnabled(true);
        b.setActionCommand("baja");
        b.addActionListener(this);
        contenedor.add(b);
        
        bb = new JButton();
        bb.setText("Volver al menu principal");
        bb.setEnabled(true);
        bb.setActionCommand("menu");
        bb.addActionListener(this);
        contenedor.add(bb);
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String a = e.getActionCommand();
        switch (a) {
            case "baja":
                int n = bd.baja(nombre.getText());
                if (n==0) {
                    JOptionPane.showMessageDialog(this, "No existe el alumno", "Error",JOptionPane.ERROR_MESSAGE);
                }
                JOptionPane.showMessageDialog(this, "Baja Correcta", "Baja",JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                this.dispose();
                Ventana v = new Ventana(bd);
                break;
                
                
        }
    }
}