/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *
 * @author Tortuga
 */
public class Vendedor extends Usuario implements Serializable {

    public Vendedor(String legajo, String pass) {
        setLegajo(legajo);
        setPassword(pass);
    }

    @Override
    public boolean ejecutarSistema(Sistema sistemaBurguer) {
        char opc, opc2;
        boolean seguir = true;
        boolean error = true;
        EntradaSalida consolaYTeclado = new EntradaSalida();

        do {
            SistemaItems listaItemsPedido = new SistemaItems();
            consolaYTeclado.mostrarString("VENDEDOR");
            consolaYTeclado.mostrarString("SELECCION UNA OPCION:");
            consolaYTeclado.mostrarString("[1] Tomar nuevo pedido");
            consolaYTeclado.mostrarString("[2] Salir del sistema de vendedor");
            opc = consolaYTeclado.leerChar();

            switch (opc) {
                case '1':
                    int numeroItem = 0;
                    int numeroIngrediente;
                    String respuesta;
                    //respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER DESPUES DE UN INT

                    //HARDCODEO LOS INGREDIENTES QUE SE PUEDEN AGREGAR
                    ArrayList<Ingrediente> listaIngredientesHC = new ArrayList<Ingrediente>();
                    listaIngredientesHC.add(new Ingrediente("Cebolla"));
                    listaIngredientesHC.add(new Ingrediente("Lechuga"));
                    listaIngredientesHC.add(new Ingrediente("Tomate"));
                    listaIngredientesHC.add(new Ingrediente("Chedar"));
                    listaIngredientesHC.add(new Ingrediente("Barbacoa"));
                    listaIngredientesHC.add(new Ingrediente("Pepino"));
                    listaIngredientesHC.add(new Ingrediente("Bacon"));
                    listaIngredientesHC.add(new Ingrediente("Mayonesa"));
                    listaIngredientesHC.add(new Ingrediente("Mostaza"));
                    listaIngredientesHC.add(new Ingrediente("Semillas Sesamo"));
                    listaIngredientesHC.add(new Ingrediente("Hamburguesa"));
                    //Guardo el ityet que estoy trabajando
                    //Guardo la lista de ingrediente del nuevo item seleccionado
                    //SistemaIngredientes listaIngredientesProceso;
                    ArrayList<Ingrediente> listaIngredientesProceso;
                    if (sistemaBurguer.getSistemaDeItems().getListaDeItems().isEmpty()) {
                        consolaYTeclado.mostrarString("No hay items ingresados en el sistema");
                        consolaYTeclado.mostrarString("Por favor ingrese items para poder realizar ventas");
                    } else {
                        do {
                            do {
                                listaIngredientesProceso = new ArrayList<Ingrediente>();
                                consolaYTeclado.mostrarString("LISTA DE ITEMS!!");
                                consolaYTeclado.mostrarString("Seleccione numero item para pedido");
                                for (int i = 0; i < sistemaBurguer.getSistemaDeItems().getListaDeItems().size(); i++) {
                                    consolaYTeclado.mostrarString("[" + (i + 1) + "]\t" + sistemaBurguer.getSistemaDeItems().getListaDeItems().get(i).getNombreItem());
                                }

                                try {
                                    numeroItem = consolaYTeclado.leerInt();
                                    if (numeroItem <= 0 || numeroItem > sistemaBurguer.getSistemaDeItems().getListaDeItems().size()) {
                                        consolaYTeclado.mostrarString("No hay items para el numero seleccionado");
                                        consolaYTeclado.mostrarString("Por favor ingrese numero valido");
                                        respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
                                        error = true;
                                    } else { //AGREGO LOS INGREDIENTES DEL ITEM A LA LISTA PROVISORIA
                                        if (sistemaBurguer.getSistemaDeItems().getListaDeItems().get(numeroItem - 1).getIngredientes().size() != 0) {
                                            for (int i = 0; i < sistemaBurguer.getSistemaDeItems().getListaDeItems().get(numeroItem - 1).getIngredientes().size(); i++) {
                                                listaIngredientesProceso.add(sistemaBurguer.getSistemaDeItems().getListaDeItems().get(numeroItem - 1).getIngredientes().get(i));
                                            }
                                        }
                                        error = false;
                                    }
                                } catch (InputMismatchException ex) {
                                    consolaYTeclado.mostrarString("ERROR: Ingresar numero de item valido");
                                    respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
                                    error = true;
                                }
                            } while (error);
                            do {
                                consolaYTeclado.mostrarString("Seleccione opcion");
                                consolaYTeclado.mostrarString("[1] Agregar ingredientes");
                                consolaYTeclado.mostrarString("[2] Quitar ingredientes");
                                consolaYTeclado.mostrarString("[3] Saltar proceso");
                                opc2 = consolaYTeclado.leerChar();
                                respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO EL BUFFER
                                switch (opc2) {
                                    case '1':
                                        do {
                                            consolaYTeclado.mostrarString("Seleccione numero ingrediente que desea agregar al item:");
                                            for (int i = 0; i < listaIngredientesHC.size(); i++) {
                                                consolaYTeclado.mostrarString("[" + (i + 1) + "]\t" + listaIngredientesHC.get(i).getNombreIngrediente());
                                            }
                                            try {
                                                numeroIngrediente = consolaYTeclado.leerInt();
                                                if (numeroIngrediente <= 0 || numeroIngrediente > listaIngredientesHC.size()) {
                                                    consolaYTeclado.mostrarString("No hay ingrediente para el numero seleccionado");
                                                    consolaYTeclado.mostrarString("Por favor ingrese numero de ingrediente valido");
                                                    respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
                                                    error = true;
                                                } else {
                                                    listaIngredientesProceso.add(new Ingrediente(listaIngredientesHC.get(numeroIngrediente - 1).getNombreIngrediente()));
                                                    error = false;
                                                }
                                            } catch (InputMismatchException ex) {
                                                consolaYTeclado.mostrarString("ERROR: Ingresar numero de ingrediente valido");
                                                respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
                                                error = true;
                                            }

                                        } while (error);
                                        consolaYTeclado.mostrarString("Desea agregar o quitar mas ingredientes mas ingredientes al item");
                                        consolaYTeclado.mostrarString("[1] SI");
                                        consolaYTeclado.mostrarString("[2] NO");
                                        opc2 = consolaYTeclado.leerChar();
                                        respuesta = consolaYTeclado.obtenerEntrada();//Limpio BUFFER
                                        while (!Character.isDigit(opc2) || (opc2 != '2' && opc2 != '1')) {
                                            consolaYTeclado.mostrarString("ERROR: Opcion invalida!!");
                                            consolaYTeclado.mostrarString("Desea agregar o quitar mas ingredientes mas ingredientes al item");
                                            consolaYTeclado.mostrarString("[1] SI");
                                            consolaYTeclado.mostrarString("[2] NO");
                                            opc2 = consolaYTeclado.leerChar();
                                            respuesta = consolaYTeclado.obtenerEntrada();//Limpio BUFFER
                                        }

                                        if (opc2 == '2') {
                                            opc2 = '3';

                                        }//AGREGO A LA LISTA DE PEDIDOS EL ITEM PROCESADO
                                        break;
                                    case '2':

                                        if (listaIngredientesProceso.isEmpty()) {
                                            consolaYTeclado.mostrarString("El item seleccionado no tiene ingredientes para quitar");
                                            consolaYTeclado.mostrarString("Desea agregar o quitar mas ingredientes al item");
                                            consolaYTeclado.mostrarString("[1] SI");
                                            consolaYTeclado.mostrarString("[2] NO");
                                            opc2 = consolaYTeclado.leerChar();
                                            respuesta = consolaYTeclado.obtenerEntrada();//Limpio BUFFER
                                            while (!Character.isDigit(opc2) || (opc2 != '2' && opc2 != '1')) {
                                                consolaYTeclado.mostrarString("ERROR: Opcion invalida!!");
                                                consolaYTeclado.mostrarString("Desea agregar o quitar mas ingredientes al item");
                                                consolaYTeclado.mostrarString("[1] SI");
                                                consolaYTeclado.mostrarString("[2] NO");
                                                opc2 = consolaYTeclado.leerChar();

                                                respuesta = consolaYTeclado.obtenerEntrada();//Limpio BUFFER
                                            }
                                            if (opc2 == '2') {
                                                opc2 = '3'; //salgo de la opcion para agregar o quitar ingredientes
                                                break;
                                            }

                                        } else {

                                            do {
                                                consolaYTeclado.mostrarString("Selecione ingrediente que desea quitar al item:");
                                                for (int i = 0; i < listaIngredientesProceso.size(); i++) {
                                                    consolaYTeclado.mostrarString("[" + (i + 1) + "]\t" + listaIngredientesProceso.get(i).getNombreIngrediente()
                                                    );
                                                }
                                                try {
                                                    numeroIngrediente = consolaYTeclado.leerInt();
                                                    if (numeroIngrediente <= 0 || numeroIngrediente > listaIngredientesProceso.size()) {
                                                        consolaYTeclado.mostrarString("Por favor ingrese numero de ingrediente valido");
                                                        respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
                                                        error = true;
                                                    } else {
                                                        listaIngredientesProceso.remove(numeroIngrediente - 1);
                                                        error = false;
                                                    }
                                                } catch (InputMismatchException ex) {
                                                    consolaYTeclado.mostrarString("ERROR: Ingresar numero de ingrediente valido");
                                                    respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
                                                    error = true;
                                                }

                                            } while (error);

                                            consolaYTeclado.mostrarString("Desea agregar o quitar mas ingredientes al item");
                                            consolaYTeclado.mostrarString("[1] SI");
                                            consolaYTeclado.mostrarString("[2] NO");
                                            opc2 = consolaYTeclado.leerChar();
                                            respuesta = consolaYTeclado.obtenerEntrada();//Limpio BUFFER

                                            while (!Character.isDigit(opc2) || (opc2 != '2' && opc2 != '1')) {
                                                consolaYTeclado.mostrarString("ERROR: Opcion invalida!!");
                                                consolaYTeclado.mostrarString("Desea agregar o quitar mas ingredientes al item");
                                                consolaYTeclado.mostrarString("[1] SI");
                                                consolaYTeclado.mostrarString("[2] NO");
                                                opc2 = consolaYTeclado.leerChar();
                                                respuesta = consolaYTeclado.obtenerEntrada();//Limpio BUFFER
                                            }
                                        }

                                        if (opc2 == '2') {
                                            opc2 = '3';
                                        }

                                        break;

                                    case '3':

                                        break;
                                    default:
                                        consolaYTeclado.mostrarString("Debe elegir una opcion valida!!!");
                                        opc2 = '*';
                                }

                            } while (opc2 != '3');
                            listaItemsPedido.getListaDeItems().add(new Item(sistemaBurguer.getSistemaDeItems().getListaDeItems().get(numeroItem - 1).getNombreItem(), listaIngredientesProceso));
                            listaIngredientesProceso = null;
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

                    }
                    opc = 1; // por que si queda en 2 me vuelve al inicio de sistema
                    sistemaBurguer.getSistemaDePedidos().getPedidosCocinar().add(new Pedido(listaItemsPedido));
                    break;

                case '2':
                    //VUELVO AL MENU INTERIOR
                    seguir = true;
                    break;

                default:
                    consolaYTeclado.mostrarString("ERROR: Opcion invalida");
                    opc = '*';

            }
//SINO NO HAY QUE GUARDAR LOS PEDIDOS SACO EL TRY
/*
            try {
                sistemaBurguer.serializar("sistema.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
             */
        } while (opc != '2');

        return seguir;
    }

    @Override

    public String toString() {
        return "Vendedor";
    }
}
