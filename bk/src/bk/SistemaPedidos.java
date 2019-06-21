/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bk;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Tortuga
 */
public class SistemaPedidos implements Serializable {

    private ArrayList<Pedido> pedidosCocinar;
    private ArrayList<Pedido> pedidosEntregados;

    public SistemaPedidos() {

        pedidosCocinar = new ArrayList<Pedido>();
        pedidosEntregados = new ArrayList<Pedido>();
    }

    public Pedido buscarPedido(String datos) {
        int i = 0;
        boolean encontrado = false;
        Pedido p = null;

        /*        while (i < pedidos.size() && !encontrado) {
            p = pedidos.get(i);
            if (datos.equals(u.getLegajo() + ":" + u.getPassword())) {
                encontrado = true;
            } else {
                i++;
            }
        }
        if (!encontrado) {
            return null;
        } else {
            return p;
        }*/ return p;
    }

    public void setPedidosCocinar(ArrayList<Pedido> pedidosCocinar) {
        this.pedidosCocinar = pedidosCocinar;

    }

    public void setPedidosEntregados(ArrayList<Pedido> pedidosEntregados) {
        this.pedidosEntregados = pedidosEntregados;

    }

    public ArrayList<Pedido> getPedidosEntregados() {

        return pedidosEntregados;
    }

    public ArrayList<Pedido> getPedidosCocinar() {

        return pedidosCocinar;
    }

}
