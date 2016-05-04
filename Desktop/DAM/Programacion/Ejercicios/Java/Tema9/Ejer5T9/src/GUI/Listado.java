/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ejer5t9.Bd;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class Listado extends JFrame implements ActionListener {

    JButton b;
    JPanel contenedor;
    JTable tabla;
    DefaultTableModel dtabla;
    Bd bd;

    public Listado(Bd bd) {
        this.bd = bd;
        this.setTitle("Listado");
        this.setLocation(1, 1);
        
        this.setVisible(true);
        initComponents();

    }

    void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contenedor = new JPanel();
        contenedor = (JPanel) this.getContentPane();
        

        dtabla = new DefaultTableModel();
        tabla = new JTable(dtabla);
        JScrollPane sp = new JScrollPane(tabla);
        dtabla.addColumn("Alumno");
        dtabla.addColumn("1T");
        dtabla.addColumn("2T");
        dtabla.addColumn("3T");
        contenedor.add(sp,BorderLayout.CENTER);

        b = new JButton();
        b.setSize(50,300);
        b.setText("Volver al menu principal");
        b.setEnabled(true);
        b.addActionListener(this);
        contenedor.add(b,BorderLayout.SOUTH);

        muestraFilas();

        this.pack();
        this.setSize(300,300);

        //metodo para rellenar el dtabla
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
        Ventana v = new Ventana(bd);

    }

    private void muestraFilas() {
        String[] col = new String[4];
        ResultSet rs = bd.ejecutaBusqueda();
        try {

            while (rs.next()) {
                for (int x = 0; x < col.length; x++) {
                    col[x] = rs.getString(x+2);
                }
                dtabla.addRow(col);
            }
        } catch (SQLException ex) {
            
        }
    }

}
