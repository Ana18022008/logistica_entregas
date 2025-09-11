package com.logisticaentrega.view;

import java.util.Scanner;

import com.logisticaentrega.model.Cliente;
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


    public LocalDate data_pedido(){
        System.out.print("\n - Data do pedido -  \n > ");
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

public void sair(){
    System.out.println("Saindo...");
}

public void sucessoCadastro(){
    System.out.print("\n Cadastro feito com sucesso");
}


}