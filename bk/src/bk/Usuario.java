package bk;

import java.io.Serializable;

public abstract class Usuario implements Serializable {

    private String legajo;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLegajo() {

        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public abstract boolean ejecutarSistema(Sistema sistemaBurger);

}
