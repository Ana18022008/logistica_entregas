package org.example;

import com.logisticaentrega.service.Gerenciador;
import com.logisticaentrega.view.Atendente;

        public class Main {
            public static void main(String[] args) {
                Gerenciador gerenciador = new Gerenciador();
                Atendente atendente = new Atendente();

                int escolha = -1;

                while (escolha != 0) {
                    escolha = atendente.menu();
                    gerenciador.GerenciarListas(atendente, escolha);
                }

                atendente.sair();
            }
        }
