package com.logisticaentrega.dao;

import com.logisticaentrega.model.Entrega;
import com.logisticaentrega.model.Pedido;
import com.logisticaentrega.model.Motorista;
import com.logisticaentrega.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EntregaDAO {

    public void gerarEntrega (Entrega entrega, Pedido pedido, Motorista motorista) throws SQLException{
        String query = """
                    INSERT INTO (pedido_id, motorista_id, data_saida, data_entrega, status)
                    VALUES (?,?,?,?,?);
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, pedido.getId());
            stmt.setInt(2, motorista.getId());
            stmt.setObject(3, entrega.getData_saida());
            stmt.setObject(4, entrega.getData_entrega());
            stmt.setObject(5, entrega.getStatusEntrega().name());

            stmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
