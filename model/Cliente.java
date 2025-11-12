package model;

public abstract class Cliente {
    protected int id;
    protected String nome;
    protected String email;
    protected double saldo;

    public Cliente(int id, String nome, String email, double saldo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public double getSaldo() {
        return saldo;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract String getTipo();
    public abstract double aplicarDesconto(double valor);
    
    
    
    @Override
    
    public String toString() {
        return String.format("id:[%d] | Nome:%s | Email:%s | Tipo:%s | Saldo:R$%.2f",
                id, nome, email, getTipo(), saldo);
    }
}
