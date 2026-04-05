package classes;

public class NoConta {
	    Conta conta;
	    NoConta proximo;

	    NoConta(){}

	    NoConta(Conta conta) {
	        this.conta = conta;
	        this.proximo = null;
	}
}
