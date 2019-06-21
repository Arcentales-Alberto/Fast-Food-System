/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bk;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Tortuga
 */
public class Sistema implements Serializable {

    private SistemaUsuarios sistemaDeUsuarios;
    private SistemaItems sistemaDeItems;
    private SistemaPedidos sistemaDePedidos;

    public Sistema() {
        sistemaDeUsuarios = new SistemaUsuarios();
        sistemaDeItems = new SistemaItems();
        sistemaDePedidos = new SistemaPedidos();
    }

    public Sistema deSerializar(String a) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(a);
        ObjectInputStream o = new ObjectInputStream(f);
        Sistema s = (Sistema) o.readObject();
        o.close();
        f.close();
        return s;
    }

    public void serializar(String a) throws IOException {

        FileOutputStream f = new FileOutputStream(a);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(this);
        o.close();
        f.close();

    }

    public SistemaUsuarios getSistemaDeUsuarios() {
        return sistemaDeUsuarios;
    }

    public void setSistemaDeUsuarios(SistemaUsuarios sistemaDeUsuarios) {
        this.sistemaDeUsuarios = sistemaDeUsuarios;
    }

    public SistemaItems getSistemaDeItems() {
        return sistemaDeItems;
    }

    public void setSistemaDeItems(SistemaItems sistemaDeItems) {
        this.sistemaDeItems = sistemaDeItems;
    }

    public SistemaPedidos getSistemaDePedidos() {
        return sistemaDePedidos;
    }

    public void setSistemaDePedidos(SistemaPedidos sistemaDePedidos) {
        this.sistemaDePedidos = sistemaDePedidos;
    }

}
