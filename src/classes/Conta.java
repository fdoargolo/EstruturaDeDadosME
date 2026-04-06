package classes;

public class Conta {
	
	private int numeroConta;
	private String titular;
	private String cpf;
	private double saldo;
	private String tipoConta;
	private String dataAbertura;
	private boolean ativa;
	//segui nomes e tipos passados pela atividade do professor
	
	public Conta(int numeroConta, String titular, String cpf, String tipoConta) {
		super();
		this.numeroConta = numeroConta;
		this.titular = titular;
		this.cpf = cpf;
		this.tipoConta = tipoConta;
		this.ativa = true;
		//saldo -> mudança apenas por deposito ou saque
		//TODO criar atribuição para dateTime.NOW() para dataabertura no construtor
	}

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void depositoConta(double valor) {
        if (valor > 0 && ativa) {
            saldo += valor;
        }
    }

    public boolean sacarConta(double valor) {
        if (valor > 0 && saldo >= valor && ativa) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean encerrarConta() {
        if (saldo == 0) {
            ativa = false;
            return true;
        }
        return false;
    }

    public void exibirConta() {
        System.out.println("Conta: " + numeroConta + " | Titular: " + titular + " | CPF: " + cpf + " | Tipo: " + tipoConta + " | Saldo: R$ " + saldo + " | Ativa: " + ativa);
    }
}
