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
	
    public void depositoConta(double valor) {} //TODO

    public void sacarConta(double valor) {} //TODO
    
    public void encerrarConta() {} //TODO	
}
