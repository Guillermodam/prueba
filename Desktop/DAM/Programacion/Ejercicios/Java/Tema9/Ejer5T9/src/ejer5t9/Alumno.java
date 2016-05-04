/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer5t9;

/**
 *
 * @author Daniel
 */
public class Alumno {

    String nombre;
    int[] nota = new int[3];

    public Alumno(String nombre) {
        this.nombre=nombre;
    }

//crea un alumno con todas las notas a 0
    public Alumno(String nombre, int n1, int n2, int n3) {

    }

    // Devuelve todos los datos del alumno en un array. Para hacer el listado
    public String[] getArrayAlumno() {

        String[] alumno = new String[1];
        return alumno;

    }

}
