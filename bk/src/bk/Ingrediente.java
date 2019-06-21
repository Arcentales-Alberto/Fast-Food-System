package bk;

import java.io.Serializable;

public class Ingrediente implements Serializable {

    private String nombreIngrediente;

    public Ingrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

}
