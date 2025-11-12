package model;

import java.time.LocalDate;

public class Venda {
    private int id;
    private Cliente cliente;
    private Jogo jogo;
    private double valorTotal;
    private LocalDate dataVenda;

    public Venda(int id, Cliente cliente, Jogo jogo, double valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.jogo = jogo;
        this.valorTotal = valorTotal;
        this.dataVenda = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    @Override
    public String toString() {
        return String.format(
            "Venda #%d | Cliente: %s | Jogo: %s | Valor: R$%.2f | Data: %s",
            id, cliente.getNome(), jogo.getNome(), valorTotal, dataVenda
        );
    }
}
