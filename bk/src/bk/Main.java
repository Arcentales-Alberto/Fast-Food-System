/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bk;

public class Main {

    public static void main(String[] args) {
        Controlador c = new Controlador();
        try {
            c.ejecutar();
        } catch (NullPointerException e) {
            //EntradaSalida.mostrarString(e.getMessage());
        }
    }
}
