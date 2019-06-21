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
public class Item implements Serializable {
//EL CONSTRUCTOR SERIA UN STRING Y UN ARRAYLIST DE INGREDIENTES

    private String nombreItem;
    private ArrayList<Ingrediente> listaIngredientes;

    public Item(String nombreItem, ArrayList<Ingrediente> listaIngredientes) {
        this.nombreItem = nombreItem;
        this.listaIngredientes = listaIngredientes;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return listaIngredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

}
