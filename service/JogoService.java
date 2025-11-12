package service;

import java.util.ArrayList;
import java.util.List;

import model.Jogo;

public class JogoService {
    private List<Jogo> jogos = new ArrayList<>();
    

      

    private int proximoId = 1;

    //////////////////////////////
    public Jogo buscarId(int id) {
        for (Jogo j : jogos) {
            if (j.getId() == id) {
                return j;
            }
        }
        return null;
    }

    //////////////////////////////////
    public void adicionar(Jogo jogo) {
        jogo.setId(proximoId);
        jogos.add(jogo);
        proximoId++;
    }

    //////////////////////////////////
    public void deletar(int id){
        Jogo jogo = buscarId(id);

        if (jogos != null) {
            jogos.remove(jogo);
            System.out.println("Jogo removido com sucesso!");
            
        }else{
            System.out.println("Jogo não encontrado");
        }
    }
    //////////////////////////////////
    public void listar() {
        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }

        for (Jogo j : jogos) {
            System.out.println(j);
        }
    }

    //////////
    public void editar(int id, String novoNome, String novoGenero, double novoPreco, boolean novoDisponivel) {

        Jogo jogo = buscarId(id);

        if (jogo != null) {
            jogo.setNome(novoNome);
            jogo.setGenero(novoGenero);
            jogo.setPreco(novoPreco);
            jogo.setDisponivel(novoDisponivel);

            System.out.println("Jogo editado com sucesso!");
        } else {
            System.out.println("Jogo não encontrado");
        }

    }
}