package bk;

import java.io.Serializable;
import java.util.ArrayList;

public class SistemaUsuarios implements Serializable {

    private ArrayList<Usuario> usuarios;

    public SistemaUsuarios() {

        usuarios = new ArrayList<Usuario>();
    }

//Archivo de Usuarios
    public Usuario buscarUsuario(String datos) {
        int i = 0;
        boolean encontrado = false;
        Usuario u = null;

        while (i < usuarios.size() && !encontrado) {
            u = usuarios.get(i);
            if (datos.equals(u.getLegajo() + ":" + u.getPassword())) {
                encontrado = true;
            } else {
                i++;
            }
        }
        if (!encontrado) {
            return null;
        } else {
            return u;
        }
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Usuario> getUsuarios() {

        return usuarios;
    }

    public Usuario buscarUsuarioPorLegajo(String legajo) {
        int i = 0;
        boolean encontrado = false;
        Usuario u = null;

        while (i < usuarios.size() && !encontrado) {
            u = usuarios.get(i);
            if (legajo.equals(u.getLegajo())) {
                encontrado = true;
            } else {
                i++;
            }
        }
        if (!encontrado) {
            return null;
        } else {
            return u;
        }
    }
// ver si lo puedo simplificar 

    public void cambioRolAVendedor(String legajo) {
        int i = 0;
        Usuario u;
        while (i < usuarios.size()) {
            u = usuarios.get(i);
            if (legajo.equals(u.getLegajo())) {
                usuarios.set(i, new Vendedor(u.getLegajo(), u.getPassword()));
                break;
            } else {
                i++;
            }
        }

    }

    public void cambioRolACocinero(String legajo) {
        int i = 0;
        Usuario u;
        while (i < usuarios.size()) {
            u = usuarios.get(i);
            if (legajo.equals(u.getLegajo())) {
                usuarios.set(i, new Cocinero(u.getLegajo(), u.getPassword()));
                break;
            } else {
                i++;
            }
        }

    }

}
