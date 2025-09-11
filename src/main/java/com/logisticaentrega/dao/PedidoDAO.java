package com.logisticaentrega.dao;

import com.logisticaentrega.model.Pedido;
import com.logisticaentrega.util.Conexao;
import com.logisticaentrega.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoDAO {

    public void criarPedido(Pedido pedido, Cliente cliente) throws SQLException{
        String query = """
                INSERT INTO pedido
                (cliente_id, data_pedido, volume_m3, peso_kg, status)
                VALUES (?, ?, ?, ?, ?);
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, cliente.getId());
            stmt.setObject(2, pedido.getData_pedido());
            stmt.setInt(3, pedido.getVolumeM3());
            stmt.setInt(4, pedido.getPesoKG());
            stmt.setObject(5, pedido.getStatus_pedido());

            stmt.executeUpdate();

         }catch (SQLException e){
            e.printStackTrace();
        }

}}
