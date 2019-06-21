package bk;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Gerente extends Usuario implements Serializable {

    public Gerente(String legajo, String pass) {
        setLegajo(legajo);
        setPassword(pass);

    }

    @Override
    public boolean ejecutarSistema(Sistema sistemaBurger) {
        char opc, opc2, opc3;
        String respuesta;
        boolean seguir = true;
        EntradaSalida consolaYTeclado = new EntradaSalida();
        do {

            consolaYTeclado.mostrarString("GERENTE DE SUCURSAL");
            consolaYTeclado.mostrarString("SELECCION UNA OPCION:");
            consolaYTeclado.mostrarString("[1] Dar de alta un Usuario");
            consolaYTeclado.mostrarString("[2] Asignar nuevo rol a usuario");
            consolaYTeclado.mostrarString("[3] Listar pedidos entregados");
            consolaYTeclado.mostrarString("[4] Dar de alta item");
            consolaYTeclado.mostrarString("[5] Salir de este menu");
            consolaYTeclado.mostrarString("[6] Salir de del sistema");
            opc = consolaYTeclado.leerChar();
            respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
            while (opc >= '7' && opc < '1') {
                consolaYTeclado.mostrarString("ERROR: Debe ingresar una opcion valida!!");
                consolaYTeclado.mostrarString("GERENTE DE SUCURSAL");
                consolaYTeclado.mostrarString("SELECCION UNA OPCION:");
                consolaYTeclado.mostrarString("[1] Dar de alta un Usuario");
                consolaYTeclado.mostrarString("[2] Asignar nuevo rol a usuario");
                consolaYTeclado.mostrarString("[3] Listar pedidos entregados");
                consolaYTeclado.mostrarString("[4] Dar de alta item");
                consolaYTeclado.mostrarString("[5] Salir de este menu");
                consolaYTeclado.mostrarString("[6] Salir de del sistema");
                opc = consolaYTeclado.leerChar();
                respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
            }
            switch (opc) {
                case '1':
                    do {
                        Usuario uPrueba;
                        consolaYTeclado.mostrarString("ALTA USUARIO");
                        consolaYTeclado.mostrarString("[1] Dar de alta un Vendedor");
                        consolaYTeclado.mostrarString("[2] Dar de alta un Cocinero");
                        consolaYTeclado.mostrarString("[3] Salir de este menu");
                        opc2 = consolaYTeclado.leerChar();

                        while (opc2 >= '4' && opc2 < '1') {
                            consolaYTeclado.mostrarString("ERROR: Opcion invalida!!");
                            consolaYTeclado.mostrarString("ALTA USUARIO");
                            consolaYTeclado.mostrarString("[1] Dar de alta un Vendedor");
                            consolaYTeclado.mostrarString("[2] Dar de alta un Cocinero");
                            consolaYTeclado.mostrarString("[3] Salir de este menu");
                            opc2 = consolaYTeclado.leerChar();

                        }

                        switch (opc2) {
                            case '1'://ALTA VENDEDOR
                                String legajo = consolaYTeclado.obtenerEntrada();//LIMPIO EL BUFER DESPUES DE UN CARACTER O UN INT
                                consolaYTeclado.mostrarString("ALTA VENDEDOR");
                                consolaYTeclado.mostrarString("Ingrese numero de legajo:");
                                legajo = consolaYTeclado.obtenerEntrada();
                                while (legajo.isEmpty()) {
                                    consolaYTeclado.mostrarString("ERROR: No puede ser nulo el legajo");
                                    consolaYTeclado.mostrarString("Ingrese numero de legajo:");
                                    legajo = consolaYTeclado.obtenerEntrada();
                                }
                                uPrueba = sistemaBurger.getSistemaDeUsuarios().buscarUsuarioPorLegajo(legajo);
                                if (uPrueba != null) {
                                    consolaYTeclado.mostrarString("ERROR: El usuario ya figura en el sistema");
                                } else {
                                    consolaYTeclado.mostrarString("Ingrese password:");
                                    String password;
                                    password = consolaYTeclado.obtenerEntrada();
                                    while (password.isEmpty()) {
                                        consolaYTeclado.mostrarString("ERROR: No puede ser nulo el password");
                                        consolaYTeclado.mostrarString("Ingrese numero de password:");
                                        password = consolaYTeclado.obtenerEntrada();
                                    }
                                    sistemaBurger.getSistemaDeUsuarios().getUsuarios().add(new Vendedor(legajo, password));
                                    consolaYTeclado.mostrarString("Se ha incorporado el VENDEDOR al sistema");
                                }
                                break;

                            case '2'://ALTA COCINERO

                                String legajoCocinero = consolaYTeclado.obtenerEntrada();//LIMPIO EL BUFER DESPUES DE UN CARACTER O UN INT
                                consolaYTeclado.mostrarString("ALTA COCINERO");
                                consolaYTeclado.mostrarString("Ingrese numero de legajo:");
                                legajoCocinero = consolaYTeclado.obtenerEntrada();
                                while (legajoCocinero.isEmpty()) {
                                    consolaYTeclado.mostrarString("ERROR: No puede ser nulo el legajo");
                                    consolaYTeclado.mostrarString("Ingrese numero de legajo:");
                                    legajoCocinero = consolaYTeclado.obtenerEntrada();
                                }
                                uPrueba = sistemaBurger.getSistemaDeUsuarios().buscarUsuarioPorLegajo(legajoCocinero);
                                if (uPrueba != null) {
                                    consolaYTeclado.mostrarString("ERROR: El usuario ya figura en el sistema");
                                } else {
                                    consolaYTeclado.mostrarString("Ingrese password:");
                                    String passwordCocinero;
                                    passwordCocinero = consolaYTeclado.obtenerEntrada();
                                    while (passwordCocinero.isEmpty()) {
                                        consolaYTeclado.mostrarString("ERROR: No puede ser nulo el password");
                                        consolaYTeclado.mostrarString("Ingrese numero de password:");
                                        passwordCocinero = consolaYTeclado.obtenerEntrada();
                                    }
                                    sistemaBurger.getSistemaDeUsuarios().getUsuarios().add(new Cocinero(legajoCocinero, passwordCocinero));
                                    consolaYTeclado.mostrarString("Se ha incorporado el COCINERO al sistema");
                                }
                                break;
                            case '3'://SALIR A MENU ANTERIOR
                                seguir = true;
                                break;
                            default:
                                consolaYTeclado.mostrarString("ERROR: Opcion invalida");
                                opc2 = '*';
                        }

                        /*NO DEBERIA SERIALIZAR ACA
                        if (opc >= '1' && opc <= '2') {
                            try {
                                sistemaBurger.serializar("sistema.txt");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }*/
                    } while (opc2 != '3');
                    break;

                case '2':
                    do {
                        consolaYTeclado.mostrarString("CAMBIO DE ROL DE UN USUARIO:");
                        consolaYTeclado.mostrarString("[1] Listar usuarios para cambiar rol");
                        consolaYTeclado.mostrarString("[2] Ingresar datos de usuario");
                        consolaYTeclado.mostrarString("[3] Salir de este menu");
                        opc = consolaYTeclado.leerChar();
                        respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
                        while (opc >= '4' && opc < '1') {
                            consolaYTeclado.mostrarString("ERROR: Opcion invalida!!");
                            consolaYTeclado.mostrarString("CAMBIO DE ROL DE UN USUARIO:");
                            consolaYTeclado.mostrarString("[1] Listar usuarios para cambiar rol");
                            consolaYTeclado.mostrarString("[2] Ingresar datos de usuario");
                            consolaYTeclado.mostrarString("[3] Salir de este menu");
                            opc = consolaYTeclado.leerChar();
                            respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
                        }

                        switch (opc) {
                            case '1'://LISTAR USUARIOS SERIALIZADOS
                                consolaYTeclado.mostrarString("LISTA DE USUARIOS");
                                consolaYTeclado.mostrarString("Legajo\t\t\tTipo de Usuario");
                                for (int i = 0; i < sistemaBurger.getSistemaDeUsuarios().getUsuarios().size(); i++) {
                                    if (sistemaBurger.getSistemaDeUsuarios().getUsuarios().size() == 1) {
                                        consolaYTeclado.mostrarString("No hay usuarios en el sistema");
                                        consolaYTeclado.mostrarString("Solo se encuentra registrado el Gerente");
                                    } else if (sistemaBurger.getSistemaDeUsuarios().getUsuarios().get(i).toString().equals("Cocinero")) {
                                        consolaYTeclado.mostrarString(sistemaBurger.getSistemaDeUsuarios().getUsuarios().get(i).getLegajo() + "\t\t\tCOCINERO");
                                    } else if (sistemaBurger.getSistemaDeUsuarios().getUsuarios().get(i).toString().equals("Vendedor")) {
                                        consolaYTeclado.mostrarString(sistemaBurger.getSistemaDeUsuarios().getUsuarios().get(i).getLegajo() + "\t\t\tVENDEDOR");
                                    }
                                }
                                break;

                            case '2':
                                String legajoUsuario;
                                consolaYTeclado.mostrarString("CAMBIAR ROL USUARIO");
                                consolaYTeclado.mostrarString("Ingrese numero de legajo:");
                                legajoUsuario = consolaYTeclado.obtenerEntrada();
                                while (legajoUsuario.isEmpty()) {
                                    consolaYTeclado.mostrarString("ERROR: No puede ser nulo el legajo");
                                    consolaYTeclado.mostrarString("Ingrese numero de legajo:");
                                    legajoUsuario = consolaYTeclado.obtenerEntrada();
                                }
                                Usuario u = sistemaBurger.getSistemaDeUsuarios().buscarUsuarioPorLegajo(legajoUsuario);
                                if (u != null) {
                                    //CAMBIAR INTANCE OF POR UN METODO EN USUARIO TOSTRIGN QUE ME DEVUELVA QUE TIPO DE USUARIO ES
                                    switch (u.toString()) {
                                        case "Cocinero":
                                            do {
                                                consolaYTeclado.mostrarString("El Usuario esta asignado al rol de Cocinero");
                                                consolaYTeclado.mostrarString("Desea cambiar rol a Vendedor?");
                                                consolaYTeclado.mostrarString("[1] SI");
                                                consolaYTeclado.mostrarString("[2] NO");
                                                opc3 = consolaYTeclado.leerChar();
                                                respuesta = consolaYTeclado.obtenerEntrada();
                                                while (!Character.isDigit(opc3) || (opc3 != '2' && opc3 != '1')) {
                                                    consolaYTeclado.mostrarString("ERROR: Opcion invalida!!");
                                                    consolaYTeclado.mostrarString("Desea cambiar rol a Vendedor?");
                                                    consolaYTeclado.mostrarString("[1] SI");
                                                    consolaYTeclado.mostrarString("[2] NO");
                                                    opc3 = consolaYTeclado.leerChar();
                                                    respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
                                                }
                                                if (opc3 == '1') {

                                                    sistemaBurger.getSistemaDeUsuarios().cambioRolAVendedor(legajoUsuario);
                                                    opc3 = '2';
                                                    consolaYTeclado.mostrarString("SE REALIZO EL CAMBIO DE ROL CON EXITO");
                                                } else if (opc3 == '2') {
                                                    consolaYTeclado.mostrarString("Se cancelo el cambio de rol");

                                                }
                                            } while (opc3 != '2');
                                            break;
                                        case "Vendedor":
                                            do {
                                                consolaYTeclado.mostrarString("El Usuario esta asignado al rol de Vendedor");
                                                consolaYTeclado.mostrarString("Desea cambiar rol a Cocinero?");
                                                consolaYTeclado.mostrarString("[1] SI");
                                                consolaYTeclado.mostrarString("[2] NO");
                                                opc3 = consolaYTeclado.leerChar();
                                                respuesta = consolaYTeclado.obtenerEntrada();
                                                while (!Character.isDigit(opc3) || (opc3 != '2' && opc3 != '1')) {
                                                    consolaYTeclado.mostrarString("ERROR: Opcion invalida!!");
                                                    consolaYTeclado.mostrarString("Desea cambiar rol a Cocinero?");
                                                    consolaYTeclado.mostrarString("[1] SI");
                                                    consolaYTeclado.mostrarString("[2] NO");
                                                    opc3 = consolaYTeclado.leerChar();
                                                    respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
                                                }
                                                if (opc3 == '1') {

                                                    sistemaBurger.getSistemaDeUsuarios().cambioRolACocinero(legajoUsuario);
                                                    opc3 = '2';
                                                    consolaYTeclado.mostrarString("SE REALIZO EL CAMBIO DE ROL CON EXITO");
                                                    /*try {
                                            sistemaBurger.serializar("sistema.txt");
                                            consolaYTeclado.mostrarString("Se ha realizado el cambio de rol del usuario con exito");
                                            } catch (IOException e) {
                                            e.printStackTrace();
                                            }*/
                                                } else if (opc3 == '2') {
                                                    consolaYTeclado.mostrarString("Se cancelo el cambio de rol");

                                                }
                                            } while (opc3 != '2');
                                            break;
                                        case "Gerente":
                                            consolaYTeclado.mostrarString("El usuario es Gerente de Sucursal");
                                            consolaYTeclado.mostrarString("No se puede cambiar rol");
                                            break;
                                    }
                                } else {
                                    consolaYTeclado.mostrarString("El usuario no se encuentra en el sistema");
                                    consolaYTeclado.mostrarString("Debe dar de alta a un usuario para poder cambiar un rol");
                                }
                                try {
                                    sistemaBurger.serializar("sistema.txt");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                break;
                            case '3':
                                seguir = true;
                                break;
                            default:
                                consolaYTeclado.mostrarString("ERROR: Opcion invalida");
                                opc = '*';
                        }
                    } while (opc != '3');
                    break;
                case '3':

                    if (sistemaBurger.getSistemaDePedidos().getPedidosEntregados().isEmpty()) {
                        consolaYTeclado.mostrarString("No hay pedidos entregados");
                    } else {
                        consolaYTeclado.mostrarString("Pedidos Entregados");
                        for (int i = 0; i < sistemaBurger.getSistemaDePedidos().getPedidosEntregados().size(); i++) {
                            consolaYTeclado.mostrarString("Pedido numero: " + (i + 1));
                            for (int j = 0; j < sistemaBurger.getSistemaDePedidos().getPedidosEntregados().get(i).getItemsPedido().getListaDeItems().size(); j++) {
                                consolaYTeclado.mostrarString("Item: " + sistemaBurger.getSistemaDePedidos().getPedidosEntregados().get(i).getItemsPedido().getListaDeItems().get(j).getNombreItem());
                                if (!sistemaBurger.getSistemaDePedidos().getPedidosEntregados().get(i).getItemsPedido().getListaDeItems().get(j).getIngredientes().isEmpty()) {
                                    for (int k = 0; k < sistemaBurger.getSistemaDePedidos().getPedidosEntregados().get(i).getItemsPedido().getListaDeItems().get(j).getIngredientes().size(); k++) {
                                        consolaYTeclado.mostrarString("Ingrediente: " + sistemaBurger.getSistemaDePedidos().getPedidosEntregados().get(i).getItemsPedido().getListaDeItems().get(j).getIngredientes().get(k).getNombreIngrediente());
                                    }
                                } else {
                                    consolaYTeclado.mostrarString("Sin ingredientes");
                                }
                            }
                        }
                    }
                    break;

                case '4':
                    String nombreItem;
                    String nombreIngrediente;
                    ArrayList<Ingrediente> listaIngredientes;

                    do {
                        listaIngredientes = new ArrayList<Ingrediente>();
                        consolaYTeclado.mostrarString("AGREGAR ITEM");
                        consolaYTeclado.mostrarString("Ingrese nombre Item:");
                        nombreItem = consolaYTeclado.obtenerEntrada();
                        while (nombreItem.isEmpty()) {
                            consolaYTeclado.mostrarString("Debe ingresar una respuesta\n");
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
                            while (!Character.isDigit(opc) || (opc != '2' && opc != '1')) {
                                consolaYTeclado.mostrarString("ERROR: Opcion invalida!!");
                                consolaYTeclado.mostrarString("Desea agregar ingredientes?");
                                consolaYTeclado.mostrarString("[1] SI");
                                consolaYTeclado.mostrarString("[2] NO");
                                opc = consolaYTeclado.leerChar();
                                respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
                            }
                            switch (opc) {
                                case '1':
                                    //AGREGAR INGREDIENTES
                                    do {
                                        consolaYTeclado.mostrarString("Ingrese nombre ingrediente:");
                                        nombreIngrediente = consolaYTeclado.obtenerEntrada();
                                        while (nombreIngrediente.isEmpty()) {
                                            consolaYTeclado.mostrarString("Debe ingresar una respuesta");
                                            consolaYTeclado.mostrarString("Ingrese nombre ingrediente:");
                                            nombreIngrediente = consolaYTeclado.obtenerEntrada();
                                        }
                                        listaIngredientes.add(new Ingrediente(nombreIngrediente));
                                        consolaYTeclado.mostrarString("Desea agregar mas ingredientes?");
                                        consolaYTeclado.mostrarString("[1] SI");
                                        consolaYTeclado.mostrarString("[2] NO");
                                        opc = consolaYTeclado.leerChar();
                                        respuesta = consolaYTeclado.obtenerEntrada();//LIMPIO BUFFER
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
                    break;

                case '5':

                    return seguir;

                case '6':
                    seguir = false;
                    break;
                default:
                    consolaYTeclado.mostrarString(
                            "ERROR: Opcion invalida");
                    opc = '*';
            }

            if (opc >= '1' && opc <= '2') {
                try {
                    sistemaBurger.serializar("sistema.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } while (opc != '6');
        return seguir;
    }

    @Override

    public String toString() {
        return "Gerente";
    }

}
