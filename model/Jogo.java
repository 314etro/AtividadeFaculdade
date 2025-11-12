package model;

public class Jogo {
    private int id;
    private String nome;
    private String genero;
    private double preco;
    private int anoLancamento;

    private boolean disponivel;

   public Jogo(int id, String nome, String genero, double preco, int anoLancamento, boolean disponivel) {
        if (anoLancamento > 2025) {
            throw new IllegalArgumentException("Ano de lançamento inválido! Não pode ser maior que o ano atual 2025.");
        }

        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.preco = preco;
        this.anoLancamento = anoLancamento;
        this.disponivel = disponivel;
    }

    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public String getGenero(){
        return genero;
    }
    public double getPreco(){
        return preco;
    }

    public boolean getDisponivel(){
        return disponivel;
    }

     public int getAnoLancamento() {
        return anoLancamento;
    }



    public void setNome(String nome){
        this.nome = nome;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    public void setId(int id){
        this.id = id;
    }



    
    public void setAnoLancamento(int anoLancamento) {
        if (anoLancamento > 2025) {
            throw new IllegalArgumentException("Ano de lançamento inválido! Deve ser até 2025.");
        }
        this.anoLancamento = anoLancamento;
    }
    
    @Override
    public String toString() {

        String status;
        if(disponivel){
            status = "disponivel";
        }else{
            status = "indisponivel";
        }


        return String.format("id:[%d] | nome:%s | genero:(%s) - R$ %.2f  | ano:%d | disponivel:%s ", id, nome, genero, preco, anoLancamento,status);
    }

  
}