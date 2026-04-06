package classes;

public class ListaContas {
    NoConta cabeca;

    public void cadastrarConta(Conta conta) {
        NoConta novoNo = new NoConta(conta);
        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            NoConta atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
    }

    public void listarContas() {
        NoConta atual = cabeca;
        boolean encontrou = false;
        while (atual != null) {
            if (atual.conta.isAtiva()) {
                atual.conta.exibirConta();
                encontrou = true;
            }
            atual = atual.proximo;
        }
        if (!encontrou) {
            System.out.println("Nenhuma conta ativa encontrada");
        }
    }

    public Conta buscarConta(int numeroConta) {
        NoConta atual = cabeca;
        while (atual != null) {
            if (atual.conta.getNumeroConta() == numeroConta) {
                return atual.conta;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public void removerConta(int numeroConta) {
        if (cabeca == null) {
            System.out.println("A lista de contas esta vazia");
            return;
        }

        if (cabeca.conta.getNumeroConta() == numeroConta) {
            if (cabeca.conta.getSaldo() == 0) {
                cabeca = cabeca.proximo;
                System.out.println("Conta removida");
            } else {
                System.out.println("A conta nao pode ser removida porque possui saldo");
            }
            return;
        }

        NoConta atual = cabeca;
        while (atual.proximo != null && atual.proximo.conta.getNumeroConta() != numeroConta) {
            atual = atual.proximo;
        }

        if (atual.proximo != null) {
            if (atual.proximo.conta.getSaldo() == 0) {
                atual.proximo = atual.proximo.proximo;
                System.out.println("Conta removida");
            } else {
                System.out.println("A conta nao pode ser removida porque possui saldo");
            }
        } else {
            System.out.println("Numero de conta inexistente");
        }
    }
}
