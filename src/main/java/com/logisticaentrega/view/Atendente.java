package com.logisticaentrega.view;

import java.util.Scanner;

import com.logisticaentrega.model.Cliente;
import com.logisticaentrega.model.Pedido;
import com.logisticaentrega.model.Entrega;
import com.logisticaentrega.model.Entrega.statusE;
import com.logisticaentrega.model.Motorista;

import com.logisticaentrega.model.Pedido.status;

import com.logisticaentrega.service.Gerenciador;

import java.time.LocalDate;

public class Atendente {
    Scanner sc = new Scanner(System.in);

    public void Gerenciador(){
        Gerenciador gerenciador = new Gerenciador();
    }

    public int menu() {
        System.out.println("\n---------------- MENU ------------------");
        System.out.print("""
                \n1. Cadastrar Cliente
                2. Cadastrar Motorista
                3. Criar Pedido
                4. Atribuir Pedido a Motorista
                5. Registrar Evento de Entrega 
                6. Atualizar Status da Entrega
                7. Listar Todas as Entregas com Cliente e Motorista
                8. Relatório: Total de Entregas por Motorista
                9. Relatório: Clientes com Maior Volume Entregue
                10. Relatório: Pedidos Pendentes por Estado
                11. Relatório: Entregas Atrasadas por Cidade
                12. Buscar Pedido por CPF/CNPJ do Cliente
                13. Cancelar Pedido
                14. Excluir Entrega 
                15. Excluir Cliente 
                16. Excluir Motorista 
                -------------------------------------------
                0. Sair
                -------------------------------------------
                 > 
                """);
        int respostaMenu = sc.nextInt();
        sc.nextLine();
        return respostaMenu;
    }

    public String nome(String titulo, String entidade){
        System.out.printf("-----------| %s | -------------", titulo);
        System.out.printf("\n Insira o nome do %s: \n > ", entidade);
        return sc.nextLine();
    }

    public String cpfCnpj(){
        System.out.print("\n CPF / CNPJ : \n > ");
        return sc.nextLine();
    }

    public String endereco(){
        System.out.print("\n Endereço : \n > ");
        return sc.nextLine();
    }

    public String cidade (String entidade){
        System.out.printf("\n Cidade %s: \n > ", entidade);
        return sc.nextLine();
    }

    public String estado(){
        System.out.print("\n Estado: \n > ");
        return sc.nextLine();
    }

    public String cnh(){
        System.out.println("\n CNH: \n > ");
        return sc.nextLine();
    }

    public String veiculo(){
        System.out.println("\n Veículo: \n > ");
        return sc.nextLine();
    }

    public Cliente cliente() {
        System.out.print("\n------------ PEDIDO -------------");
        System.out.print("\n ID do cliente: \n > ");
        int id = sc.nextInt();
        return new Cliente(id);
    }


    public LocalDate data(String entidade){
        System.out.printf("\n - Data %s - ", entidade);
        System.out.print("\n ANO: \n > ");
        int year = sc.nextInt();
        System.out.print("\n MÊS: \n > ");
        int month = sc.nextInt();
        System.out.print("\n DIA: \n > ");
        int day = sc.nextInt();
        return LocalDate.of(year, month, day);
    }

    public int volumeM3(){
        System.out.print("\n Volume do pedido (m³): \n > ");
        return sc.nextInt();
    }

    public int peso(){
        System.out.print("\n Peso do pedido (Kg): \n > ");
        return sc.nextInt();
    }

    public status Status(){
        System.out.println("- Status -");
        System.out.println("\n 1. Pendente \n 2. Entregue \n 3. Cancelado");
        int escolha = sc.nextInt();

        switch (escolha){
            case 1 ->{
                return status.PENDENTE;
            }
            case 2->{
                return status.ENTREGUE;
            }

            case 3->{
                return status.CANCELADO;
            }

            default -> {
                return null;
            }
        }
    }

    public Pedido pedido(){
        System.out.print("\n------------ ENTREGA -------------");
        System.out.print("\n ID do pedido: \n > ");
        int id = sc.nextInt();
        return new Pedido(id);
    }

    public Motorista motorista(){
        System.out.println("\n ID do motorista: \n > ");
        int id = sc.nextInt();
        return new Motorista(id);
    }

    public statusE status() {
        System.out.println("\n - Status - ");
        System.out.println(" 1. Em Rota \n 2. Entregue \n 3. Atrasada");
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1 -> {
                return statusE.EM_ROTA;
            }

            case 2 -> {
                return statusE.ENTREGUE;
            }

            case 3 -> {
                return statusE.ATRASADA;
            }

            default -> {
                return null;
            }
        }
    }

    public Entrega entrega(String entidade){
        System.out.printf("\n----------- %s -----------", entidade);
        System.out.print("\n ID da entrega: \n > ");
        int id = sc.nextInt();
        return new Entrega(id);
    }

    public String descricao(){
        System.out.println("\n Descrição: \n > ");
        sc.nextLine();
        String descricao = sc.nextLine();
        return descricao;
    }

    public String visualizar(Entrega entrega, Motorista motorista, Cliente cliente){
            return "\n - ENTREGAS - " +
                    "\n id : " + entrega.getId() +
                    "\n Nome do motorista : " + motorista.getNome() +
                    "\n ID do cliente : " + cliente.getId()+
                    "\n Data de saída : " + entrega.getData_saida()+
                    "\n Data de entrega : " + entrega.getData_entrega()+
                    "\n Status : " + entrega.getStatusEntrega();
        }

public void sair(){
    System.out.println("Saindo...");
}

public void sucessoCadastro(){
    System.out.print("\n Cadastro feito com sucesso");
}

public void sucessoPedido(){
    System.out.print("\n Pedido cadastrado com sucesso!");
}

public void sucessoRegistro(){
    System.out.println("\n Histórico registrado com sucesso!");
}

public void sucessoAtualizacao(){
    System.out.println("\n Item atualizado com sucesso!");
}
}