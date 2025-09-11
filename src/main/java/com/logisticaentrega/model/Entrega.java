package com.logisticaentrega.model;
import java.util.Date;

public class Entrega {

    private int id;
    private Pedido pedido_id;
    private Motorista motorista_id;
    private Date data_saida;
    private Date data_entrega;
    private status statusEntrega;

    public enum status{
        EM_ROTA, ENTREGUE, ATRASADA
    }

    public Entrega(Pedido pedido_id, Motorista motorista_id, Date data_saida, Date data_entrega, status statusEntrega) {
        this.pedido_id = pedido_id;
        this.motorista_id = motorista_id;
        this.data_saida = data_saida;
        this.data_entrega = data_entrega;
        this.statusEntrega = statusEntrega;
    }

    public Entrega(int id, Pedido pedido_id, Motorista motorista_id, Date data_saida, Date data_entrega, status statusEntrega) {
        this.id = id;
        this.pedido_id = pedido_id;
        this.motorista_id = motorista_id;
        this.data_saida = data_saida;
        this.data_entrega = data_entrega;
        this.statusEntrega = statusEntrega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Pedido pedido_id) {
        this.pedido_id = pedido_id;
    }

    public Motorista getMotorista_id() {
        return motorista_id;
    }

    public void setMotorista_id(Motorista motorista_id) {
        this.motorista_id = motorista_id;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    public Date getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    public status getStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(status statusEntrega) {
        this.statusEntrega = statusEntrega;
    }
}
