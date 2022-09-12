
public class TContaBancaria {
	
	private int agencia;
	
	private int numero;
	
	private String nome;
	
	private String cpf;
	
	private double saldo;
	
	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public TContaBancaria() {
	}

	public TContaBancaria(int agencia, int numero, String nome, String cpf, double saldo) {
		super();
		this.agencia = agencia;
		this.numero = numero;
		this.nome = nome;
		this.cpf = cpf;
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "TContaBancaria [agencia=" + agencia + ", numero=" + numero + ", nome=" + nome + ", cpf=" + cpf
				+ ", saldo=" + saldo + "]";
	}
	
	
}
