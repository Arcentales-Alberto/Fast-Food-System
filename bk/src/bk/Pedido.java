package bk;

import java.io.Serializable;

public class Pedido implements Serializable {

    SistemaItems itemsPedido;

    public Pedido(SistemaItems itemsPedido) {
        this.itemsPedido = itemsPedido;
    }

    public SistemaItems getItemsPedido() {
        return itemsPedido;
    }

    public void setItemsPedido(SistemaItems itemsPedido) {
        this.itemsPedido = itemsPedido;
    }

}
