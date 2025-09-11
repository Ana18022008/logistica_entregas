package com.logisticaentrega.service;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import com.logisticaentrega.dao.ClienteDAO;
import com.logisticaentrega.dao.MotoristaDAO;

import com.logisticaentrega.dao.PedidoDAO;
import com.logisticaentrega.view.Atendente;
import com.logisticaentrega.model.Entrega;
import com.logisticaentrega.model.Cliente;
import com.logisticaentrega.model.Motorista;
import com.logisticaentrega.model.HistoricoEntrega;
import com.logisticaentrega.model.Pedido;
import com.logisticaentrega.model.Pedido.status;

public class Gerenciador {

    List<Entrega> listaEntregas = new ArrayList<>();
    List<Cliente> listaClientes = new ArrayList<>();
    List<Motorista> listaMotoristas = new ArrayList<>();
    List<HistoricoEntrega> listaHistoricos= new ArrayList<>();
    List<Pedido> listaPedidos = new ArrayList<>();
    Atendente atendente = new Atendente();

    public void GerenciarListas(Atendente atendente,  int escolhaMenu) {

        switch (escolhaMenu) {

            case 1 -> {
                cadastrarCliente();
            }

            case 2 -> {
                cadastrarMotorista();
            }

            case 3 -> {
                criarPedido();
            }

            case 4 -> {
                //GerarEntrega
            }

            case 5 -> {
                //RegistrarHistórico
            }

            case 6 -> {
                //Atualizar status entrega
            }

            case 7 -> {
                //Listar todas as entregas com cliente e motorista
            }

            case 8 -> {
                //- Relatório: Total de Entregas por Motorista
            }

            case 9 -> {
                // Relatório: Clientes com Maior Volume Entregue
            }

            case 10 -> {
                //- Relatório: Pedidos Pendentes por Estado
            }

            case 11 -> {
                //Relatório: Entregas Atrasadas por Cidade
            }

            case 12 -> {
                //Buscar Pedido por CPF/CNPJ do Cliente
            }

            case 13 -> {
                //Cancelar Pedido
            }

            case 14 -> {
                //- Excluir Entrega (com validação)
            }

            case 15 -> {
                //Excluir Cliente (com verificação de dependência)
            }

            case 16 -> {
                //Excluir Motorista (com verificação de dependência)
            }

            default -> {

            }
        }
    }
        public void cadastrarCliente(){

        String nome = atendente.nome("CLIENTE", "cliente");
        String cpf_cnpj = atendente.cpfCnpj();
        String endereco = atendente.endereco();
        String cidade = atendente.cidade("");
        String estado = atendente.estado();
        Cliente cliente = new Cliente(nome, cpf_cnpj, endereco, cidade, estado);
        listaClientes.add(cliente);

        var clienteDao = new ClienteDAO();
        try{
            clienteDao.cadastrarCliente(cliente);
            atendente.sucessoCadastro();
        }catch (SQLException e){
            System.out.println("Problema de conexão no banco de dados!");
            e.printStackTrace();
        }

    }

    public void cadastrarMotorista(){
        String nome = atendente.nome("MOTORISTA", "motorista");
        String cnh = atendente.cnh();
        String veiculo = atendente.veiculo();
        String cidade_base = atendente.cidade("base");
        Motorista motorista = new Motorista(nome, cnh, veiculo, cidade_base);

        var motoristaDAO = new MotoristaDAO();

        try{
            motoristaDAO.cadastrarMotorista(motorista);
            atendente.sucessoCadastro();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void criarPedido() {
        Cliente cliente = atendente.cliente();
        LocalDate data = atendente.data_pedido();
        int volume = atendente.volumeM3();
        int peso = atendente.peso();
        Pedido.status status = atendente.Status();

        Pedido pedido = new Pedido(cliente, data, volume, peso, status);
        PedidoDAO pedidoDAO = new PedidoDAO();

        try {
            pedidoDAO.criarPedido(pedido, cliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
