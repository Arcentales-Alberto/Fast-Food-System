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
public class SistemaItems implements Serializable{

    private ArrayList<Item> listaDeItems;

    public SistemaItems() {
        listaDeItems = new ArrayList<Item>();

    }

    public ArrayList<Item> getListaDeItems() {
        return listaDeItems;
    }

    public void setListaDeItems(ArrayList<Item> items) {
        this.listaDeItems = items;

    }

}
