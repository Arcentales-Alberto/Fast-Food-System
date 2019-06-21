/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bk;

import java.io.IOException;
import java.io.Serializable;
import java.util.InputMismatchException;

/**
 *
 * @author Tortuga
 */
public class Cocinero extends Usuario implements Serializable {

    public Cocinero(String legajo, String pass) {
        setLegajo(legajo);
        setPassword(pass);
    }

    @Override
    public boolean ejecutarSistema(Sistema sistemaBurger) {
        char opc;
        int numPedido;
        boolean seguir = true;
        EntradaSalida consolaYTeclado = new EntradaSalida();
        String respuesta;
        do {

            consolaYTeclado.mostrarString("COCINERO");
            consolaYTeclado.mostrarString("SELECCION UNA OPCION:");
            consolaYTeclado.mostrarString("[1] Ver pedidos para cocinar");
            consolaYTeclado.mostrarString("[2] Salir del sistema de cocinero");
            opc = consolaYTeclado.leerChar();
            respuesta = consolaYTeclado.obtenerEntrada();//limpio Buffer

            while (opc >= '2' && opc < '1') {
                consolaYTeclado.mostrarString("COCINERO");
                consolaYTeclado.mostrarString("SELECCION UNA OPCION:");
                consolaYTeclado.mostrarString("[1] Ver pedido para cocinar");
                consolaYTeclado.mostrarString("[2] Salir del sistema de cocinero");
                opc = consolaYTeclado.leerChar();
                respuesta = consolaYTeclado.obtenerEntrada();//limpio Buffer
            }
            switch (opc) {
                case '1':
                    //TOMAR PEDIDO
                    boolean error = true;
                    do {
                        if (sistemaBurger.getSistemaDePedidos().getPedidosCocinar().isEmpty()) {
                            consolaYTeclado.mostrarString("NO HAY PEDIDOS PARA COCINAR");
                            error = false;
                        } else {
                            consolaYTeclado.mostrarString("Numeros de pedido para preparar: " + sistemaBurger.getSistemaDePedidos().getPedidosCocinar().size());
                            consolaYTeclado.mostrarString("Seleccione el numero de pedido:");

                            try {
                                numPedido = consolaYTeclado.leerInt();
                                if (numPedido <= 0 || numPedido > sistemaBurger.getSistemaDePedidos().getPedidosCocinar().size()) {
                                    consolaYTeclado.mostrarString("No pedido para preparar para el numero elegido");
                                    consolaYTeclado.mostrarString("Por favor ingrese numero de pedido valido");
                                    respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
                                    error = true;
                                } else {
                                    consolaYTeclado.mostrarString("Pedido numero: " + numPedido);
                                    for (int j = 0; j < sistemaBurger.getSistemaDePedidos().getPedidosCocinar().get(numPedido - 1).getItemsPedido().getListaDeItems().size(); j++) {
                                        consolaYTeclado.mostrarString("Item: " + sistemaBurger.getSistemaDePedidos().getPedidosCocinar().get(numPedido - 1).getItemsPedido().getListaDeItems().get(j).getNombreItem());
                                        for (int k = 0; k < sistemaBurger.getSistemaDePedidos().getPedidosCocinar().get(numPedido - 1).getItemsPedido().getListaDeItems().get(j).getIngredientes().size(); k++) {
                                            consolaYTeclado.mostrarString("Ingrediente: " + sistemaBurger.getSistemaDePedidos().getPedidosCocinar().get(numPedido - 1).getItemsPedido().getListaDeItems().get(j).getIngredientes().get(k).getNombreIngrediente());
                                        }
                                    }

                                    consolaYTeclado.mostrarString("Confirmar pedido entregado");
                                    consolaYTeclado.mostrarString("[1] SI");
                                    consolaYTeclado.mostrarString("[2] NO");
                                    opc = consolaYTeclado.leerChar();
                                    respuesta = consolaYTeclado.obtenerEntrada();//Limpio BUFFER
                                    while (!Character.isDigit(opc) || (opc != '2' && opc != '1')) {
                                        consolaYTeclado.mostrarString("ERROR: Opcion invalida!!");
                                        consolaYTeclado.mostrarString("Confirmar pedido entregado");
                                        consolaYTeclado.mostrarString("[1] SI");
                                        consolaYTeclado.mostrarString("[2] NO");
                                        opc = consolaYTeclado.leerChar();
                                        respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
                                    }

                                    if (opc == '1') {
                                        sistemaBurger.getSistemaDePedidos().getPedidosEntregados().add(sistemaBurger.getSistemaDePedidos().getPedidosCocinar().get(numPedido - 1));
                                        sistemaBurger.getSistemaDePedidos().getPedidosCocinar().remove(numPedido - 1);
                                        consolaYTeclado.mostrarString("Desea seguir preparando pedidos");
                                        consolaYTeclado.mostrarString("[1] SI");
                                        consolaYTeclado.mostrarString("[2] NO");
                                        opc = consolaYTeclado.leerChar();
                                        respuesta = consolaYTeclado.obtenerEntrada();//Limpio BUFFER
                                        while (!Character.isDigit(opc) || (opc != '2' && opc != '1')) {
                                            consolaYTeclado.mostrarString("ERROR: Opcion invalida!!");
                                            consolaYTeclado.mostrarString("Desea seguir preparando pedidos");
                                            consolaYTeclado.mostrarString("[1] SI");
                                            consolaYTeclado.mostrarString("[2] NO");
                                            opc = consolaYTeclado.leerChar();
                                            respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
                                        }

                                        if (opc == '1') {
                                            error = true;
                                        } else {
                                            error = false;
                                        }
                                    } else {

                                        consolaYTeclado.mostrarString("Desea seguir preparando pedidos");
                                        consolaYTeclado.mostrarString("[1] SI");
                                        consolaYTeclado.mostrarString("[2] NO");
                                        opc = consolaYTeclado.leerChar();
                                        respuesta = consolaYTeclado.obtenerEntrada();//Limpio BUFFER
                                        while (!Character.isDigit(opc) || (opc != '2' && opc != '1')) {
                                            consolaYTeclado.mostrarString("ERROR: Opcion invalida!!");
                                            consolaYTeclado.mostrarString("Desea seguir preparando pedidos");
                                            consolaYTeclado.mostrarString("[1] SI");
                                            consolaYTeclado.mostrarString("[2] NO");
                                            opc = consolaYTeclado.leerChar();
                                            respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
                                        }

                                        if (opc == '1') {
                                            error = true;
                                        } else {
                                            error = false;
                                        }
                                    }
                                }
                            } catch (InputMismatchException ex) {
                                consolaYTeclado.mostrarString("ERROR: Ingresar numero de pedido valido");
                                respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
                                error = true;
                            }
                        }

                    } while (error);
                    opc = '1';//SIGO EN EL MENU COCINERO
                    break;

                case '2':
                    //VUELVO AL MENU INTERIOR
                    seguir = true;
                    break;

                default:
                    consolaYTeclado.mostrarString("ERROR: Opcion invalida");
                    opc = '*';
            }
            //GRABO PEDIDOS EN LISTAPEDIDOSACOCINAR 
            //SINO NO HAY QUE GUARDAR LOS PEDIDOS SACO EL TRY
/*            try {
                sistemaBurger.serializar("sistema.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
*/
        } while (opc != '2');
        return seguir;
    }

    @Override

    public String toString() {
        return "Cocinero";
    }
}
