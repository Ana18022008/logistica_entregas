package com.logisticaentrega.model;

public class relatorios {

    public static class RelatorioMotorista{
        private Motorista motorista;
        private int totalEntrega;

        public RelatorioMotorista(Motorista motorista, int totalEntrega) {
            this.motorista = motorista;
            this.totalEntrega = totalEntrega;
        }

        public Motorista getMotorista() {
            return motorista;
        }

        public void setMotorista(Motorista motorista) {
            this.motorista = motorista;
        }

        public int getTotalEntrega() {
            return totalEntrega;
        }

        public void setTotalEntrega(int totalEntrega) {
            this.totalEntrega = totalEntrega;
        }
        @Override
        public String toString(){
            return "---------------------------" +
                    "\n- Nº de entregas - " +
                    "\n"+ motorista+
                    "\n Nº de entregas: " + totalEntrega;
        }
    }

    public static class RelatorioCliente{
        private Cliente cliente;
        private int volume;

        public RelatorioCliente(Cliente cliente, int volume) {
            this.cliente = cliente;
            this.volume = volume;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        public int getVolume() {
            return volume;
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }

        @Override
        public String toString(){
            return "\n - Volume por cliente" +
                    "\n" + cliente+
                    "\n Volume total" + volume + " m³";

        }
    }

}
