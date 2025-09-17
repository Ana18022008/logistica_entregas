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
                    INSERT INTO Entrega(pedido_id, motorista_id, data_saida, data_entrega, status)
                    VALUES (?,?,?,?,?);
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, pedido.getId());
            stmt.setInt(2, motorista.getId());
            stmt.setObject(3, entrega.getData_saida());
            stmt.setObject(4, entrega.getData_entrega());
            stmt.setString(5, entrega.getStatusEntrega().name());

            stmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizarStatus(Entrega entrega) throws SQLException{
        String query = """
                UPDATE Entrega SET status = ? where id = ?;
                """;

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, entrega.getStatusEntrega().name());
            stmt.setInt(2, entrega.getId());
            stmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void listarEntrega() throws SQLException{
        String query = """
                SELECT 
                    entrega.id AS id_entrega,
                    entrega.pedido_id AS pedido_id,
                    entrega.motorista_id AS motorista_id,
                    entrega.data_saida AS data_saida,
                    entrega.data_entrega AS data_entrega,
                    entrega.status AS status,
                    motorista.nome AS nome_motorista,
                    pedido.cliente_id AS cliente_id,
                    cliente.nome AS nome_cliente
                    
                    FROM Entrega entrega
                    
                    LEFT JOIN pedido ON entrega.pedido_id = pedido.id
                    LEFT JOIN motorista ON entrega.motorista_id = motorista.id
                    LEFT JOIN cliente ON pedido.cliente_id = cliente.id;
                """;

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
