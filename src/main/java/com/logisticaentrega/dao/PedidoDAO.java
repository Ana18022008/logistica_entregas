package com.logisticaentrega.dao;

import com.logisticaentrega.model.Pedido;
import com.logisticaentrega.model.relatorios;
import com.logisticaentrega.util.Conexao;
import com.logisticaentrega.model.Cliente;
import com.logisticaentrega.dao.ClienteDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.logisticaentrega.dao.ClienteDAO.listarClientes;

public class PedidoDAO {

    public void criarPedido(Pedido pedido, Cliente cliente) throws SQLException {
        String query = """
                INSERT INTO pedido
                (cliente_id, data_pedido, volume_m3, peso_kg, status)
                VALUES (?, ?, ?, ?, ?);
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, cliente.getId());
            stmt.setObject(2, pedido.getData_pedido());
            stmt.setInt(3, pedido.getVolumeM3());
            stmt.setInt(4, pedido.getPesoKG());
            stmt.setString(5, pedido.getStatus_pedido().name());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Pedido> listarPedido() {
        List<Pedido> pedidos = new ArrayList<>();

        String query = """
                SELECT 
                id
                FROM pedido;
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");

                var pedido = new Pedido(id);
                pedidos.add(pedido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    public static List<relatorios.RelatorioCliente> volumePorCliente() {
        List<relatorios.RelatorioCliente> relatorioClientes = new ArrayList<>();
        List<Cliente> clientes = listarClientes();

        Cliente cliente = null;
        String query = """
                SELECT cliente_id, sum(volume_m3) AS volume
                FROM pedido WHERE status = 'Entregue'
                GROUP BY cliente_id;
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             ResultSet rs = stmt.executeQuery();

            int IdCliente = rs.getInt("cliente_id");
            int volume = rs.getInt("volume_m3");

            while (rs.next()) {
               for (Cliente c : clientes){
                   if (c.getId() == IdCliente){
                       cliente = c;
                       relatorios.RelatorioCliente relatorio = new relatorios.RelatorioCliente(cliente, volume);
                       relatorioClientes.add(relatorio);
                   }
               }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
     return relatorioClientes;
    }
}
