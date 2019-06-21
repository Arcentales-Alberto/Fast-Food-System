package bk;

import java.io.IOException;
import java.util.ArrayList;
//OJO HAY QUE SACAR EL UTIL ARRAYLIST

public class Controlador {

    public void ejecutar() {

        Sistema sistemaBurger = new Sistema();

        EntradaSalida consolaYTeclado = new EntradaSalida();
        boolean seguir = true;

        try {
            // Verifico si existe el archivo con datos de los usuarios
            sistemaBurger = sistemaBurger.deSerializar("sistema.txt");
            seguir = true;
        } catch (IOException | ClassNotFoundException e) {
            //PRIMER INGRESO
            consolaYTeclado.mostrarString("Arranque inicial del sistema.\n"
                    + "Nuevo Gerente, ingrese su legajo:");
            // aca pongo el menu para primer uso para el gerente
            String legajo = consolaYTeclado.obtenerEntrada();
            while (legajo.isEmpty()) {
                consolaYTeclado.mostrarString("ERROR: Debe ingresar al menos una respuesta");
                consolaYTeclado.mostrarString("Ingrese su legajo:");
                legajo = consolaYTeclado.obtenerEntrada();
            }
            consolaYTeclado.mostrarString("Ingrese su password:");
            String pass = consolaYTeclado.obtenerEntrada();
            //valido que ingrese algo
            while (pass.isEmpty()) {
                consolaYTeclado.mostrarString("ERROR: Debe ingresar al menos una respuesta");
                consolaYTeclado.mostrarString("Ingrese su password:");
                pass = consolaYTeclado.obtenerEntrada();
            }
            //Creo Gerente en el primer uso
            sistemaBurger.getSistemaDeUsuarios().getUsuarios().add(new Gerente(legajo, pass));
            //TENDRIA QUE PONER TODO EL CODIGO PARA QUE EL GERENTE EN EL PRIMER USO 
            //DE ALTA A LOS ITEM E INGREDIENTES, Y LUEGO CON sistema.getSistemaItems (new item,arrayIngredientes)
            /*---------------------------ALTA ITEM------------------------*/
            String respuesta;
            char opc;
            String nombreItem;
            String nombreIngrediente;
            ArrayList<Ingrediente> listaIngredientes;

            //Inicializo la lista de ingredientes en null para el nuevo item
            consolaYTeclado.mostrarString("Debe ingresar los items nuevos al sistema!!!");
            do {
                listaIngredientes = new ArrayList<Ingrediente>();
                consolaYTeclado.mostrarString("AGREGAR ITEM");
                consolaYTeclado.mostrarString("Ingrese nombre Item:");
                nombreItem = consolaYTeclado.obtenerEntrada();
                while (nombreItem.isEmpty()) {
                    consolaYTeclado.mostrarString("Debe ingresar un nombre para el item a ingresar");
                    consolaYTeclado.mostrarString("AGREGAR ITEM");
                    consolaYTeclado.mostrarString("Ingrese nombre Item:");
                    nombreItem = consolaYTeclado.obtenerEntrada();
                }
                do {
                    consolaYTeclado.mostrarString("Desea agregar ingredientes?");
                    consolaYTeclado.mostrarString("[1] SI");
                    consolaYTeclado.mostrarString("[2] NO");
                    opc = consolaYTeclado.leerChar();
                    respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
                    if (!Character.isDigit(opc)) {
                        opc = '*';
                    }
                    switch (opc) {
                        case '1':
                            //AGREGAR INGREDIENTES
                            do {

                                consolaYTeclado.mostrarString("Ingrese nombre ingrediente:");
                                nombreIngrediente = consolaYTeclado.obtenerEntrada();
                                while (nombreIngrediente.isEmpty()) {
                                    consolaYTeclado.mostrarString("Debe ingresar un nombre de ingrediente");
                                    consolaYTeclado.mostrarString("Ingrese nombre ingrediente:");
                                    nombreIngrediente = consolaYTeclado.obtenerEntrada();
                                }
                                listaIngredientes.add(new Ingrediente(nombreIngrediente));
                                consolaYTeclado.mostrarString("Desea agregar mas ingredientes?");
                                consolaYTeclado.mostrarString("[1] SI");
                                consolaYTeclado.mostrarString("[2] NO");
                                opc = consolaYTeclado.leerChar();
                                respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
                                //puedo poner un switch con la opcion para ver que ingreso 

                                while (!Character.isDigit(opc) || (opc != '2' && opc != '1')) {
                                    consolaYTeclado.mostrarString("ERROR: Opcion invalida!!");
                                    consolaYTeclado.mostrarString("Desea agregar mas ingredientes?");
                                    consolaYTeclado.mostrarString("[1] SI");
                                    consolaYTeclado.mostrarString("[2] NO");
                                    opc = consolaYTeclado.leerChar();
                                    respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER

                                }
                            } while (opc != '2');
                            break;
                        case '2':

                            break;
                        default:
                            consolaYTeclado.mostrarString("ERROR: Opcion invalida!!!");
                            opc = '*';
                    }

                } while (opc != '2');
                sistemaBurger.getSistemaDeItems().getListaDeItems().add(new Item(nombreItem, listaIngredientes));
                consolaYTeclado.mostrarString("Desea agregar mas item?");
                consolaYTeclado.mostrarString("[1] SI");
                consolaYTeclado.mostrarString("[2] NO");
                opc = consolaYTeclado.leerChar();
                respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
                while (!Character.isDigit(opc) || (opc != '2' && opc != '1')) {
                    consolaYTeclado.mostrarString("ERROR: Opcion invalida!!");
                    consolaYTeclado.mostrarString("Desea agregar mas item?");
                    consolaYTeclado.mostrarString("[1] SI");
                    consolaYTeclado.mostrarString("[2] NO");
                    opc = consolaYTeclado.leerChar();
                    respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
                }

            } while (opc != '2');
            /*---------------------------FIN ALTA ITEM*----------------------------*/
            try {
                sistemaBurger.serializar("sistema.txt");
                consolaYTeclado.mostrarString("El arranque ha sido exitoso. Ahora se debe reiniciar el sistema...");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            seguir = false;
        }
        while (seguir) {

            consolaYTeclado.mostrarString("BIENVENIDO!!!!");
            consolaYTeclado.mostrarString("Ingrese su legajo:");
            String legajo = consolaYTeclado.obtenerEntrada();
            while (legajo.isEmpty()) {
                consolaYTeclado.mostrarString("ERROR: El legajo no puede ser nulo.");
                consolaYTeclado.mostrarString("Ingrese su legajo:");
                legajo = consolaYTeclado.obtenerEntrada();
            }
            consolaYTeclado.mostrarString("Ingrese su password:");
            String pass = consolaYTeclado.obtenerEntrada();
            while (pass.isEmpty()) {
                consolaYTeclado.mostrarString("ERROR: El password no puede ser nulo.");
                consolaYTeclado.mostrarString("Ingrese su password:");
                pass = consolaYTeclado.obtenerEntrada();
            }
            Usuario u = sistemaBurger.getSistemaDeUsuarios().buscarUsuario(legajo + ":" + pass);

            if (u == null) {
                consolaYTeclado.mostrarString("ERROR: La combinacion usuario/password ingresada no es valida.");
            } else {
                seguir = u.ejecutarSistema(sistemaBurger);// POLIMORFISMO!!!!
            }
        }

    }
}
