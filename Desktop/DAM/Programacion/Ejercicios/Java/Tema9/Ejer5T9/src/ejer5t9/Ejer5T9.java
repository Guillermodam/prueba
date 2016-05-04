/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer5t9;

import GUI.Ventana;

/**
 *
 * @author Daniel
 */
public class Ejer5T9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String bd = "Acme";
        String user = "usuario150";
        String password = "riau@per";
        Bd basedata = new Bd (bd,user,password);
        if (basedata.getConexion()){
            System.out.println("Conexion exitosa");
            Ventana v = new Ventana(basedata);
            //Creamos una sentencia
        
            
            
            
//            String sentencia= "CREATE TABLE Alumnos2 (id INT AUTO_INCREMENT, PRIMARY KEY (id), nombre VARCHAR(20), nota1 INT, nota2 INT, nota3 INT);";
////        //MUY IMPORTANTE CERRAR EL FICHERO
//        basedata.ejecutaUpdate(sentencia);
        }
    }
    
}
