package com.logisticaentrega.model;
import java.util.Date;

public class Pedido {

    private int id;
    private Cliente cliente;
    private Date data_pedido;
    private int volumeM3;
    private int pesoKG;
    private status status_pedido;

    public enum status{
        PENDENTE, ENTREGUE, CANCELADO
    }

    public Pedido(Cliente cliente, Date data_pedido, int volumeM3, int pesoKG, status status_pedido) {
        this.cliente = cliente;
        this.data_pedido = data_pedido;
        this.volumeM3 = volumeM3;
        this.pesoKG = pesoKG;
        this.status_pedido = status_pedido;
    }

    public Pedido(int id, Cliente cliente, Date data_pedido, int volumeM3, int pesoKG, status status_pedido) {
        this.id = id;
        this.cliente = cliente;
        this.data_pedido = data_pedido;
        this.volumeM3 = volumeM3;
        this.pesoKG = pesoKG;
        this.status_pedido = status_pedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }

    public int getVolumeM3() {
        return volumeM3;
    }

    public void setVolumeM3(int volumeM3) {
        this.volumeM3 = volumeM3;
    }

    public int getPesoKG() {
        return pesoKG;
    }

    public void setPesoKG(int pesoKG) {
        this.pesoKG = pesoKG;
    }

    public status getStatus_pedido() {
        return status_pedido;
    }

    public void setStatus_pedido(status status_pedido) {
        this.status_pedido = status_pedido;
    }
}
