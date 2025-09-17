package com.logisticaentrega.dao;

import com.logisticaentrega.model.Entrega;
import com.logisticaentrega.model.HistoricoEntrega;
import com.logisticaentrega.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HistoricoEntregaDAO {

    public void registrarHistorico(HistoricoEntrega historicoEntrega , Entrega entrega) throws SQLException{
        String query = """
                INSERT INTO HistoricoEntrega (entrega_id, data_evento, descricao)
                VALUES (?,?,?);
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, entrega.getId());
            stmt.setObject(2, historicoEntrega.getData_evento());
            stmt.setString(3, historicoEntrega.getDescricao());
            stmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
