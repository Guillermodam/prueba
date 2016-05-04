/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ejer5t9.Alumno;
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
public class Alta extends JFrame implements ActionListener {
    
    JPanel contenedor;
    JButton b,bb;
    JTextField nombre;
    Bd bd;
    
    public Alta (Bd bd) {
        this.bd=bd;
        this.setTitle("Alta");
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
        b.setText("Dar de alta");
        b.setEnabled(true);
        b.setActionCommand("alta");
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
            case "alta":
                Alumno al = new Alumno(nombre.getText());
                bd.alta(al);
                JOptionPane.showMessageDialog(this, "Alta Correcta", "Alta",JOptionPane.INFORMATION_MESSAGE);
                break;
            case "menu":
                this.dispose();
                Ventana v = new Ventana(bd);
                break;
                
                
        }
    }
    
}
