package com.logisticaentrega.dao;

import com.logisticaentrega.model.*;
import com.logisticaentrega.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class EntregaDAO {

    public void gerarEntrega(Entrega entrega, Pedido pedido, Motorista motorista) throws SQLException {
        String query = """
                    INSERT INTO Entrega(pedido_id, motorista_id, data_saida, data_entrega, status)
                    VALUES (?,?,?,?,?);
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, pedido.getId());
            stmt.setInt(2, motorista.getId());
            stmt.setObject(3, entrega.getData_saida());
            stmt.setObject(4, entrega.getData_entrega());
            stmt.setString(5, entrega.getStatusEntrega().name());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarStatus(Entrega entrega) throws SQLException {
        String query = """
                UPDATE Entrega SET status = ? where id = ?;
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, entrega.getStatusEntrega().name());
            stmt.setInt(2, entrega.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Entrega> listarEntrega() {
        List<Entrega> entregas = new ArrayList<>();
        List<Motorista> motoristas = MotoristaDAO.listarMotoristas();
        List<Pedido> pedidos = PedidoDAO.listarPedido();

        Pedido pedido = null;
        Motorista motorista = null;

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

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_entrega");
                int id_pedido = rs.getInt("pedido_id");
                for (Pedido p : pedidos) {
                    if (p.getId() == id_pedido) {
                        pedido = p;

                        var cliente = new Cliente();
                        cliente.setId(rs.getInt("cliente_id"));
                        cliente.setNome(rs.getString("nome_cliente"));
                        ;
                        pedido.setCliente(cliente);

                        break;
                    }
                }

                int idMotorista = rs.getInt("motorista_id");
                for (Motorista m : motoristas) {
                    if (m.getId() == idMotorista) {
                        motorista = m;
                    }
                }

                Date dataS = rs.getDate("data_saida");
                LocalDate dataSaida = ((java.sql.Date) dataS).toLocalDate();

                Date dataE = rs.getDate("data_entrega");
                LocalDate dataEntrega = ((java.sql.Date) dataE).toLocalDate();

                Entrega.statusE status = Entrega.statusE.valueOf(rs.getString("status"));


                var entrega = new Entrega(id, pedido, motorista, dataSaida, dataEntrega, status);
                entregas.add(entrega);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entregas;
    }

    public static List<relatorios.RelatorioMotorista> entregaPorMotorista() {
        List<relatorios.RelatorioMotorista> relatorioMotoristas = new ArrayList<>();
        List<Motorista> motoristas = MotoristaDAO.listarMotoristas();

        String query = """
                SELECT motorista_id, COUNT(*) AS total_entregas
                FROM Entrega
                GROUP BY motorista_id;
                ;""";

        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int idMotorista = rs.getInt("motorista_id");
                int total = rs.getInt("total_entregas");

                for (Motorista m: motoristas){
                    if(m.getId() == idMotorista){
                        relatorios.RelatorioMotorista relatorio = new relatorios.RelatorioMotorista(m, total);
                        relatorioMotoristas.add(relatorio);
                        break;
                    }
                }
            }


    }catch (SQLException e){
            e.printStackTrace();

        }
return relatorioMotoristas;
    }
}


