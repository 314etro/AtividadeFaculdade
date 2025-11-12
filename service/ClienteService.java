package service;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
//////////////////////////////

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    private int proximoId = 1;

    // metodo buscar id reutilizar
    public Cliente buscarId(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    ////////////////////////////////////////
    public void adicionar(Cliente cliente) {
        cliente.setId(proximoId);
        clientes.add(cliente);
        proximoId++;
    }

    /////////////////////////////////////////////

    public void deletar(int id) {
        Cliente cliente = buscarId(id);

        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não cadastrado");
        }
    }

    ///////////////////////////////////////////
  
    public void listar() {

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }
    /////////////////////////////////////////////

    public void editar(int id, String novoNome, String novoEmail, double novoSaldo) {

        Cliente cliente = buscarId(id);

        if (cliente != null) {
            cliente.setNome(novoNome);
            cliente.setEmail(novoEmail);
            cliente.setSaldo(novoSaldo);

            System.out.println("Cliente editado com sucesso!");

        } else {
            System.out.println("Cliente não encontrado");
        }

    }
}
/////////////////////////////////////////////////
