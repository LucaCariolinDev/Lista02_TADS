import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		
		ArrayList<TContaBancaria> contas = new ArrayList<TContaBancaria>();
		boolean cadastrarNovaConta = true;
		boolean novaOperacao = true;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("##########################BEM-VINDO##########################");
		
		while(novaOperacao) {
			
			System.out.println("QUAL A OPERAÇÃO DESEJADA ?");
			System.out.println("1 - Cadastrar nova conta ");
			System.out.println("2 - Depositar valores em uma conta ");
			System.out.println("3 - Retirar valor de conta ");
			System.out.println("4 - Exibir Saldo ");
			System.out.println("5 - Transferir valores entre contas ");
			System.out.println("6 - Sair ");
			int operacao = in.nextInt();
			
			switch(operacao) {
				case 1:
					TContaBancaria novaConta = novaConta();
					if(buscaConta(novaConta.getAgencia(), novaConta.getNumero(), contas, false) == null)
						contas.add(novaConta);
					break;
				case 2:
					depositarValor(contas);
					break;
				case 3:
					retirarValor(contas);
					break;
				case 4:
					exibirSaldo(contas);
					break;
				case 5:
					transferir(contas);
					break;
				case 6:
					novaOperacao = false;
					break;
				default:
					System.out.println("Opção inválida");
			}
		}
    }
	
	public static TContaBancaria novaConta() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite o número da agência: ");
		int numeroAgencia = in.nextInt();
		
		System.out.println("Digite o número da conta: ");
		int numeroConta = in.nextInt();
		
		System.out.println("Digite o nome: ");
		String nome = in.next();
		
		System.out.println("Digite o CPF: ");
		String cpf = in.next();
		
		System.out.println("Digite o saldo inicial: ");
		double saldo = in.nextDouble();
		
		TContaBancaria novaConta = new TContaBancaria(numeroAgencia, numeroConta, nome, cpf, saldo);
		
		
		System.out.println(novaConta);
		
		return novaConta;
		
	}
	
	public static void depositarValor(ArrayList<TContaBancaria> contas) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite o número da agência: ");
		int numeroAgencia = in.nextInt();
		
		System.out.println("Digite o número da conta: ");
		int numeroConta = in.nextInt();
		
		System.out.println("Digite o valor a ser depositado: ");
		double valor = in.nextDouble();
		
		TContaBancaria conta = buscaConta(numeroAgencia, numeroConta, contas, true);
		
		if(conta != null)
			conta.setSaldo(conta.getSaldo() + valor);
			System.out.println("O novo saldo da conta de agência número " + numeroAgencia + ", conta número " + numeroConta + " é de : R$ " + conta.getSaldo());
		
	}
	
	public static void retirarValor(ArrayList<TContaBancaria> contas) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite o número da agência: ");
		int numeroAgencia = in.nextInt();
		
		System.out.println("Digite o número da conta: ");
		int numeroConta = in.nextInt();
		
		System.out.println("Digite o valor a ser retirado: ");
		double valor = in.nextDouble();
		
		TContaBancaria conta = buscaConta(numeroAgencia, numeroConta, contas, true);
		
		if(conta != null)
			if(conta.getSaldo() >= valor) {
				conta.setSaldo(conta.getSaldo() - valor);
				System.out.println("O novo saldo da conta de agência número " + numeroAgencia + ", conta número " + numeroConta + " é de : R$ " + conta.getSaldo());
			}
			else {
				System.out.println("Não é possível retirar o valor informado da conta de agência número " + numeroAgencia + ", conta número " + numeroConta + " pois o saldo é de : R$ " + conta.getSaldo());
			}
		
	}
	
	public static void exibirSaldo(ArrayList<TContaBancaria> contas) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite o número da agência: ");
		int numeroAgencia = in.nextInt();
		
		System.out.println("Digite o número da conta: ");
		int numeroConta = in.nextInt();
		
		TContaBancaria conta = buscaConta(numeroAgencia, numeroConta, contas, true);
		
		if(conta != null)
			System.out.println("O saldo da conta de agência número " + numeroAgencia + " conta número " + numeroConta + " é de : R$ " + conta.getSaldo());
		
	}
	
	public static void transferir(ArrayList<TContaBancaria> contas) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite o número da agência da conta que irá transferir o valor: ");
		int numeroAgencia = in.nextInt();
		
		System.out.println("Digite o número da conta que irá transferir o valor: ");
		int numeroConta = in.nextInt();
		
		System.out.println("Digite o número da agência da conta que irá receber o valor: ");
		int numeroAgenciaRecebedora = in.nextInt();
		
		System.out.println("Digite o número da conta que irá receber o valor: ");
		int numeroContaRecebedora = in.nextInt();
		
		System.out.println("Digite o valor a ser transferido: ");
		double valor = in.nextDouble();
		
		TContaBancaria contaTransferidora = buscaConta(numeroAgencia, numeroConta, contas, true);
		TContaBancaria contaRecebedora = buscaConta(numeroAgenciaRecebedora, numeroContaRecebedora, contas, true);
		
		if(contaTransferidora != null && contaRecebedora != null)
			if(contaTransferidora.getSaldo() >= valor) {
				contaTransferidora.setSaldo(contaTransferidora.getSaldo() - valor);
				contaRecebedora.setSaldo(contaRecebedora.getSaldo() + valor);
				System.out.println("O novo saldo da conta que transferiu de agência número " + numeroAgencia + ", conta número " + numeroConta + " é de : R$ " + contaTransferidora.getSaldo());
				System.out.println("O novo saldo da conta que recebeu de agência número " + numeroAgencia + ", conta número " + numeroConta + " é de : R$ " + contaRecebedora.getSaldo());
			}
			else {
				System.out.println("Não é possível transferir o valor informado da conta de agência número " + numeroAgenciaRecebedora + ", conta número " + numeroContaRecebedora + " pois o saldo é de : R$ " + contaTransferidora.getSaldo());
			}
		
	}
	
	public static TContaBancaria buscaConta(int agencia, int numeroConta, ArrayList<TContaBancaria> contas, boolean exibirMensagem) {
		for(TContaBancaria conta : contas) {
			if(conta.getAgencia() == agencia && conta.getNumero() == numeroConta) {
				return conta;
			}
		}
		
		if(exibirMensagem)
			System.out.println("Conta não encontrada");
		
		return null;
	}
}
