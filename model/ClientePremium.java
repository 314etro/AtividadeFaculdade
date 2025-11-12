package model;

public class ClientePremium extends Cliente{

    public ClientePremium(  int id, String nome, String email, double saldo){
        super(id, nome, email, saldo);
    }

        @Override
    public double aplicarDesconto(double valor) {
        return valor * 0.9;     }

    @Override
    public String getTipo(){
        return "Premium";
    }
}