/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer5t9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class Bd {
    
    Connection con = null;
    String servidor = "jdbc:mysql://localhost/"; 
    String bd; 
    String user; 
    String password; 
    
    public Bd(String bd, String user, String password) {
        this.bd=bd;
        this.user=user;
        this.password=password;
        
    }
    public boolean getConexion() { // realiza la conexión a la base de datos. Llamaremos a este método cada vez que necesitemos conectarnos. 
    
        boolean estado = false;
        try {

            //Caragar el driver
           Class.forName("com.mysql.jdbc.Driver");

            // Crear connection a la base de datos.
            con = DriverManager.getConnection(servidor + bd, user, password);
            estado = true;
        } catch (ClassNotFoundException ex) {
            System.out.println("SQL Exception:\n" + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Class not found Exception" + ex.toString());
        } catch (Exception e) {
            System.out.println("Exception:\n" + e.toString());
        }
        return estado;
}


public void alta(Alumno al) { 
    try {
    // Abre la conexión, realiza la consulta, pasa todos los alumnos a un ArrayList, cierra las conexiones y devuelve el ArrayList.
    Statement st = con.createStatement();
        
        String statement = "insert into alumnos2 (nombre) values ('" + al.nombre + "');";
        
        st.executeUpdate(statement);
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
}

public int baja(String nombre) {try {
    // Se conecta a la base de datos y luego realiza el Insert en la base de datos.  Después cierra statement y la conexión.
    Statement st = con.createStatement();
    String sentencia = "delete from alumnos2 where nombre = '" + nombre + "';";
    
    return st.executeUpdate(sentencia);
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    return 0;
}

 
//public ArrayList listado() {//Devuelve el/los alumnus con ese nombre. Devuelve la cantidad de nombres que ha borrado. 
//    
//}

public void crearDB() {
    
}

public ResultSet ejecutaBusqueda () {
        ResultSet rs = null;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery("select * from Alumnos2");
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
}


public int ejecutaUpdate(String statement) {
        int n = 0;
        try {
            Statement st = con.createStatement();
            System.out.println("La sentencia es: " + statement);
            n = st.executeUpdate(statement);

        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

public void cerrarConexion() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
