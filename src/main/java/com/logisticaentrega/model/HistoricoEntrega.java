package com.logisticaentrega.model;

import java.util.Date;

public class HistoricoEntrega {
private int id;
private Entrega entrega_id;
private Date data_evento;
private String descricao;

    public HistoricoEntrega(int id, Entrega entrega_id, Date data_evento, String descricao) {
        this.id = id;
        this.entrega_id = entrega_id;
        this.data_evento = data_evento;
        this.descricao = descricao;
    }

    public HistoricoEntrega(Entrega entrega_id, Date data_evento, String descricao) {
        this.entrega_id = entrega_id;
        this.data_evento = data_evento;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Entrega getEntrega_id() {
        return entrega_id;
    }

    public void setEntrega_id(Entrega entrega_id) {
        this.entrega_id = entrega_id;
    }

    public Date getData_evento() {
        return data_evento;
    }

    public void setData_evento(Date data_evento) {
        this.data_evento = data_evento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}


