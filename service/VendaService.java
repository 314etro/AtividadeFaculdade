package service;


import java.util.ArrayList;
import model.*;

public class VendaService {
    private ArrayList<Venda> vendas = new ArrayList<>();
    private int proximoId = 1;



    ///////////////////////////
    public void realizarVenda(Cliente cliente, Jogo jogo) {
        try {
            if (!jogo.getDisponivel()) {
                System.out.println("O jogo está indisponível para venda.");
                return;
            }

            double precoFinal = jogo.getPreco();
        
            //desconto p cada cliente
            precoFinal = cliente.aplicarDesconto(precoFinal);
            if (cliente.getSaldo() < precoFinal) {
                throw new Exception("Saldo insuficiente para comprar este jogo.");
            }

            //autlaiza status jogo indisponivel
            cliente.setSaldo(cliente.getSaldo() - precoFinal);
            jogo.setDisponivel(false);

    /////////////////////////////

            Venda venda = new Venda(proximoId++, cliente, jogo, precoFinal);
            vendas.add(venda);

            System.out.println("Venda realizada com sucesso!");
            System.out.println(venda);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    //hist vendas
    public void listarVendas() {
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda realizada ainda.");
            return;
        }

        for (Venda v : vendas) {
            System.out.println(v);
        }
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }
}
