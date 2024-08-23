package sistemabancario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static GerenciadoraClientes gerClientes;
    static GerenciadoraContas gerContas;

    public static void main(String[] args) {

        inicializaSistemaBancario();

        Scanner sc = new Scanner(System.in);
        boolean continua = true;

        while (continua) {
            printMenu();

            int opcao = sc.nextInt();

            switch (opcao) {
                //Consultar por um cliente
                case 1:
                    System.out.println("Digite o ID do cliente");
                    int idCliente = sc.nextInt();
                    Cliente cliente = gerClientes.pesquisaCliente(idCliente);
                    if (cliente != null) {
                        System.out.println(cliente.toString());
                    } else {
                        System.out.println("Cliente nao encontrado!");
                    }
                    break;

                //Consultar por uma conta
                case 2:
                    System.out.println("Digite o ID da conta");
                    int idConta = sc.nextInt();
                    ContaCorrente contaCorrente = gerContas.pesquisaConta(idConta);
                    if (contaCorrente != null) {
                        System.out.println(contaCorrente);
                    } else {
                        System.out.println("Conta nao encontrada!");
                    }
                    break;

                //Sair
                case 3:
                    continua = false;
                    System.out.println("############ SISTEMA ENCERRADO, ATÉ A PRÓXIMA ############");
                    break;
            }
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println("O que você deseja fazer?");
        System.out.println("1) Consultar por um cliente");
        System.out.println("2) Consultar por uma conta");
        System.out.println("3) Sair");
        System.out.println();
    }

    private static void inicializaSistemaBancario() {
        List<ContaCorrente> contasDoBanco = new ArrayList<>();
        List<Cliente> clientesDoBanco = new ArrayList<>();

        ContaCorrente conta01 = new ContaCorrente(1, 0, true);
        ContaCorrente conta02 = new ContaCorrente(2, 0, true);
        contasDoBanco.add(conta01);
        contasDoBanco.add(conta02);

        Cliente cliente01 = new Cliente(1, "João da Silva", 20, "joao@gmail.com", conta01.getId(), true);
        Cliente cliente02 = new Cliente(2, "Maria da Silva", 18, "maria@gmail.com", conta02.getId(), true);

        clientesDoBanco.add(cliente01);
        clientesDoBanco.add(cliente02);

        gerClientes = new GerenciadoraClientes(clientesDoBanco);
        gerContas = new GerenciadoraContas(contasDoBanco);
    }
}
