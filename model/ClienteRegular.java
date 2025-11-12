package model;

public class ClienteRegular extends Cliente{
    public ClienteRegular(   int id, String nome, String email,double saldo){
        super(id, nome, email, saldo);
    }

    
    @Override
    public double aplicarDesconto(double valor) {
        return valor; 
    }


    @Override
    public String getTipo(){
        return "Regular";
    }
}