import model.*;
import service.*;
import java.util.Scanner;

public class Main {

    /*
     * Integrantes do grupo:
     * 925103938 Nickolas Lucas Conceição e Silva
     * 925108290 Henrique Lima Montes de Sales
     * 925103498 Vitor Abreu Gudin
     * 925108567 Alison Alves de Aquino
     * 925108453 Thiago Rivas Tonouti
     * 925107031 Pietro Henrique Matos Cunha
     * 925104845 Vinicius Lopes de Almeida Cruz
     * 925111128 Yuri Oliveira de Souza
     * 925113524 Victor Diniz Pereira Riedel
     */

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void espaco(){
        System.out.println("");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ClienteService clienteService = new ClienteService();
        JogoService jogoService = new JogoService();
        VendaService vendaService = new VendaService();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Cadastrar Cliente"); // 2
            System.out.println("2 - Listar Clientes");// 10
            System.out.println("3 - Editar Cliente");// 4
            System.out.println("4 - Deletar Cliente");// 8

            System.out.println("5 - Cadastrar Jogo"); // 1
            System.out.println("6 - Listar Jogos");// 9
            System.out.println("7 - Editar Jogo"); // 3

            System.out.println("8 - Deletar Jogo");// 7

            System.out.println("9 - Realizar venda");// 11
            System.out.println("10 - Histórico de vendas");// 12

            System.out.println("0 - Sair");// 13

            espaco();

            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: {

                    limparTela();
                    System.out.println("\n=== Cadastro de Cliente ===");

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    //try catch digital saldo válido
                    double saldo = 0;
                    boolean valido = false;

                    while (!valido) {
                        System.out.print("Saldo inicial: R$");
                        try {
                            saldo = Double.parseDouble(scanner.nextLine().replace(',', '.'));
                            valido = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Valor inválido! Digite um número (ex: R$99.50)");
                        }
                    }

                    System.out.print("Tipo (1- Regular / 2- Premium): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    Cliente cliente;
                    if (tipo == 2) {
                        cliente = new ClientePremium(0, nome, email, saldo);
                    } else {
                        cliente = new ClienteRegular(0, nome, email, saldo);
                    }

                    clienteService.adicionar(cliente);
                    System.out.println("Cliente cadastrado!");

                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                    }

                    limparTela();

                    break;

                }

                case 2: {

                    limparTela();
                    clienteService.listar();
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                    }

                    break;
                }

                case 3: {
                    limparTela();
                    System.out.println("\n=== Editar Cliente ===");

                    clienteService.listar();
                    espaco();

                 

                    System.out.print("Digite o ID do cliente que deseja editar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();


                       Cliente cliente = clienteService.buscarId(id);
                    if (cliente == null) {
                        System.out.println("Cliente não encontrado!");
                        System.out.println("Pressione ENTER para continuar...");
                        scanner.nextLine();
                        break;
                    }

                    espaco();

                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Novo email: ");
                    String novoEmail = scanner.nextLine();

                    double novoSaldo = 0;
                    boolean saldoValido = false;

                    while (!saldoValido) {
                        try {
                            System.out.print("Novo saldo: R$");
                            novoSaldo = scanner.nextDouble();
                            scanner.nextLine();

                            if (novoSaldo < 0) {
                                System.out.println("O saldo não pode ser negativo. Tente novamente.");
                            } else {
                                saldoValido = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor inválido! Digite um número válido.");
                            scanner.nextLine(); 
                        }
                    }

                    clienteService.editar(id, novoNome, novoEmail, novoSaldo);

                    break;
                }

                case 4: {
                    System.out.println("Id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    clienteService.deletar(id);

                    break;
                }

                case 5: {
                    limparTela();
                    System.out.println("\n=== Cadastro do jogo ===");

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Gênero: ");
                    String genero = scanner.nextLine();

                    double preco = 0;
                    boolean precoValido = false;
                    while (!precoValido) {
                        System.out.print("Preço: ");
                        try {
                            preco = Double.parseDouble(scanner.nextLine().replace(',', '.'));
                            precoValido = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Preço inválido! Digite um número (ex: 79.99)");
                        }
                    }

                    System.out.print("Ano de lançamento: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        Jogo novoJogo = new Jogo(0, nome, genero, preco, ano, true);
                        jogoService.adicionar(novoJogo);
                        System.out.println("Jogo cadastrado com sucesso!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 6: {
                    jogoService.listar();
                    break;
                }

                case 7: {

                    limparTela();
                    System.out.println("\n=== Editar Jogos ===");

                    jogoService.listar();

                    espaco();

                    System.out.print("Digite o ID do jogo que deseja editar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();


                       Jogo jogo = jogoService.buscarId(id);
                    if (jogo == null) {
                        System.out.println("Jogo não encontrado!");
                        System.out.println("Pressione ENTER para continuar...");
                        scanner.nextLine();
                        break;
                    }


                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Novo genero: ");
                    String novoGenero = scanner.nextLine();

                    double novoPreco = 0;
                    boolean precoValido = false;


                    //logica editar saldo cliente
                    while (!precoValido) {
                        try {
                            System.out.print("Novo preço: R$");
                            novoPreco = scanner.nextDouble();
                            scanner.nextLine();

                            if (novoPreco < 0) {
                                System.out.println("O preço não pode ser negativo. Tente novamente.");
                            } else {
                                precoValido = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor inválido! Digite um número válido.");
                            scanner.nextLine(); 
                        }
                    }
                    jogoService.editar(id, novoNome, novoGenero, novoPreco, true);

                    break;
                }

                case 8: {
                    System.out.println("Id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    jogoService.deletar(id);

                    break;
                }

                case 9: {
                    limparTela();
                    System.out.println("=== Realizar venda ===");
                    espaco();
                    clienteService.listar();
                    espaco();

                    System.out.print("Digite o id do cliente: ");
                    int idCliente = scanner.nextInt();
                    scanner.nextLine();

                    Cliente cliente = clienteService.buscarId(idCliente);
                    if (cliente == null) {
                        System.out.println("Cliente não encontrado");
                        break;
                    }

                    jogoService.listar();

                    System.out.println("Digite o id do jogo desejado: ");
                    int idJogo = scanner.nextInt();
                    scanner.nextLine();

                    Jogo jogo = jogoService.buscarId(idJogo);
                    if (jogo == null) {
                        System.out.println("Jogo não encontrado");
                        break;

                    }

                    vendaService.realizarVenda(cliente, jogo);
                    break;
                }

                case 10: {
                    limparTela();
                    System.out.println("=== Histórico de Vendas ===");
                    vendaService.listarVendas();
                    break;
                }

                case 0: {
                    System.out.println("Encerrando...");
                    break;
                }
                default: {
                    System.out.println("Opção inválida!");
                }
            }
        }

    }
}
