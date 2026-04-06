package classes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaContas lista = new ListaContas();
        int opcao = 0;

        while (opcao != 8) {
            System.out.println("\n--- SISTEMA BANCARIO ---");
            System.out.println("1 - Cadastrar nova conta");
            System.out.println("2 - Listar todas as contas");
            System.out.println("3 - Buscar conta por numero");
            System.out.println("4 - Remover uma conta");
            System.out.println("5 - Depositar em uma conta");
            System.out.println("6 - Sacar de uma conta");
            System.out.println("7 - Encerrar conta");
            System.out.println("8 - Sair do sistema");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Numero da conta: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Titular: ");
                    String titular = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Tipo da conta (Corrente/Poupanca): ");
                    String tipo = scanner.nextLine();

                    Conta novaConta = new Conta(num, titular, cpf, tipo);
                    lista.cadastrarConta(novaConta);
                    System.out.println("Conta cadastrada.");
                    break;

                case 2:
                    lista.listarContas();
                    break;

                case 3:
                    System.out.print("Digite o numero da conta: ");
                    int numBusca = scanner.nextInt();
                    Conta cBusca = lista.buscarConta(numBusca);
                    if (cBusca != null) {
                        cBusca.exibirConta();
                    } else {
                        System.out.println("Conta inexistente.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o numero da conta a ser removida: ");
                    int numRemover = scanner.nextInt();
                    lista.removerConta(numRemover);
                    break;

                case 5:
                    System.out.print("Digite o numero da conta: ");
                    int numDep = scanner.nextInt();
                    Conta cDep = lista.buscarConta(numDep);
                    if (cDep != null) {
                        System.out.print("Digite o valor do deposito: ");
                        double valDep = scanner.nextDouble();
                        cDep.depositoConta(valDep);
                        System.out.println("Deposito realizado.");
                    } else {
                        System.out.println("Conta inexistente.");
                    }
                    break;

                case 6:
                    System.out.print("Digite o numero da conta: ");
                    int numSac = scanner.nextInt();
                    Conta cSac = lista.buscarConta(numSac);
                    if (cSac != null) {
                        System.out.print("Digite o valor do saque: ");
                        double valSac = scanner.nextDouble();
                        if (cSac.sacarConta(valSac)) {
                            System.out.println("Saque realizado.");
                        } else {
                            System.out.println("Saldo insuficiente ou conta inativa.");
                        }
                    } else {
                        System.out.println("Conta inexistente.");
                    }
                    break;

                case 7:
                    System.out.print("Digite o numero da conta a encerrar: ");
                    int numEnc = scanner.nextInt();
                    Conta cEnc = lista.buscarConta(numEnc);
                    if (cEnc != null) {
                        if (cEnc.encerrarConta()) {
                            System.out.println("Conta encerrada com sucesso.");
                        } else {
                            System.out.println("A conta precisa ter saldo zero para ser encerrada.");
                        }
                    } else {
                        System.out.println("Conta inexistente.");
                    }
                    break;

                case 8:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }
        }
        scanner.close();
    }
}