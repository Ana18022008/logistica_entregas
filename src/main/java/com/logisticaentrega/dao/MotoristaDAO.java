package com.logisticaentrega.dao;

import com.logisticaentrega.util.Conexao;
import com.logisticaentrega.model.Motorista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotoristaDAO {

    public void cadastrarMotorista(Motorista motorista) throws SQLException{
        String query = """
                INSERT INTO motorista 
                (nome, cnh, veiculo, cidade_base)
                VALUES (?,?,?,?);
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt= conn.prepareStatement(query)){

            stmt.setString(1, motorista.getNome());
            stmt.setString(2, motorista.getCnh());
            stmt.setString(3, motorista.getVeiculo());
            stmt.setString(4, motorista.getCidadeBase());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static List<Motorista>listarMotoristas (){
        List<Motorista>motoristas = new ArrayList<>();
        String query = """
                SELECT
                id, nome, cnh, veiculo, cidade_base
                FROM motorista;
                """;

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cnh = rs.getString("cnh");
                String veiculo = rs.getString("veiculo");
                String cidade_base = rs.getString("cidade_base");

                var Motorista = new Motorista(id, nome, cnh, veiculo, cidade_base);
                motoristas.add(Motorista);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return motoristas;

    }

}
