/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bk;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tortuga
 */
public class EntradaSalida {

    public Scanner entrada; // lee datos de la línea de comandos

    // el constructor sin argumentos inicializa el objeto Scanner
    public EntradaSalida() {
        entrada = new Scanner(System.in);
    }

    // devuelve un valor entero introducido por el usuario
    public String obtenerEntrada() {

        return entrada.nextLine();// suponemos que el usuario introduce un entero
    } // fin del método obtenerEntrada

    /*public String leerString() {
        return entrada.nextLine();
    }*/
    public int leerInt() {
        return entrada.nextInt();
    }

    public char leerChar() {
        return entrada.next().charAt(0);
    }

    public void mostrarString(String s) {
        System.out.println(s);
    }

    /*public boolean validarBoolean(String valor) {
        if ((valor.equals("NO")) || (valor.equals("SI"))) {
            return true;
        } else {
            return false;
        }
    }*/
    public boolean validarBoolean(String valor) {
        if ((valor.equals("NO")) || (valor.equals("SI"))) {
            return true;
        } else {
            return false;
        }
    }

    public void listarArray(ArrayList<Usuario> lista) {
        System.out.println("Ingrese su listar:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("[" + (1 + i) + "]" + " - " + lista.get(i));

        }
    }

    public void listarArrayString(ArrayList<String> lista) {
        System.out.println("Ingrese su listar:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("[" + (1 + i) + "]" + "\t" + lista.get(i));

        }
    }

    public void limpiarpantalla() {
//        Runtime.getRuntime().exec("cls");
        for (int i = 0; i < 200; i++) {
            System.out.println();
        }
    }
}
